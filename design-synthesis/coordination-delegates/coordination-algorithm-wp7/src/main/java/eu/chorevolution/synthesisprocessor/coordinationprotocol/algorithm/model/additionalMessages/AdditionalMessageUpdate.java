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

package eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.additionalMessages;

public class AdditionalMessageUpdate {

	private String coordinatedServiceEndpointName;
	private String choreographyID;
	
	private String request;
	private String coordinationDelegateFrom;
	private String coordinationDelegateTo;
	private String state;
	
	
	public AdditionalMessageUpdate() {
	}
	
	public AdditionalMessageUpdate(String coordinatedServiceEndpointName, String choreographyID, String request, String coordinationDelegateFrom, String coordinationDelegateTo, String state) {
		this.coordinatedServiceEndpointName = coordinatedServiceEndpointName;
		this.choreographyID = choreographyID;
		this.request = request;
		this.coordinationDelegateFrom = coordinationDelegateFrom;
		this.coordinationDelegateTo = coordinationDelegateTo;
		this.state = state;
	}

	public String getCoordinatedServiceEndpointName() {
		return coordinatedServiceEndpointName;
	}

	public void setCoordinatedServiceEndpointName(String coordinatedServiceEndpointName) {
		this.coordinatedServiceEndpointName = coordinatedServiceEndpointName;
	}

	public String getChoreographyID() {
		return choreographyID;
	}
	public void setChoreographyID(String choreographyID) {
		this.choreographyID = choreographyID;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getCoordinationDelegateFrom() {
		return coordinationDelegateFrom;
	}
	public void setCoordinationDelegateFrom(String coordinationDelegateFrom) {
		this.coordinationDelegateFrom = coordinationDelegateFrom;
	}
	public String getCoordinationDelegateTo() {
		return coordinationDelegateTo;
	}
	public void setCoordinationDelegateTo(String coordinationDelegateTo) {
		this.coordinationDelegateTo = coordinationDelegateTo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "[coordinatedServiceEndpointName=" + coordinatedServiceEndpointName + ", choreographyID=" + choreographyID + ", request=" + request + ", coordinationDelegateFrom=" + coordinationDelegateFrom + ", coordinationDelegateTo=" + coordinationDelegateTo + ", state=" + state + "]";
	}

	
}
