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
package eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import eu.chorevolution.modelingnotations.coord.AllowedOperation;
import eu.chorevolution.modelingnotations.coord.COORDModel;
import eu.chorevolution.modelingnotations.coord.Participant;
import eu.chorevolution.modelingnotations.coord.Tuple;
import eu.chorevolution.modelingnotations.coord.WaitElement;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.priorities.CoordinationDelegatePriorityElement;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.priorities.CoordinationDelegatePriorityList;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.queueNotify.NotifyQueue;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.queueNotify.NotifyQueueElement;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.queueNotify.NotifyQueues;

public class Utilities {

	public static NotifyQueues createNotifyQueuesFromCoord(COORDModel coord) {

		NotifyQueues notifyQueues = new NotifyQueues();
		// iterate over the tuples of COORDModel
		for (Tuple tuple : coord.getTuples()) {
			if (tuple.getWait() != null) {
				NotifyQueue notifyQueue = new NotifyQueue();
				// iterate over the wait elements
				for (WaitElement waitEl : tuple.getWait().getElements()) {
					// iterate over the participants of a wait element
					for (Participant participant : waitEl.getParticipants()) {
						// create a NotifyQueueElement
						NotifyQueueElement notifyQueueElement = new NotifyQueueElement(waitEl.getState(), participant, tuple.getTargetState());
						// add NotifyQueueElement to NotifyQueue
						notifyQueue.addNotifyQueueElement(notifyQueueElement);
					}
				}
				// add NotifyQueue to NotifyQueues
				notifyQueues.addNotifyQueue(notifyQueue);
			}
		}
		return notifyQueues;
	}

	public static boolean cdHasHighestPriority(String coordinationDelegateName, Tuple tuple, CoordinationDelegatePriorityList cdPriorities) {

		List<CoordinationDelegatePriorityElement> participantsWait = new ArrayList<CoordinationDelegatePriorityElement>();
		// get the priority of all the participants involved in the parallel
		// path
		for (WaitElement waitElement : tuple.getWait().getElements()) {
			for (Participant participant : waitElement.getParticipants()) {
				CoordinationDelegatePriorityElement participantWait = cdPriorities.getCoordinationDelegatePriorityElement(participant.getName());
				participantsWait.add(participantWait);
			}
		}
		// get the priority of the CD
		CoordinationDelegatePriorityElement participantWait = cdPriorities.getCoordinationDelegatePriorityElement(coordinationDelegateName);
		participantsWait.add(participantWait);
		// sort the list
		Collections.sort(participantsWait);
		// check if the first element of the sorted list is the CD because
		// this means that the CD has highest priority in the parallel path
		if (participantsWait.get(0).getCoordinationDelegateName().equals(coordinationDelegateName)) {
			return true;
		}
		return false;
	}

	// TODO change this method
	public static String findCDRole(Set<String> artifactsName) {
		for (String artifactName : artifactsName) {
			if (artifactName.startsWith("CD")) {
				return artifactName;
			}
		}
		return null;
	}
	
	public static Tuple getTupleFromAllowedOperation(List<Tuple> tuples, AllowedOperation allowedOperation) {

		for (Tuple tuple : tuples) {
			if (tuple.getAllowedOperation() != null && 
					tuple.getAllowedOperation().getName().equals(allowedOperation.getName())) {
						return tuple;
				}
		}
		return null;
	}
}
