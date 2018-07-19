/*
* Copyright 2015 The CHOReVOLUTION project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.choreos.services.monitor.MonitorLogger;
import org.choreos.services.monitor.MonitorLoggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.chorevolution.idm.common.types.ArtifactType;
import eu.chorevolution.idm.common.types.EventType;
import eu.chorevolution.modelingnotations.coord.AllowedOperation;
import eu.chorevolution.modelingnotations.coord.COORDModel;
import eu.chorevolution.modelingnotations.coord.CoordFactory;
import eu.chorevolution.modelingnotations.coord.NotifyElement;
import eu.chorevolution.modelingnotations.coord.Participant;
import eu.chorevolution.modelingnotations.coord.State;
import eu.chorevolution.modelingnotations.coord.Tuple;
import eu.chorevolution.modelingnotations.coord.WaitElement;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.CoordinationChannelManager;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.CoordinationDelegateAlgorithm;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.CoordinationDelegateData;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.CoordinationDelegateFactory;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.ForwardMessagesCallback;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.GlobalStateManager;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.exception.UnknownOperationException;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.ContextData;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.CoordinationDelegateID;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.ResponseData;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.additionalMessages.AdditionalMessageNotify;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.additionalMessages.AdditionalMessageUpdate;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.priorities.CoordinationDelegatePriorityList;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.queueNotify.NotifyQueue;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.queueNotify.NotifyQueueElement;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.queueNotify.NotifyQueues;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.queueUpdate.StateWaitElement;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.queueUpdate.StatesWaitElements;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.queueUpdate.StatesWaitQueue;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.utility.Utilities;

public class CoordinationDelegateAlgorithmImpl implements CoordinationDelegateAlgorithm {

	private static Logger logger = LoggerFactory.getLogger(CoordinationDelegateAlgorithmImpl.class);

	private CoordinationDelegateID id;
	private Participant coordinationDelegateFrom;
	private GlobalStateManager globalStateManager;
	private NotifyQueues notifyQueues;
	private CoordinationDelegatePriorityList cdPriorities;
	private CoordinationChannelManager coordinationChannelManager;
	private COORDModel coord;
	private StatesWaitQueue statesWaiting;
	private MonitorLogger monitorLogger;
	private Boolean manageUpdateState;
	private Boolean performedAddOperation;

	public CoordinationDelegateAlgorithmImpl(CoordinationDelegateID id, String coordinationDelegateFrom, GlobalStateManager globalStateManager, CoordinationDelegateData data) {
		this.id = id;
		this.coord = data.getCoordModel();
		this.globalStateManager = globalStateManager;
		this.coordinationDelegateFrom = CoordFactory.eINSTANCE.createParticipant();
		this.coordinationDelegateFrom.setName(coordinationDelegateFrom);
		this.cdPriorities = data.getCdPriorities();
		this.notifyQueues = Utilities.createNotifyQueuesFromCoord(data.getCoordModel());
		this.coordinationChannelManager = data.getCoordinationChannelManager();
		this.statesWaiting = new StatesWaitQueue();
		this.monitorLogger = new MonitorLoggerImpl();
		this.manageUpdateState = true;
		this.performedAddOperation = false;
	}

	public ResponseData handleRules(AllowedOperation request, Participant coordinationDelegateFrom, ForwardMessagesCallback messagesCallback, ContextData contextData) {
		// TODO remove fakeTuple is introduced because there isn't way to choose
		// correct tuple from AllowedOperation
		// MONITOR log RECEIVING_REQUEST
		logger.info("VALUE OF PERFORMEDOPERATION: " + performedAddOperation.toString());
		Tuple fakeTuple = Utilities.getTupleFromAllowedOperation(coord.getTuples(), request);
		monitorLogger.sendEventData("WP7", Long.parseLong(id.getChoreographyID()), coordinationDelegateFrom.getName(), ArtifactType.CD, Utilities.findCDRole(CoordinationDelegateFactory.getAddressKeys()), fakeTuple == null ? "" : fakeTuple.getSourceState().getName(), fakeTuple == null ? "" : fakeTuple.getTargetState().getName(), request.getName(), null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());

		ResponseData response = new ResponseData(null);
		// BEGIN RULE 1
		logger.info("------------------------------- CD: " + coordinationDelegateFrom.getName() + " REQUEST: " + request.getName() + " BEGIN RULE 1-------------------------------");
		// check if the requested operation is known for the CD
		if (!isOperationKnown(request)) {
			throw new UnknownOperationException("------------------------------- The operation " + request + " is unknown for CD: " + coordinationDelegateFrom.getName() + "-------------------------------");
		}

		// RULE 1.1.5 else if part
		if (isTupleNotAllowedFromCurrentState(request) || performedAddOperation) { // [AG] Force algorithm to sleep if add_product has already been performed
			// MONITOR log WAIT_UPDATE_STATE_BEFORE
			monitorLogger.sendEventData("WP7", Long.parseLong(id.getChoreographyID()), coordinationDelegateFrom.getName(), ArtifactType.CD, Utilities.findCDRole(CoordinationDelegateFactory.getAddressKeys()), fakeTuple == null ? "" : fakeTuple.getSourceState().getName(), fakeTuple == null ? "" : fakeTuple.getTargetState().getName(), request.getName(), null, EventType.WAIT_UPDATE_STATE_BEFORE, System.currentTimeMillis());

			waitUpdateState(request);
			// MONITOR log WAIT_UPDATE_STATE_AFTER
			monitorLogger.sendEventData("WP7", Long.parseLong(id.getChoreographyID()), coordinationDelegateFrom.getName(), ArtifactType.CD, Utilities.findCDRole(CoordinationDelegateFactory.getAddressKeys()), fakeTuple == null ? "" : fakeTuple.getSourceState().getName(), fakeTuple == null ? "" : fakeTuple.getTargetState().getName(), request.getName(), null, EventType.WAIT_UPDATE_STATE_AFTER, System.currentTimeMillis());
		}

		// RULE 1.1 if part
		// if (isTupleAllowedFromCurrentState(request)) {
		// tau is allowed from s
		Tuple t = getTupleAllowedFromCurrentState(request);
		// handleRulesManagedTuple = t;

		// MONITOR log FORWARDING_REQUEST
		monitorLogger.sendEventData("WP7", Long.parseLong(id.getChoreographyID()), coordinationDelegateFrom.getName(), ArtifactType.CD, Utilities.findCDRole(CoordinationDelegateFactory.getAddressKeys()), t == null ? "" : t.getSourceState().getName(), t == null ? "" : t.getTargetState().getName(), request.getName(), null, EventType.FORWARDING_REQUEST, System.currentTimeMillis());

		logger.info("------------------------------- CD: " + coordinationDelegateFrom.getName() + " FORWARD OPERATION: " + request.getName() + " TO " + coordinationDelegateFrom.getName().split("-")[2] + " -------------------------------");
		response = messagesCallback.forwardMessage(contextData);
		// MONITOR log RECEIVING_RESPONSE
		monitorLogger.sendEventData("WP7", Long.parseLong(id.getChoreographyID()), coordinationDelegateFrom.getName(), ArtifactType.CD, Utilities.findCDRole(CoordinationDelegateFactory.getAddressKeys()), t == null ? "" : t.getSourceState().getName(), t == null ? "" : t.getTargetState().getName(), request.getName(), null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());

		// [AG] FORCE ALGORITHM TO ALLOW ADD_PRODUCT ONLY FOR THE FIRST TIME
		if(request.getName().equals("add_product")) {
			performedAddOperation = true;
			logger.info("SET PERFORMED OPERATION AT TRUE");
		}

		updateGlobalState(t.getSourceState(), t.getTargetState());
		sendUpdateCurrentState(t, t);
		stepOver(t, globalStateManager.getCurrentState());
		// }

		// MONITOR log FORWARDING_RESPONSE
		monitorLogger.sendEventData("WP7", Long.parseLong(id.getChoreographyID()), coordinationDelegateFrom.getName(), ArtifactType.CD, Utilities.findCDRole(CoordinationDelegateFactory.getAddressKeys()), t == null ? "" : t.getSourceState().getName(), t == null ? "" : t.getTargetState().getName(), request.getName(), null, EventType.FORWARDING_RESPONSE, System.currentTimeMillis());

		logger.info("------------------------------- CD: " + coordinationDelegateFrom.getName() + " END RULE 1 FOR REQUEST " + request.getName() + " -------------------------------");

		return response;
	}

	// RULE 2
	public void receiveUpdateCurrentState(AdditionalMessageUpdate additionalMessage) {
		logger.info("------------------------------- CD: " + coordinationDelegateFrom.getName() + " RECEIVED UPDATE(" + additionalMessage.getState() + ") FROM CD " + additionalMessage.getCoordinationDelegateFrom() + " -------------------------------");
		State newState = CoordFactory.eINSTANCE.createState();
		newState.setName(additionalMessage.getState());
		AtomicReference<StatesWaitElements> statesWaitElements = statesWaiting.getWaitElements(newState);
		// CD is not waiting for the UPDATE
		if (statesWaitElements == null) {
			logger.info("-------------------------------CD " + coordinationDelegateFrom.getName() + " IS NOT WAITING FOR UPDATE ADD_STATE_BEFORE(" + newState.getName() + ") -------------------------------");
			globalStateManager.addState(newState);
			logger.info("-------------------------------CD " + coordinationDelegateFrom.getName() + " IS NOT WAITING FOR UPDATE ADD_STATE_AFTER(" + newState.getName() + ") -------------------------------");
		}
		// CD is waiting for the UPDATE
		else {
			logger.info("------------------------------- CD " + coordinationDelegateFrom.getName() + " WAS WAITING FOR UPDATE(" + newState.getName() + ") -------------------------------");
			StateWaitElement stateWaitElement = statesWaitElements.get().getStateWaitElement(newState);
			updateGlobalState(stateWaitElement.getSourceWaitState(), stateWaitElement.getWaitState());
			statesWaiting.removeStatesWaitElements(statesWaitElements);
			logger.info("------------------------------- NOW CD " + coordinationDelegateFrom.getName() + " CAN PROCEED ITS EXECUTION FOR REQUEST " + getAllowedOperationFromSourceState(stateWaitElement.getWaitState()) + " -------------------------------");
			synchronized (statesWaitElements) {
				statesWaitElements.notify();
			}
		}

	}

	public String getAllowedOperationFromSourceState(State state) {

		String operation = null;
		for (Tuple tuple : coord.getTuples()) {
			if (tuple.getSourceState().getName().equals(state.getName()) && evaluateCondition(tuple)) {
				operation = tuple.getAllowedOperation().getName();
			}
		}
		return operation;
	}

	private void waitUpdateState(AllowedOperation request) {

		List<Tuple> tuples = getTuples(request);
		AtomicReference<StatesWaitElements> statesWaitElements;

		for (Tuple tuple : tuples) {
			if (globalStateManager.hasState(tuple.getSourceState()) && !performedAddOperation) { // [AG] FORCE WAIT
				return;
			}
		}

		synchronized (statesWaiting) {
			statesWaitElements = statesWaiting.addStatesWaitElements(globalStateManager.getCurrentState(), tuples);
		}
		// here an UPDATE can be received so the WAIT will endless???
		synchronized (statesWaitElements) {
			try {
				logger.info("------------------------------- CD: " + coordinationDelegateFrom.getName() + " WAIT UPDATE " + statesWaitElements + " FOR REQUEST: " + request.getName() + " -------------------------------");
				statesWaitElements.wait();
			} catch (InterruptedException e) {
				logger.info(e.getMessage());
			}
		}
	}

	public CoordinationDelegateID getId() {
		return id;
	}

	public void setId(CoordinationDelegateID id) {
		this.id = id;
	}

	private boolean isOperationKnown(AllowedOperation request) {

		for (Tuple tuple : coord.getTuples()) {
			if (tuple.getAllowedOperation() != null && request.getName().equals(tuple.getAllowedOperation().getName())) {
				return true;
			}
		}
		return false;
	}

	private boolean isTupleAllowedFromCurrentState(AllowedOperation request) {

		for (Tuple tuple : coord.getTuples()) {
			if (tuple.getAllowedOperation() != null && request.getName().equals(tuple.getAllowedOperation().getName()) && evaluateCondition(tuple) && globalStateManager.hasState(tuple.getSourceState())) {
				return true;
			}
		}
		return false;
	}

	private boolean isTupleNotAllowedFromCurrentState(AllowedOperation request) {

		boolean result = true;
		for (Tuple tuple : coord.getTuples()) {
			if (tuple.getAllowedOperation() != null && request.getName().equals(tuple.getAllowedOperation().getName()) && evaluateCondition(tuple) && globalStateManager.hasState(tuple.getSourceState())) {
				result = false;
			}
		}
		return result;
	}

	// RULE 3
	/* WITH MULTIPLE QUEUES */
	public void receiveNotify(AdditionalMessageNotify additionalMessageNotify) {

		logger.info("------------------------------- CD: " + coordinationDelegateFrom.getName() + " RECEIVED NOTIFY(" + additionalMessageNotify.getPrecedessor() + "," + additionalMessageNotify.getCoordinationDelegateFrom() + "," + additionalMessageNotify.getJoin() + ") FROM CD " + additionalMessageNotify.getCoordinatedServiceEndpointName() + " -------------------------------");
		State join = CoordFactory.eINSTANCE.createState();
		join.setName(additionalMessageNotify.getJoin());
		State predecessor = CoordFactory.eINSTANCE.createState();
		predecessor.setName(additionalMessageNotify.getPrecedessor());
		Participant coordinationDelegate = CoordFactory.eINSTANCE.createParticipant();
		coordinationDelegate.setName(additionalMessageNotify.getCoordinationDelegateFrom());
		NotifyQueueElement notifyQueueElement = new NotifyQueueElement(predecessor, coordinationDelegate, join);
		// get the NotifyQueue that contains the NOTIFY message just received
		NotifyQueue notifyQueue = notifyQueues.getNotifyQueue(notifyQueueElement);
		// remove the NotifyQueueElement from the NotifyQueue
		notifyQueue.removeNotifyQueueElement(notifyQueueElement);
		// if the queue is empty this means that the CD has received all the
		// NOTIFY that was waiting
		if (notifyQueue.checkAndNotifyQueueEmpty())
			logger.info("------------------------------- CD " + coordinationDelegateFrom.getName() + " HAS RECEIVED ALL NOTIFY -------------------------------");
	}

	/* WITH MULTIPLE QUEUES */
	private void waitForAllNotify(Tuple handleRulesManagedTuple, Tuple t) {

		NotifyQueue notifyQueue = null;
		// check if the tuple has a wait element
		if (t.getWait() != null) {
			// search for the NotifyQueue containing the wait information of the
			// tuple
			for (WaitElement waitEl : t.getWait().getElements()) {
				for (Participant participant : waitEl.getParticipants()) {
					notifyQueue = notifyQueues.getNotifyQueue(waitEl.getState(), participant, t.getTargetState());
				}
				// stop the search at first match found because only the
				// reference to the NotifyQueue is needed
				if (notifyQueue != null)
					break;
			}
			// NotifyQueue found means that
			// the CD has to wait some notifies for the tuple
			if (notifyQueue != null) {
				// MONITOR log WAIT_ALL_NOTIFY_BEFORE
				monitorLogger.sendEventData("WP7", Long.parseLong(id.getChoreographyID()), coordinationDelegateFrom.getName(), ArtifactType.CD, Utilities.findCDRole(CoordinationDelegateFactory.getAddressKeys()), handleRulesManagedTuple == null ? "" : handleRulesManagedTuple.getSourceState().getName(), handleRulesManagedTuple == null ? "" : handleRulesManagedTuple.getTargetState().getName(), handleRulesManagedTuple.getAllowedOperation().getName(), null, EventType.WAIT_ALL_NOTIFY_BEFORE, System.currentTimeMillis());

				logger.info("------------------------------- CD " + coordinationDelegateFrom.getName() + " WAIT FOR  " + notifyQueue + " -------------------------------");

				notifyQueue.waitAllNotify();

				// MONITOR log WAIT_ALL_NOTIFY_AFTER
				monitorLogger.sendEventData("WP7", Long.parseLong(id.getChoreographyID()), coordinationDelegateFrom.getName(), ArtifactType.CD, Utilities.findCDRole(CoordinationDelegateFactory.getAddressKeys()), handleRulesManagedTuple == null ? "" : handleRulesManagedTuple.getSourceState().getName(), handleRulesManagedTuple == null ? "" : handleRulesManagedTuple.getTargetState().getName(), handleRulesManagedTuple.getAllowedOperation().getName(), null, EventType.WAIT_ALL_NOTIFY_AFTER, System.currentTimeMillis());

			}
			// NotifyQueuesElement not found means that
			// the CD has already received all the notifies for the tuple so it
			// doesn't have to wait
		}

	}

	private Tuple getTupleAllowedFromCurrentState(AllowedOperation request) {

		for (Tuple tuple : coord.getTuples()) {
			if (tuple.getAllowedOperation() != null && tuple.getAllowedOperation().getName().equals(request.getName()) && globalStateManager.hasState(tuple.getSourceState())) {
				return tuple;
			}
		}
		return null;
	}

	private List<Tuple> getTuples(AllowedOperation request) {

		List<Tuple> tuples = new ArrayList<Tuple>();
		for (Tuple tuple : coord.getTuples()) {
			if (tuple.getAllowedOperation() != null && tuple.getAllowedOperation().getName().equals(request.getName())) {
				tuples.add(tuple);
			}
		}
		return tuples;
	}

	private void updateGlobalState(State stateold, State statenew) {
		globalStateManager.updateState(stateold, statenew);
	}

	private void sendUpdateCurrentState(Tuple handleRulesManagedTuple, Tuple t) {

		if (t.getAllowedComponentInTargetState() != null) {
			for (Participant coordinationDelegateTo : t.getAllowedComponentInTargetState()) {
				AdditionalMessageUpdate additionalMessage = new AdditionalMessageUpdate();
				additionalMessage.setChoreographyID(id.getChoreographyID());
				additionalMessage.setCoordinatedServiceEndpointName(id.getCoordinatedServiceEndpointName());
				additionalMessage.setCoordinationDelegateFrom(coordinationDelegateFrom.getName());
				additionalMessage.setCoordinationDelegateTo(coordinationDelegateTo.getName());
				if (t.getAllowedOperation() != null)
					additionalMessage.setRequest(t.getAllowedOperation().getName());
				additionalMessage.setState(t.getTargetState().getName());

				// Monitor log SEND_UPDATE_BEFORE
				monitorLogger.sendEventData("WP7", Long.parseLong(id.getChoreographyID()), coordinationDelegateFrom.getName(), ArtifactType.CD, Utilities.findCDRole(CoordinationDelegateFactory.getAddressKeys()), handleRulesManagedTuple.getSourceState().getName(), handleRulesManagedTuple.getTargetState().getName(), handleRulesManagedTuple.getAllowedOperation().getName(), coordinationDelegateTo.getName(), EventType.SEND_UPDATE_BEFORE, System.currentTimeMillis());

				logger.info("------------------------------- CD " + coordinationDelegateFrom.getName() + " SEND UPDATE(" + additionalMessage.getState() + ") " + "TO " + additionalMessage.getCoordinationDelegateTo() + " -------------------------------");

				coordinationChannelManager.update(additionalMessage);

				// Monitor log SEND_UPDATE_AFTER
				monitorLogger.sendEventData("WP7", Long.parseLong(id.getChoreographyID()), coordinationDelegateFrom.getName(), ArtifactType.CD, Utilities.findCDRole(CoordinationDelegateFactory.getAddressKeys()), handleRulesManagedTuple.getSourceState().getName(), handleRulesManagedTuple.getTargetState().getName(), handleRulesManagedTuple.getAllowedOperation().getName(), coordinationDelegateTo.getName(), EventType.SEND_UPDATE_AFTER, System.currentTimeMillis());
			}
		}
	}

	private void sendAllNotify(Tuple handleRulesManagedTuple, State s, Tuple t) {

		if (t.getNotify() != null) {
			for (NotifyElement notifyElement : t.getNotify().getElements()) {
				// for every notify element of the tuple check if the state of
				// the notify element
				// is the one enabling the notification for the participants
				if (notifyElement.getState().getName().equals(s.getName())) {
					// for every participant send notify message
					for (Iterator<Participant> iterator2 = notifyElement.getParticipants().iterator(); iterator2.hasNext();) {
						Participant coordinationDelegateTo = iterator2.next();
						AdditionalMessageNotify additionalMessageNotify = new AdditionalMessageNotify();
						additionalMessageNotify.setChoreographyID(id.getChoreographyID());
						additionalMessageNotify.setCoordinatedServiceEndpointName(id.getCoordinatedServiceEndpointName());
						additionalMessageNotify.setPrecedessor(notifyElement.getState().getName());
						additionalMessageNotify.setJoin(t.getTargetState().getName());
						// additionalMessageNotify.setJoin(notifyElement.getState().getName());
						additionalMessageNotify.setCoordinationDelegateFrom(coordinationDelegateFrom.getName());
						additionalMessageNotify.setCoordinationDelegateTo(coordinationDelegateTo.getName());

						// Monitor log SEND_NOTIFY_BEFORE
						monitorLogger.sendEventData("WP7", Long.parseLong(id.getChoreographyID()), coordinationDelegateFrom.getName(), ArtifactType.CD, Utilities.findCDRole(CoordinationDelegateFactory.getAddressKeys()), handleRulesManagedTuple.getSourceState().getName(), handleRulesManagedTuple.getTargetState().getName(), handleRulesManagedTuple.getAllowedOperation().getName(), coordinationDelegateTo.getName(), EventType.SEND_NOTIFY_BEFORE, System.currentTimeMillis());

						logger.info("------------------------------- CD " + coordinationDelegateFrom.getName() + " SEND NOTIFY(" + additionalMessageNotify.getPrecedessor() + "," + additionalMessageNotify.getCoordinationDelegateTo() + "," + additionalMessageNotify.getJoin() + ") -------------------------------");

						coordinationChannelManager.notify(additionalMessageNotify);
						// Send to monitor information about sent message
						// TODO: Monitor initial and final state
						// handleRulesManagedTuple.getSourceState().getName()
						// Monitor log SEND_NOTIFY_AFTER
						monitorLogger.sendEventData("WP7", Long.parseLong(id.getChoreographyID()), coordinationDelegateFrom.getName(), ArtifactType.CD, Utilities.findCDRole(CoordinationDelegateFactory.getAddressKeys()), handleRulesManagedTuple.getSourceState().getName(), handleRulesManagedTuple.getTargetState().getName(), handleRulesManagedTuple.getAllowedOperation().getName(), coordinationDelegateTo.getName(), EventType.SEND_NOTIFY_AFTER, System.currentTimeMillis());
					}
				}
			}
		}
	}

	/* start FIX behaviour during the evaluation condition phase */
	private class CustomEvaluateCondition {
		private String tupleName;
		private boolean condition;
		private boolean evaluated;
		private CustomEvaluateCondition customEvaluateConditionDependent;

		public CustomEvaluateCondition(String tupleName, boolean condition, boolean evaluated, CustomEvaluateCondition customEvaluateConditionDependent) {
			this.customEvaluateConditionDependent = customEvaluateConditionDependent;
			this.tupleName = tupleName;
			this.condition = condition;
			this.evaluated = evaluated;
		}

		public boolean getCondition() {
			return condition;
		}

		public void setCondition(boolean condition) {
			this.condition = condition;
		}

		public boolean isEvaluated() {
			return evaluated;
		}

		public void setEvaluated(boolean evaluated) {
			this.evaluated = evaluated;
		}

		public String getTupleName() {
			return this.tupleName;
		}

		public CustomEvaluateCondition getCustomEvaluateConditionDependent() {
			return this.customEvaluateConditionDependent;
		}
	}

	private Map<String, CustomEvaluateCondition> evaluationConditionMap = new HashMap<String, CustomEvaluateCondition>() {
		{
			// add_product
			put("S8_S15", new CustomEvaluateCondition("S8_S15", true, true, null));
			// remove_product
			put("S8_S6", new CustomEvaluateCondition("S8_S6", false, true, null));
			// change_qty
			put("S8_S4", new CustomEvaluateCondition("S8_S4", false, true, null));
			// private_offer
			put("S43_S31", new CustomEvaluateCondition("S43_S31", true, true, null));
			// bcd_receive_sms
			put("S43_S36", new CustomEvaluateCondition("S43_S36", false, true, null));

			// Exclusive Gateway S17
			CustomEvaluateCondition customEvaluateConditionDependentS17_S8 = new CustomEvaluateCondition("S17_S22", false, true, null);
			put("S17_S8", new CustomEvaluateCondition("S17_S8", true, false, customEvaluateConditionDependentS17_S8));
			put("S17_S22", customEvaluateConditionDependentS17_S8);

			// Exclusive Gateway S40
			CustomEvaluateCondition customEvaluateConditionDependentS40_S41 = new CustomEvaluateCondition("S40_final", false, true, null);
			put("S40_S41", new CustomEvaluateCondition("S40_S41", true, false, customEvaluateConditionDependentS40_S41));
			put("S40_final", customEvaluateConditionDependentS40_S41);

			// Exclusive Gateway S30
			CustomEvaluateCondition customEvaluateConditionDependentS30_S34 = new CustomEvaluateCondition("S30_final", false, true, null);
			put("S30_S34", new CustomEvaluateCondition("S30_S34", true, false, customEvaluateConditionDependentS30_S34));
			put("S30_final", customEvaluateConditionDependentS30_S34);

		}
	};

	private boolean evaluateCondition(Tuple t) {
		String tupleName = t.getSourceState().getName() + "_" + t.getTargetState().getName();
		CustomEvaluateCondition customEvaluateCondition = evaluationConditionMap.get(tupleName);

		if (customEvaluateCondition != null) {
			if (customEvaluateCondition.isEvaluated()) {
				return customEvaluateCondition.getCondition();
			} else {
				boolean returnedContition = customEvaluateCondition.getCondition();
				customEvaluateCondition.setEvaluated(true);
				customEvaluateCondition.setCondition(false);
				customEvaluateCondition.getCustomEvaluateConditionDependent().setCondition(true);
				return returnedContition;
			}
		}

		if (t.getCondition().equals("true"))
			return true;
		else
			return false;
	}
	/* end FIX behaviour during the evaluation condition phase */

	/*
	 * private boolean evaluateCondition(Tuple t){
	 * 
	 * if(t.getCondition().equals("true")) return true; else return false; }
	 */
	private ArrayList<Tuple> existTauFirst(Tuple tuple) {

		ArrayList<Tuple> tuples = new ArrayList<Tuple>();
		for (Tuple tuple2 : coord.getTuples()) {
			// the target state of the tuple found is the source state
			// of another tuple inside the CM(coord) and its condition holds
			if (tuple2.getSourceState().getName().equals(tuple.getTargetState().getName()) && evaluateCondition(tuple2)) {
				tuples.add(tuple2);
			}
		}

		return tuples;
	}

	private void stepOver(Tuple handleRulesManagedTuple, State s) {

		for (Iterator<Tuple> iterator = coord.getTuples().iterator(); iterator.hasNext();) {
			Tuple tuple1 = iterator.next();
			// once found a tuple with the source state that is loooking for
			// check if it's possible to move by an internal task
			// the allowed operation must be epsilon
			// and the target state of the tuple found is the source state
			// of another tuple inside the CM(coord) and its condition holds
			if (tuple1.getSourceState().getName().equals(s.getName()) && tuple1.getAllowedOperation() == null) {
				// tuple1 is tau
				// for all [s,(h,k)] in tau[toBeNotified] sends
				// NOTIFY(s,CDhk,tau[trg])
				sendAllNotify(handleRulesManagedTuple, s, tuple1);
				// for all [s'',(h,k)] in tau[toBeWaited] wait for
				// NOTIFY(s'',CDhk,tau[trg])
				// waitForAllNotify(tuple1);
				waitForAllNotify(handleRulesManagedTuple, tuple1);
				// if CD has been involved into a parallel path check if it has
				// highest priority execute rules 3.1.1, 3.1.2 and 3.1.3
				if (tuple1.getWait() != null) {
					if (Utilities.cdHasHighestPriority(coordinationDelegateFrom.getName(), tuple1, cdPriorities)) {
						logger.info("------------------------------- CD " + coordinationDelegateFrom.getName() + " HAS HIGHEST PRIORITY IN THE PARALLEL PATH -------------------------------");
						// updates current state to join
						updateGlobalState(s, tuple1.getTargetState());
						// for all (h,k) belonging to tau[allowedService] send
						// UPDATE tau[trg] to CDhk
						// tau of 3.1.2 is the same as tau' in stepOver but
						// there can be more than one tau'
						for (Tuple tuple : existTauFirst(tuple1)) {
							// for all (h,k) in tau'[allowedService] sends
							// UPDATE(tau[trg]) to CDhk
							sendUpdateCurrentState(handleRulesManagedTuple, tuple);
						}
					}
				}
				boolean isFirstTupleTauFirst = false;
				// search for more than one tau'
				for (Tuple tuple : existTauFirst(tuple1)) {
					// tuple is tau'
					// for all (h,k) in tau'[allowedService] sends
					// UPDATE(tau'[trg]) to CDhk
					sendUpdateCurrentState(handleRulesManagedTuple, tuple);
					// recursive call to stepOver with tau'[trg]
					// stepOver(tuple.getTargetState());
					if (!isFirstTupleTauFirst) {
						isFirstTupleTauFirst = true;
						stepOver(handleRulesManagedTuple, tuple.getSourceState());
					}
				}
			}
		}
	}

}
