/*
 * Copyright 2016 The CHOReVOLUTION project.
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
package eu.chorevolution.idm.common.to;

import org.apache.syncope.common.lib.AbstractBaseBean;

public class OperationDataTO extends AbstractBaseBean {

    private static final long serialVersionUID = -6958102559837415816L;

    private String name;

    private long receivingServiceExecutionTime;

    private long callingServiceWaitTimeForResponse;

    private long networkOverheadForBusinessMessagesExchangeTime;

    private long coordinationAlgorithmReasoningTime;

    private long networkOverheadForCoordinationMessagesExchangeTime;

    private long waitTimeForSchedulingOperation;

    private long waitTimeForSynchronizing;

    private int messageNumber;

    private String initiatingServiceName;

    private String receivingServiceName;

    private String coordinatingCDName;

    private long timeCalledByInitiatingService;

    private long timeReceivedByCD;

    private long timeScheduledByCD;

    private long timeReceivedByCalledService;

    private long timeRepliedByCalledService;

    private long timeReceivedByInitiatingService;

    private int discardedOperations;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public long getReceivingServiceExecutionTime() {
        return receivingServiceExecutionTime;
    }

    public void setReceivingServiceExecutionTime(final long receivingServiceExecutionTime) {
        this.receivingServiceExecutionTime = receivingServiceExecutionTime;
    }

    public long getCallingServiceWaitTimeForResponse() {
        return callingServiceWaitTimeForResponse;
    }

    public void setCallingServiceWaitTimeForResponse(final long serviceWaitTimeForResponse) {
        this.callingServiceWaitTimeForResponse = serviceWaitTimeForResponse;
    }

    public long getNetworkOverheadForBusinessMessagesExchangeTime() {
        return networkOverheadForBusinessMessagesExchangeTime;
    }

    public void setNetworkOverheadForBusinessMessagesExchangeTime(
            final long networkOverheadForBusinessMessagesExchangeTime) {
        this.networkOverheadForBusinessMessagesExchangeTime = networkOverheadForBusinessMessagesExchangeTime;
    }

    public long getCoordinationAlgorithmReasoningTime() {
        return coordinationAlgorithmReasoningTime;
    }

    public void setCoordinationAlgorithmReasoningTime(final long coordinationAlgorithmReasoningTime) {
        this.coordinationAlgorithmReasoningTime = coordinationAlgorithmReasoningTime;
    }

    public long getNetworkOverheadForCoordinationMessagesExchangeTime() {
        return networkOverheadForCoordinationMessagesExchangeTime;
    }

    public void setNetworkOverheadForCoordinationMessagesExchangeTime(
            final long networkOverheadForCoordinationMessagesExchangeTime) {
        this.networkOverheadForCoordinationMessagesExchangeTime = networkOverheadForCoordinationMessagesExchangeTime;
    }

    public long getWaitTimeForSchedulingOperation() {
        return waitTimeForSchedulingOperation;
    }

    public void setWaitTimeForSchedulingOperation(final long waitTimeForSchedulingOperation) {
        this.waitTimeForSchedulingOperation = waitTimeForSchedulingOperation;
    }

    public long getWaitTimeForSynchronizing() {
        return waitTimeForSynchronizing;
    }

    public void setWaitTimeForSynchronizing(final long waitTimeForSynchronizing) {
        this.waitTimeForSynchronizing = waitTimeForSynchronizing;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(final int messageNumber) {
        this.messageNumber = messageNumber;
    }

    public String getInitiatingServiceName() {
        return initiatingServiceName;
    }

    public void setInitiatingServiceName(final String initiatingServiceName) {
        this.initiatingServiceName = initiatingServiceName;
    }

    public String getReceivingServiceName() {
        return receivingServiceName;
    }

    public void setReceivingServiceName(final String receivingServiceName) {
        this.receivingServiceName = receivingServiceName;
    }

    public String getCoordinatingCDName() {
        return coordinatingCDName;
    }

    public void setCoordinatingCDName(final String coordinatingCDName) {
        this.coordinatingCDName = coordinatingCDName;
    }

    public long getTimeCalledByInitiatingService() {
        return timeCalledByInitiatingService;
    }

    public void setTimeCalledByInitiatingService(final long timeCalledByInitiatingService) {
        this.timeCalledByInitiatingService = timeCalledByInitiatingService;
    }

    public long getTimeReceivedByCD() {
        return timeReceivedByCD;
    }

    public void setTimeReceivedByCD(final long timeReceivedByCD) {
        this.timeReceivedByCD = timeReceivedByCD;
    }

    public long getTimeScheduledByCD() {
        return timeScheduledByCD;
    }

    public void setTimeScheduledByCD(final long timeScheduledByCD) {
        this.timeScheduledByCD = timeScheduledByCD;
    }

    public long getTimeReceivedByCalledService() {
        return timeReceivedByCalledService;
    }

    public void setTimeReceivedByCalledService(final long timeReceivedByCalledService) {
        this.timeReceivedByCalledService = timeReceivedByCalledService;
    }

    public long getTimeRepliedByCalledService() {
        return timeRepliedByCalledService;
    }

    public void setTimeRepliedByCalledService(final long timeRepliedByCalledService) {
        this.timeRepliedByCalledService = timeRepliedByCalledService;
    }

    public long getTimeReceivedByInitiatingService() {
        return timeReceivedByInitiatingService;
    }

    public void setTimeReceivedByInitiatingService(final long timeReceivedByInitiatingService) {
        this.timeReceivedByInitiatingService = timeReceivedByInitiatingService;
    }

    public int getDiscardedOperations() {
        return discardedOperations;
    }

    public void setDiscardedOperations(final int discardedOperations) {
        this.discardedOperations = discardedOperations;
    }

}
