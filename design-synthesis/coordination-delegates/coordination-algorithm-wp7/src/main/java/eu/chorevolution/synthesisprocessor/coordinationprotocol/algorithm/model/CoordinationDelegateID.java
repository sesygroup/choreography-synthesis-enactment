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

package eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model;

public class CoordinationDelegateID {
	
	private String coordinatedServiceEndpointName;
	private String choreographyID;
	
	
	public CoordinationDelegateID() {
	}

	public CoordinationDelegateID(String coordinatedServiceEndpointName, String choreographyID) {
		this.coordinatedServiceEndpointName = coordinatedServiceEndpointName;
		this.choreographyID = choreographyID;
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
	
	@Override
	public String toString() {
		return "CoordinationDelegateID [coordinatedServiceEndpointName=" + coordinatedServiceEndpointName
				+ ", choreographyID=" + choreographyID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((choreographyID == null) ? 0 : choreographyID.hashCode());
		result = prime * result + ((coordinatedServiceEndpointName == null) ? 0 : coordinatedServiceEndpointName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoordinationDelegateID other = (CoordinationDelegateID) obj;
		if (choreographyID == null) {
			if (other.choreographyID != null)
				return false;
		} else if (!choreographyID.equals(other.choreographyID))
			return false;
		if (coordinatedServiceEndpointName == null) {
			if (other.coordinatedServiceEndpointName != null)
				return false;
		} else if (!coordinatedServiceEndpointName.equals(other.coordinatedServiceEndpointName))
			return false;
		return true;
	}
		
		
	
}
