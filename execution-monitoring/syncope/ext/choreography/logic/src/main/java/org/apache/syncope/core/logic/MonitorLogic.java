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
package org.apache.syncope.core.logic;

import eu.chorevolution.idm.common.to.AVGCoordinationDelegateTO;
import eu.chorevolution.idm.common.to.AVGOperationDataTO;
import eu.chorevolution.idm.common.to.AVGServiceTO;
import eu.chorevolution.idm.common.to.ChoreographyInstanceTO;
import eu.chorevolution.idm.common.to.ChoreographyTO;
import eu.chorevolution.idm.common.to.CoordinationDelegateTO;
import java.lang.reflect.Method;
import java.util.List;
import org.apache.syncope.common.lib.AbstractBaseBean;
import eu.chorevolution.idm.common.to.OperationDataTO;
import eu.chorevolution.idm.common.to.ServiceTO;
import eu.chorevolution.idm.common.types.ArtifactType;
import eu.chorevolution.idm.common.types.EventType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.syncope.core.persistence.api.dao.ChoreographyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.syncope.core.persistence.api.dao.EventDAO;
import org.apache.syncope.core.persistence.api.entity.Event;
import org.apache.syncope.core.persistence.api.entity.ChoreographyInstance;
import org.apache.syncope.core.persistence.api.dao.ChoreographyInstanceDAO;
import org.apache.syncope.core.persistence.api.entity.group.GPlainAttr;
import org.apache.syncope.core.persistence.api.entity.group.Group;

@Component
public class MonitorLogic extends AbstractTransactionalLogic<AbstractBaseBean> {

    @Autowired
    private ChoreographyDAO choreographyDAO;

    @Autowired
    private ChoreographyInstanceDAO choreographyInstanceDAO;

    @Autowired
    private EventDAO eventDAO;

    @Override
    protected AbstractBaseBean resolveReference(final Method method, final Object... args)
            throws UnresolvedReferenceException {

        throw new UnresolvedReferenceException();
    }

    private ChoreographyTO getChoreographyTO(final Group choreography, final boolean details) {
        ChoreographyTO choreographyTO = new ChoreographyTO();
        choreographyTO.setName(choreography.getName());

        GPlainAttr id = choreography.getPlainAttr("id");
        if (id != null && id.getUniqueValue() != null) {
            choreographyTO.setId(id.getUniqueValue().getStringValue());
        }

        GPlainAttr description = choreography.getPlainAttr("description");
        if (description != null && !description.getValues().isEmpty()) {
            choreographyTO.setDescription(description.getValues().get(0).getStringValue());
        }

        if (details) {
            GPlainAttr messages = choreography.getPlainAttr("messages");
            if (messages != null && !messages.getValues().isEmpty()) {
                choreographyTO.setMessages(messages.getValues().get(0).getBinaryValue());
            }

            GPlainAttr diagram = choreography.getPlainAttr("diagram");
            if (diagram != null && !diagram.getValues().isEmpty()) {
                choreographyTO.setDiagram(diagram.getValues().get(0).getBinaryValue());
            }

            GPlainAttr image = choreography.getPlainAttr("image");
            if (image != null && !image.getValues().isEmpty()) {
                choreographyTO.setImage(image.getValues().get(0).getBinaryValue());
            }
        }

        return choreographyTO;
    }

    /**
     * This method returns a list of all choreographies
     *
     * @return ChoreographyTO list
     */
    public List<ChoreographyTO> choreographyList() {
        List<ChoreographyTO> result = new LinkedList<>();

        for (Group choreography : choreographyDAO.findAll()) {
            result.add(getChoreographyTO(choreography, false));
        }

        return result;
    }

    /**
     * This method returns a list of all instances of given choreography
     *
     * @param choreographyId
     * @return CoordinationDelegateTO list
     */
    public List<ChoreographyInstanceTO> instanceList(final String choreographyId) {
        List<ChoreographyInstanceTO> result = new LinkedList<>();

        for (ChoreographyInstance current : choreographyInstanceDAO.findByChoreographyId(choreographyId)) {
            ChoreographyInstanceTO choreographyInstanceTO = new ChoreographyInstanceTO();
            choreographyInstanceTO.setId(current.getKey()); // choreography instance primary key
            choreographyInstanceTO.setChoreographyInstanceId(current.getChoreographyInstanceId());
            choreographyInstanceTO.setInstanceDescription(current.getDescription());
            choreographyInstanceTO.setExecutionTime(getChoreographyInstanceExecutionTime(current.getKey()));

            choreographyInstanceTO.setChoreographyId(choreographyId);

            result.add(choreographyInstanceTO);
        }

        return result;
    }

    /**
     * This method returns a list of CDs for a given choreography instance
     *
     * @param choreographyInstancePK
     * @return CoordinationDelegateTO list
     */
    public List<CoordinationDelegateTO> cdList(final String choreographyInstancePK) {
        List<CoordinationDelegateTO> coordinationDelegateTOs = new LinkedList<>();

        List<String> nameCDs = getCdNames(choreographyInstancePK);

        for (String cdName : nameCDs) {
            coordinationDelegateTOs.add(getCd(choreographyInstancePK, cdName));
        }

        return coordinationDelegateTOs;
    }

    /**
     * This method returns the given CD for choreography instance
     *
     * @param choreographyInstancePK
     * @param cdName
     * @return CoordinationDelegateTO
     */
    public CoordinationDelegateTO getCd(final String choreographyInstancePK, final String cdName) {
        CoordinationDelegateTO coordinationDelegateTO = new CoordinationDelegateTO();
        coordinationDelegateTO.setName(cdName);
        coordinationDelegateTO.setInstanceId(choreographyInstancePK);

        List<OperationDataTO> operations = operationList(choreographyInstancePK, ArtifactType.CD, cdName);

        int cdExchangedMessages = 0;
        int discardedOperations = 0;
        long serviceExecutionTime = 0;
        long networkOverheadForBusinessMessagesExchangeTime = 0;
        long coordinationAlgorithmReasoningTime = 0;
        long networkOverheadForCoordinationMessagesExchangeTime = 0;
        long waitTimeForSchedulingOperation = 0;
        long waitTimeForSynchronizing = 0;

        for (OperationDataTO operation : operations) {

            // Update number of coordination messages sent by current CD
            cdExchangedMessages = cdExchangedMessages + operation.getMessageNumber();

            // Update time for exchange coordination messages
            networkOverheadForCoordinationMessagesExchangeTime = networkOverheadForCoordinationMessagesExchangeTime
                    + operation.getNetworkOverheadForCoordinationMessagesExchangeTime();

            // Update reasoning time of current CD
            coordinationAlgorithmReasoningTime = coordinationAlgorithmReasoningTime
                    + operation.getCoordinationAlgorithmReasoningTime();

            // Update execution time of services involved in current CD tasks
            serviceExecutionTime = serviceExecutionTime + operation.getReceivingServiceExecutionTime();

            // Update network time for business exchanged messages
            networkOverheadForBusinessMessagesExchangeTime = networkOverheadForBusinessMessagesExchangeTime
                    + operation.getNetworkOverheadForBusinessMessagesExchangeTime();

            // Update wait time of current CD
            waitTimeForSchedulingOperation = waitTimeForSchedulingOperation + operation.
                    getWaitTimeForSchedulingOperation();
            waitTimeForSynchronizing = waitTimeForSynchronizing + operation.getWaitTimeForSynchronizing();

            // Count discarded operations
            discardedOperations = discardedOperations + operation.getDiscardedOperations();
        }

        coordinationDelegateTO.setExecutedOperations(operations.size());
        coordinationDelegateTO.setCoordinationMessages(cdExchangedMessages);
        coordinationDelegateTO.setNetworkOverheadForCoordinationMessagesExchangeTime(
                networkOverheadForCoordinationMessagesExchangeTime
        );
        coordinationDelegateTO.setCoordinationAlgorithmReasoningTime(coordinationAlgorithmReasoningTime);
        coordinationDelegateTO.setServiceExecutionTime(serviceExecutionTime);
        coordinationDelegateTO.setNetworkOverheadForBusinessMessagesExchangeTime(
                networkOverheadForBusinessMessagesExchangeTime
        );
        coordinationDelegateTO.setWaitTimeForSchedulingOperation(waitTimeForSchedulingOperation);
        coordinationDelegateTO.setWaitTimeForSynchronizing(waitTimeForSynchronizing);
        coordinationDelegateTO.setDiscardedOperations(discardedOperations);

        return coordinationDelegateTO;
    }

    public List<ServiceTO> serviceList(final String choreographyInstancePK) {
        List<ServiceTO> serviceTOs = new LinkedList<>();

        List<String> serviceNames = getServiceNames(choreographyInstancePK);

        for (String serviceName : serviceNames) {
            serviceTOs.add(getService(choreographyInstancePK, serviceName));
        }
        return serviceTOs;
    }

    public ServiceTO getService(final String choreographyInstancePK, final String serviceName) {
        ServiceTO serviceTO = new ServiceTO();
        serviceTO.setName(serviceName);

        List<OperationDataTO> operations = operationList(choreographyInstancePK, ArtifactType.SERVICE, serviceName);

        long waitTimeForResponse = 0;
        long executionTime = 0;

        for (OperationDataTO operation : operations) {
            waitTimeForResponse = operation.getCallingServiceWaitTimeForResponse();
            executionTime = operation.getReceivingServiceExecutionTime();
        }

        serviceTO.setExecutedOperations(operations.size());
        serviceTO.setWaitTimeForResponse(waitTimeForResponse);
        serviceTO.setExecutionTime(executionTime);

        return serviceTO;
    }

    public List<OperationDataTO> operationList(
            final String choreographyInstancePK,
            final ArtifactType artifactType,
            final String artifactName) {

        List<String> operationNames = getOperationNames(choreographyInstancePK, artifactName);

        List<OperationDataTO> operationDataTOs = new LinkedList<>();

        for (String operationName : operationNames) {
            operationDataTOs.addAll(getOperation(choreographyInstancePK, operationName));
        }

        return operationDataTOs;

    }

    public List<OperationDataTO> operationList(final String choreographyInstancePK) {
        List<String> operationNames = getOperationNames(choreographyInstancePK);

        List<OperationDataTO> operationDataTOs = new LinkedList<>();

        for (String operationName : operationNames) {
            operationDataTOs.addAll(getOperation(choreographyInstancePK, operationName));
        }

        return operationDataTOs;
    }

    private List<OperationDataTO> getOperation(
            final String choreographyInstancePK,
            final String operationName){

        Map<String, ArtifactType> artifacts = new HashMap<>();
        List<Event> operationEvents = eventDAO.findByOperation(choreographyInstancePK, operationName);
        for (Event event : operationEvents) {
            if (!artifacts.containsKey(event.getArtifactName())) {
                artifacts.put(event.getArtifactName(), event.getArtifactType());
            }
        }

        Map<String, long[]> initiatingTimestamps = new HashMap<>();
        int executionNumber = 0;

        for (Map.Entry<String, ArtifactType> artifactEntry : artifacts.entrySet()) {
            String artifactName = artifactEntry.getKey();
            ArtifactType artifactType = artifactEntry.getValue();

            List<Event> initiatingCalls;

            if (artifactType.equals(ArtifactType.CD)) {
                initiatingCalls = eventDAO.findArtifactEventByType(choreographyInstancePK, artifactName,
                        operationName, EventType.RECEIVING_REQUEST);
            } else {
                initiatingCalls = eventDAO.findArtifactEventByType(choreographyInstancePK, artifactName, 
                        operationName, EventType.SENDING_REQUEST);
                if (initiatingCalls.isEmpty()) {
                    initiatingCalls = eventDAO.findArtifactEventByType(choreographyInstancePK,
                            artifactName, operationName, EventType.RECEIVING_REQUEST);
                }
            }

            long requestsTimestamp[] = new long[initiatingCalls.size() + 1];
            int i = 0;
            for (Event currentCall : initiatingCalls) {
                requestsTimestamp[i] = currentCall.getEventTimestamp();
                i++;
            }
            requestsTimestamp[i] = Long.MAX_VALUE;

            if (i >= executionNumber) {
                executionNumber = i;
            }

            initiatingTimestamps.put(artifactName, requestsTimestamp);
        }

        List<OperationDataTO> operations = new LinkedList<>();

        for (int i = 0; i < executionNumber; i++) {
            List<Event> executionEvents = new ArrayList<>();

            for (Map.Entry<String, long[]> entry : initiatingTimestamps.entrySet()) {
                String artifactName = entry.getKey();
                long[] timestamps = entry.getValue();

                if (timestamps.length > i + 1) {
                    executionEvents.addAll(eventDAO.findArtifactOperation(choreographyInstancePK,
                        artifactName, operationName, timestamps[i] - 1, timestamps[i+1]));
                }
            }

            operations.add(getOperationExecution(operationName, executionEvents, i));
        }

        return operations;
    }

    private OperationDataTO getOperationExecution(
            final String operationName,
            final List<Event> events,
            final int repetitionNumber) {

        OperationDataTO operation = new OperationDataTO();
        operation.setName(operationName + (repetitionNumber > 0 ? " (" + (repetitionNumber + 1) + ")" : ""));

        long cdReceivingRequest = 0;
        long cdForwardingRequest = 0;
        long cdReceivingResponse = 0;
        long cdForwardingResponse = 0;

        long cdWaitTimeForSchedulingOperation = 0;
        long cdWaitTimeForSynchronizing = 0;

        long cdNetworkOverheadForCoordinationMessagesExchangeTime = 0;
        int cdMessageNumber = 0;

        long serviceSendingRequest = 0;
        long serviceReceivingRequest = 0;
        long serviceReplyResponse = 0;
        long serviceReceivingResponse = 0;

        for (Event event : events) {
            EventType eventType = event.getEventType();
            long timestamp = event.getEventTimestamp();

            if (event.getArtifactType().equals(ArtifactType.CD)) {
                switch (eventType) {
                    case RECEIVING_REQUEST:
                        cdReceivingRequest = timestamp;
                        operation.setCoordinatingCDName(event.getArtifactName());
                        operation.setTimeReceivedByCD(timestamp);
                        break;
                    case FORWARDING_REQUEST:
                        cdForwardingRequest = timestamp;
                        operation.setTimeScheduledByCD(timestamp);
                        break;
                    case RECEIVING_RESPONSE:
                        cdReceivingResponse = timestamp;
                        break;
                    case FORWARDING_RESPONSE:
                        cdForwardingResponse = timestamp;
                        break;
                    case SEND_UPDATE_BEFORE:
                        cdNetworkOverheadForCoordinationMessagesExchangeTime =
                                cdNetworkOverheadForCoordinationMessagesExchangeTime - timestamp;
                        ++cdMessageNumber;
                        break;
                    case SEND_UPDATE_AFTER:
                        cdNetworkOverheadForCoordinationMessagesExchangeTime =
                                cdNetworkOverheadForCoordinationMessagesExchangeTime + timestamp;
                        break;
                    case SEND_NOTIFY_BEFORE:
                        cdNetworkOverheadForCoordinationMessagesExchangeTime =
                                cdNetworkOverheadForCoordinationMessagesExchangeTime - timestamp;
                        ++cdMessageNumber;
                        break;
                    case SEND_NOTIFY_AFTER:
                        cdNetworkOverheadForCoordinationMessagesExchangeTime =
                                cdNetworkOverheadForCoordinationMessagesExchangeTime + timestamp;
                        break;
                    case WAIT_UPDATE_STATE_BEFORE:
                        cdWaitTimeForSchedulingOperation = cdWaitTimeForSchedulingOperation - timestamp;
                        break;
                    case WAIT_UPDATE_STATE_AFTER:
                        cdWaitTimeForSchedulingOperation = cdWaitTimeForSchedulingOperation + timestamp;
                        break;
                    case WAIT_ALL_NOTIFY_BEFORE:
                        cdWaitTimeForSynchronizing = cdWaitTimeForSynchronizing - timestamp;
                        break;
                    case WAIT_ALL_NOTIFY_AFTER:
                        cdWaitTimeForSynchronizing = cdWaitTimeForSynchronizing + timestamp;
                        break;
                    default:
                }
            } else if (event.getArtifactType().equals(ArtifactType.SERVICE)) {
                switch (eventType) {
                    case SENDING_REQUEST:
                        serviceSendingRequest = timestamp;
                        operation.setInitiatingServiceName(event.getArtifactName());
                        operation.setTimeCalledByInitiatingService(timestamp);
                        break;
                    case RECEIVING_REQUEST:
                        serviceReceivingRequest = timestamp;
                        operation.setReceivingServiceName(event.getTargetArtifactName());
                        operation.setTimeReceivedByCalledService(timestamp);
                        break;
                    case REPLY_RESPONSE:
                        serviceReplyResponse = timestamp;
                        operation.setTimeRepliedByCalledService(timestamp);
                        break;
                    case RECEIVING_RESPONSE:
                        serviceReceivingResponse = timestamp;
                        operation.setTimeReceivedByInitiatingService(timestamp);
                        break;
                    default:
                }
            }
        }

        operation.setMessageNumber(cdMessageNumber);
        operation.setWaitTimeForSchedulingOperation(cdWaitTimeForSchedulingOperation);
        operation.setWaitTimeForSynchronizing(cdWaitTimeForSynchronizing);
        operation.setReceivingServiceExecutionTime(serviceReplyResponse - serviceReceivingRequest);
        operation.setCallingServiceWaitTimeForResponse(serviceReceivingResponse - serviceSendingRequest);
        operation.setNetworkOverheadForBusinessMessagesExchangeTime(
                cdReceivingResponse - cdForwardingRequest - operation.getReceivingServiceExecutionTime()
        );
        operation.setCoordinationAlgorithmReasoningTime((cdForwardingRequest - cdReceivingRequest)
                + (cdForwardingResponse - cdReceivingResponse)
                - cdWaitTimeForSchedulingOperation
                - cdWaitTimeForSynchronizing
                - cdNetworkOverheadForCoordinationMessagesExchangeTime
        );
        operation.setNetworkOverheadForCoordinationMessagesExchangeTime(
                cdNetworkOverheadForCoordinationMessagesExchangeTime
        );

        if(operation.getWaitTimeForSchedulingOperation()<0) {
            operation.setWaitTimeForSchedulingOperation(0);
            operation.setDiscardedOperations(operation.getDiscardedOperations() + 1);
        }

        return operation;
    }

    private List<String> getOperationNames(final String choreographyInstancePK, final String artifactName) {
        return eventDAO.findOperationsByArtifact(choreographyInstancePK, artifactName);
    }

    private List<String> getOperationNames(final String choreographyInstancePK) {
        return eventDAO.findOperationsByInstance(choreographyInstancePK);
    }

    private List<String> getCdNames(final String choreographyInstancePK) {
        return eventDAO.findArtifactsByType(choreographyInstancePK, ArtifactType.CD);
    }

    private List<String> getServiceNames(final String choreographyInstancePK) {
        return eventDAO.findArtifactsByType(choreographyInstancePK, ArtifactType.SERVICE);
    }

    public ChoreographyTO getChoreography(final String choreographyId) {
        Group choreography = choreographyDAO.findById(choreographyId);
        if (choreography == null) {
            return null;
        }

        return getChoreographyTO(choreography, true);
    }

    public ChoreographyInstanceTO getChoreographyInstance(final String choreographyInstancePK) {
        ChoreographyInstance choreographyInstance = choreographyInstanceDAO.findById(choreographyInstancePK);

        if (choreographyInstance == null) {
            return null;
        }

        ChoreographyInstanceTO choreographyInstanceTO = new ChoreographyInstanceTO();
        choreographyInstanceTO.setId(choreographyInstance.getKey());
        choreographyInstanceTO.setChoreographyInstanceId(choreographyInstance.getChoreographyInstanceId());
        choreographyInstanceTO.setInstanceDescription(choreographyInstance.getDescription());
        Group choreography = choreographyDAO.findById(choreographyInstance.getChoreographyId());
        if (choreography != null) {
            GPlainAttr id = choreography.getPlainAttr("id");
            if (id != null && id.getUniqueValue() != null) {
                choreographyInstanceTO.setChoreographyId(id.getUniqueValue().getStringValue());
            }
            choreographyInstanceTO.setChoreographyName(choreography.getName());
        }
        choreographyInstanceTO.setExecutionTime(getChoreographyInstanceExecutionTime(choreographyInstancePK));

        return choreographyInstanceTO;
    }

    private Long getChoreographyInstanceExecutionTime(final String choreographyInstancePK) {
        List<Event> events = eventDAO.findClientInstanceEvents(choreographyInstancePK);

        long start = 0L;
        long end = 0L;

        for (Event event : events) {
            if (start > event.getEventTimestamp() || start == 0) {
                start = event.getEventTimestamp();
            }

            if (end < event.getEventTimestamp()) {
                end = event.getEventTimestamp();
            }
        }

        return end - start;
    }

    public Double getAverageInstanceExecutionTime(final String choreographyId) {
        Double avgInstanceExevutionTime = 0.0d;
        List<ChoreographyInstanceTO> choreographyInstanceTOs = instanceList(choreographyId);

        for (ChoreographyInstanceTO choreographyInstance : choreographyInstanceTOs) {
            avgInstanceExevutionTime = avgInstanceExevutionTime + choreographyInstance.getExecutionTime();
        }

        if (choreographyInstanceTOs.isEmpty()) {
            return avgInstanceExevutionTime;
        } else {
            avgInstanceExevutionTime = avgInstanceExevutionTime / Double.valueOf(choreographyInstanceTOs.size());
            return Double.valueOf(Math.round(avgInstanceExevutionTime * 100d)) / 100d;
        }
    }

    public List<AVGCoordinationDelegateTO> averageCdList(final String choreographyId) {

        List<AVGCoordinationDelegateTO> aVGCoordinationDelegateTOs = new LinkedList<>();

        List<ChoreographyInstance> choreographyInstances = choreographyInstanceDAO.findByChoreographyId(choreographyId);
        List<String> cdNames = eventDAO.findCdsByChoreography(choreographyId);

        for (String cdName : cdNames) {

            int maxExecutedOperations = 0;
            int minExecutedOperations = -1;
            int maxCoordinationMessages = 0;
            int minCoordinationMessages = -1;
            double totalServiceExecutionTime = 0.0d;
            double totalNetworkOverheadForBusinessMessagesExchangeTime = 0.0d;
            double totalCoordinationAlgorithmReasoningTime = 0.0d;
            double totalNetworkOverheadForCoordinationMessagesExchangeTime = 0.0d;
            double totalWaitTimeForSchedulingOperation = 0.0d;
            double totalWaitTimeForSynchronizing = 0.0d;

            int assignments = 0; // counts the number of instances in which each CD is involved
            for (ChoreographyInstance choreographyInstance : choreographyInstances) {
                CoordinationDelegateTO coordinationDelegateTO = getCd(choreographyInstance.getKey(), cdName);

                if (coordinationDelegateTO != null) {
                    if (maxExecutedOperations < coordinationDelegateTO.getExecutedOperations()) {
                        maxExecutedOperations = coordinationDelegateTO.getExecutedOperations();
                    }

                    if (minExecutedOperations > coordinationDelegateTO.getExecutedOperations()
                            || minExecutedOperations == -1) {
                        minExecutedOperations = coordinationDelegateTO.getExecutedOperations();
                    }

                    if (maxCoordinationMessages < coordinationDelegateTO.getCoordinationMessages()) {
                        maxCoordinationMessages = coordinationDelegateTO.getCoordinationMessages();
                    }

                    if (minCoordinationMessages > coordinationDelegateTO.getCoordinationMessages()
                            || minCoordinationMessages == -1) {
                        minCoordinationMessages = coordinationDelegateTO.getCoordinationMessages();
                    }

                    totalServiceExecutionTime = totalServiceExecutionTime + coordinationDelegateTO.
                            getServiceExecutionTime();
                    totalNetworkOverheadForBusinessMessagesExchangeTime =
                            totalNetworkOverheadForBusinessMessagesExchangeTime
                            + coordinationDelegateTO.getNetworkOverheadForBusinessMessagesExchangeTime();
                    totalCoordinationAlgorithmReasoningTime = totalCoordinationAlgorithmReasoningTime
                            + coordinationDelegateTO.getCoordinationAlgorithmReasoningTime();
                    totalNetworkOverheadForCoordinationMessagesExchangeTime =
                            totalNetworkOverheadForCoordinationMessagesExchangeTime
                            + coordinationDelegateTO.getNetworkOverheadForCoordinationMessagesExchangeTime();
                    totalWaitTimeForSchedulingOperation = totalWaitTimeForSchedulingOperation
                            + coordinationDelegateTO.getWaitTimeForSchedulingOperation();
                    totalWaitTimeForSynchronizing = totalWaitTimeForSynchronizing + coordinationDelegateTO.
                            getWaitTimeForSynchronizing();

                    ++assignments;
                }
            }

            if (assignments > 0) {
                AVGCoordinationDelegateTO aVGCoordinationDelegateTO = new AVGCoordinationDelegateTO();
                aVGCoordinationDelegateTO.setChoreographyId(choreographyId);
                aVGCoordinationDelegateTO.setName(cdName);
                aVGCoordinationDelegateTO.setMaxExecutedOperations(maxExecutedOperations);
                aVGCoordinationDelegateTO.setMinExecutedOperations(minExecutedOperations);
                aVGCoordinationDelegateTO.setMaxCoordinationMessages(maxCoordinationMessages);
                aVGCoordinationDelegateTO.setMinCoordinationMessages(minCoordinationMessages);

                aVGCoordinationDelegateTO.setServiceExecutionTime(totalServiceExecutionTime / assignments);
                aVGCoordinationDelegateTO.setNetworkOverheadForBusinessMessagesExchangeTime(
                        totalNetworkOverheadForBusinessMessagesExchangeTime / assignments
                );
                aVGCoordinationDelegateTO.setCoordinationAlgorithmReasoningTime(
                        totalCoordinationAlgorithmReasoningTime / assignments
                );
                aVGCoordinationDelegateTO.setNetworkOverheadForCoordinationMessagesExchangeTime(
                        totalNetworkOverheadForCoordinationMessagesExchangeTime / assignments
                );
                aVGCoordinationDelegateTO.setWaitTimeForSchedulingOperation(
                        totalWaitTimeForSchedulingOperation / assignments
                );
                aVGCoordinationDelegateTO.setWaitTimeForSynchronizing(totalWaitTimeForSynchronizing / assignments);

                aVGCoordinationDelegateTOs.add(aVGCoordinationDelegateTO);
            }
        }
        return aVGCoordinationDelegateTOs;
    }

    public List<AVGServiceTO> averageServiceList(final String choreographyId) {
        List<AVGServiceTO> aVGServiceTOs = new LinkedList<>();

        List<ChoreographyInstance> choreographyInstances = choreographyInstanceDAO.findByChoreographyId(choreographyId);

        List<String> serviceNames = eventDAO.findServicesByChoreography(choreographyId);

        for (String serviceName : serviceNames) {

            int maxExecutedOperations = 0;
            int minExecutedOperations = -1;
            double totalExecutionTime = 0.0d;
            double totalWaitTimeForResponse = 0.0d;

            int assignments = 0;
            for (ChoreographyInstance choreographyInstance : choreographyInstances) {
                ServiceTO serviceTO = getService(choreographyInstance.getKey(), serviceName);

                if (serviceTO != null) {
                    totalExecutionTime = totalExecutionTime + serviceTO.getExecutionTime();
                    totalWaitTimeForResponse = totalWaitTimeForResponse + serviceTO.getWaitTimeForResponse();

                    if (maxExecutedOperations < serviceTO.getExecutedOperations()) {
                        maxExecutedOperations = serviceTO.getExecutedOperations();
                    }

                    if (minExecutedOperations > serviceTO.getExecutedOperations()
                            || minExecutedOperations == -1) {
                        minExecutedOperations = serviceTO.getExecutedOperations();
                    }

                    ++assignments;
                }
            }

            if (assignments > 0) {
                AVGServiceTO aVGServiceTO = new AVGServiceTO();
                aVGServiceTO.setName(serviceName);
                aVGServiceTO.setMaxExecutedOperations(maxExecutedOperations);
                aVGServiceTO.setMinExecutedOperations(minExecutedOperations);
                aVGServiceTO.setExecutionTime(totalExecutionTime / assignments);
                aVGServiceTO.setWaitTimeForResponse(totalWaitTimeForResponse / assignments);
                aVGServiceTOs.add(aVGServiceTO);
            }
        }
        return aVGServiceTOs;
    }

    public List<AVGOperationDataTO> averageOperationList(final String choreographyId, final String cdName) {
        List<AVGOperationDataTO> aVGOperationDataTOs = new LinkedList<>();

        List<ChoreographyInstance> choreographyInstances = choreographyInstanceDAO.findByChoreographyId(choreographyId);

        List<String> operationNames = eventDAO.findChoreographyOperationsByArtifact(choreographyId, cdName);

        for (String operationName : operationNames) {

            double totalServiceExecutionTime = 0.0d;
            double totalServiceWaitTimeForResponse = 0.0d;
            double totalNetworkOverheadForBusinessMessagesExchangeTime = 0.0d;
            double totalCoordinationAlgorithmReasoningTime = 0.0d;
            double totalNetworkOverheadForCoordinationMessagesExchangeTime = 0.0d;
            double totalWaitTimeForSchedulingOperation = 0.0d;
            double totalWaitTimeForSynchronizing = 0.0d;
            int minMessageNumber = -1;
            int maxMessageNumber = 0;

            int assignments = 0;
            for (ChoreographyInstance choreographyInstance : choreographyInstances) {
                OperationDataTO operationDataTO = getOperation(choreographyInstance.getKey(), operationName).get(0);

                if (operationDataTO != null) {
                    totalServiceExecutionTime = totalServiceExecutionTime
                            + operationDataTO.getReceivingServiceExecutionTime();
                    totalServiceWaitTimeForResponse = totalServiceWaitTimeForResponse
                            + operationDataTO.getCallingServiceWaitTimeForResponse();
                    totalNetworkOverheadForBusinessMessagesExchangeTime =
                            totalNetworkOverheadForBusinessMessagesExchangeTime
                            + operationDataTO.getNetworkOverheadForBusinessMessagesExchangeTime();
                    totalCoordinationAlgorithmReasoningTime = totalCoordinationAlgorithmReasoningTime
                            + operationDataTO.getCoordinationAlgorithmReasoningTime();
                    totalNetworkOverheadForCoordinationMessagesExchangeTime =
                            totalNetworkOverheadForCoordinationMessagesExchangeTime
                            + operationDataTO.getNetworkOverheadForCoordinationMessagesExchangeTime();
                    totalWaitTimeForSchedulingOperation = totalWaitTimeForSchedulingOperation + operationDataTO.
                            getWaitTimeForSchedulingOperation();
                    totalWaitTimeForSynchronizing = totalWaitTimeForSynchronizing + operationDataTO.
                            getWaitTimeForSynchronizing();

                    if (maxMessageNumber < operationDataTO.getMessageNumber()) {
                        maxMessageNumber = operationDataTO.getMessageNumber();
                    }

                    if (minMessageNumber > operationDataTO.getMessageNumber()
                            || minMessageNumber == -1) {
                        minMessageNumber = operationDataTO.getMessageNumber();
                    }

                    ++assignments;
                }
            }

            if (assignments > 0) {
                AVGOperationDataTO aVGOperationDataTO = new AVGOperationDataTO();
                aVGOperationDataTO.setName(operationName);
                aVGOperationDataTO.setMaxMessageNumber(maxMessageNumber);
                aVGOperationDataTO.setMinMessageNumber(minMessageNumber);
                aVGOperationDataTO.setServiceExecutionTime(totalServiceExecutionTime / assignments);
                aVGOperationDataTO.setServiceWaitTimeForResponse(totalServiceWaitTimeForResponse / assignments);
                aVGOperationDataTO.setNetworkOverheadForBusinessMessagesExchangeTime(
                        totalNetworkOverheadForBusinessMessagesExchangeTime / assignments
                );
                aVGOperationDataTO.setCoordinationAlgorithmReasoningTime(
                        totalCoordinationAlgorithmReasoningTime / assignments
                );
                aVGOperationDataTO.setNetworkOverheadForCoordinationMessagesExchangeTime(
                        totalNetworkOverheadForCoordinationMessagesExchangeTime / assignments
                );
                aVGOperationDataTO.setWaitTimeForSchedulingOperation(
                        totalWaitTimeForSchedulingOperation / assignments
                );
                aVGOperationDataTO.setWaitTimeForSynchronizing(totalWaitTimeForSynchronizing / assignments);

                aVGOperationDataTOs.add(aVGOperationDataTO);
            }
        }
        return aVGOperationDataTOs;
    }

    public void deleteInstance(final String choreographyInstancePK) {
        ChoreographyInstance instance = choreographyInstanceDAO.findById(choreographyInstancePK);
        if (instance != null) {
            choreographyInstanceDAO.delete(instance);
        }
    }
}
