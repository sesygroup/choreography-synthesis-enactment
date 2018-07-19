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

public class AdditionalMessageNotify {

	private String coordinatedServiceEndpointName;
	private String choreographyID;

	private String precedessor;
	private String coordinationDelegateFrom;
	private String coordinationDelegateTo;
	private String join;

	public AdditionalMessageNotify() {
	}

	public AdditionalMessageNotify(String coordinatedServiceEndpointName, String choreographyID, String precedessor, String coordinationDelegateFrom, String coordinationDelegateTo, String join) {
		this.coordinatedServiceEndpointName = coordinatedServiceEndpointName;
		this.choreographyID = choreographyID;
		this.precedessor = precedessor;
		this.coordinationDelegateFrom = coordinationDelegateFrom;
		this.coordinationDelegateTo = coordinationDelegateTo;
		this.join = join;
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

	public String getPrecedessor() {
		return precedessor;
	}

	public void setPrecedessor(String precedessor) {
		this.precedessor = precedessor;
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

	public String getJoin() {
		return join;
	}

	public void setJoin(String join) {
		this.join = join;
	}

	@Override
	public String toString() {
		return "AdditionalMessageNotify [coordinatedServiceEndpointName=" + coordinatedServiceEndpointName + ", choreographyID=" + choreographyID + ", precedessor=" + precedessor + ", coordinationDelegateFrom=" + coordinationDelegateFrom + ", coordinationDelegateTo=" + coordinationDelegateTo + ", join=" + join + "]";
	}
	
	

}
