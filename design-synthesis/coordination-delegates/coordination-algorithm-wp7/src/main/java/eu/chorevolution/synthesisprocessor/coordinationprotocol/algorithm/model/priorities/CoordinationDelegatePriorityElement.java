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

package eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.priorities;



public class CoordinationDelegatePriorityElement implements Comparable<CoordinationDelegatePriorityElement> {
	
	private String coordinationDelegateName;
	private int coordinationDelegatePriority;
	
	public CoordinationDelegatePriorityElement(String coordinationDelegateName, int coordinationDelegatePrority) {

		this.coordinationDelegateName = coordinationDelegateName;
		this.coordinationDelegatePriority = coordinationDelegatePrority;
	}

	public String getCoordinationDelegateName() {
		return coordinationDelegateName;
	}

	public void setCoordinationDelegateName(String coordinationDelegateName) {
		this.coordinationDelegateName = coordinationDelegateName;
	}

	public int getCoordinationDelegatePrority() {
		return coordinationDelegatePriority;
	}

	public void setCoordinationDelegatePrority(int coordinationDelegatePrority) {
		this.coordinationDelegatePriority = coordinationDelegatePrority;
	}

	@Override
	public int compareTo(CoordinationDelegatePriorityElement o) {
		
		int comparePriority = o.getCoordinationDelegatePrority();
		return comparePriority - this.coordinationDelegatePriority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordinationDelegateName == null) ? 0 : coordinationDelegateName.hashCode());
		result = prime * result + coordinationDelegatePriority;
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
		CoordinationDelegatePriorityElement other = (CoordinationDelegatePriorityElement) obj;
		if (coordinationDelegateName == null) {
			if (other.coordinationDelegateName != null)
				return false;
		} else if (!coordinationDelegateName.equals(other.coordinationDelegateName))
			return false;
		if (coordinationDelegatePriority != other.coordinationDelegatePriority)
			return false;
		return true;
	}

	
	

}
