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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CoordinationDelegatePriorityList {
	
	private List<CoordinationDelegatePriorityElement> list;

	public CoordinationDelegatePriorityList() {

		list = new ArrayList<CoordinationDelegatePriorityElement>(); 
	}
	
	public List<CoordinationDelegatePriorityElement> getList() {
		
		return list;
	}

	public void setList(List<CoordinationDelegatePriorityElement> list) {
		
		this.list = list;
	}
	
	public void addCoordinationDelegateProrityElement(String coordinationDelegateName, int coordinationDelegatePriority){
		
		CoordinationDelegatePriorityElement coordinationDelegatePriorityElement = new CoordinationDelegatePriorityElement(coordinationDelegateName, coordinationDelegatePriority);
		list.add(coordinationDelegatePriorityElement);
	}
	
	public CoordinationDelegatePriorityElement getCoordinationDelegatePriorityElement(String coordinationDelegateName){

		for (CoordinationDelegatePriorityElement coordinationDelegatePriorityElement : list) {
			if(coordinationDelegatePriorityElement.getCoordinationDelegateName().equals(coordinationDelegateName)){
				return coordinationDelegatePriorityElement;
			}
		}
		
		return null;
	}
	
	

}
