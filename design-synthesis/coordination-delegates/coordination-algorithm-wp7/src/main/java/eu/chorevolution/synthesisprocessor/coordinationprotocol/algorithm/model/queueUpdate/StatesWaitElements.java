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
package eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.queueUpdate;

import java.util.ArrayList;
import java.util.List;

import eu.chorevolution.modelingnotations.coord.State;

public class StatesWaitElements {
	
	private List<StateWaitElement> statesWaitingElements;

	public StatesWaitElements() {
		statesWaitingElements = new ArrayList<StateWaitElement>();
	}

	public synchronized List<StateWaitElement> getStatesWaitingElements() {
		return statesWaitingElements;
	}

	public synchronized void setStatesWaitingElements(List<StateWaitElement> statesWaitingElements) {
		this.statesWaitingElements = statesWaitingElements;
	}
	
	public synchronized void addStatesWaitElements(StateWaitElement stateWaitElement){
		statesWaitingElements.add(stateWaitElement);
	}
	
	public synchronized boolean containsWaitState(State waitState){

		for (StateWaitElement stateWaitElement : statesWaitingElements) {
			if(stateWaitElement.getWaitState().getName().equals(waitState.getName()))
				return true;
		}
		return false;
	}

	public synchronized StateWaitElement getStateWaitElement(State waitState){
		
		for (StateWaitElement stateWaitElement : statesWaitingElements) {
			if(stateWaitElement.getWaitState().getName().equals(waitState.getName()))
				return stateWaitElement;
		}
		return null;		
	}

	@Override
	public String toString() {
		return "StatesWaitElements [statesWaitingElements=" + statesWaitingElements + "]";
	}
 
	

}
