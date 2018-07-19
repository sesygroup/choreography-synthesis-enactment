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

package eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm;

import eu.chorevolution.modelingnotations.coord.COORDModel;
import eu.chorevolution.modelingnotations.coord.State;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.priorities.CoordinationDelegatePriorityList;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.queueNotify.NotifyQueues;

public class CoordinationDelegateData {

	private COORDModel coordModel;
	private State initialState;
	private CoordinationChannelManager coordinationChannelManager;
	private CoordinationDelegatePriorityList cdPriorities;
	private NotifyQueues notifyQueues;
	
	public COORDModel getCoordModel() {
		return coordModel;
	}
	public void setCoordModel(COORDModel coordModel) {
		this.coordModel = coordModel;
	}
	
	public State getInitialState() {
		return initialState;
	}
	public void setInitialState(State initialState) {
		this.initialState = initialState;
	}
	public CoordinationChannelManager getCoordinationChannelManager() {
		return coordinationChannelManager;
	}
	public void setCoordinationChannelManager(CoordinationChannelManager coordinationChannelManager) {
		this.coordinationChannelManager = coordinationChannelManager;
	}
	public CoordinationDelegatePriorityList getCdPriorities() {
		return cdPriorities;
	}
	public void setCdPriorities(CoordinationDelegatePriorityList cdPriorities) {
		this.cdPriorities = cdPriorities;
	}
	public NotifyQueues getNotifyQueues() {
		return notifyQueues;
	}
	public void setNotifyQueues(NotifyQueues notifyQueues) {
		this.notifyQueues = notifyQueues;
	}
	
	
	
	
}
