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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import eu.chorevolution.modelingnotations.coord.State;


public class GlobalStateManager {
	
	private List<State> states;
	
	private State currentState;
	
	public GlobalStateManager(State state) {
		
		this.states = Collections.synchronizedList(new ArrayList<State>());
		this.states.add(state);
		this.currentState = state;
	}
	
	public synchronized void addState(State state){
		
		states.add(state);
	}
	
	public synchronized void updateState(State stateold,State statenew){

		for (Iterator iterator = states.iterator(); iterator.hasNext();) {
			State state = (State) iterator.next();
			if(state.getName().equals(stateold.getName())){
				iterator.remove();
			}
		}
		states.add(statenew);
		currentState=statenew;
	}
	
	public synchronized boolean hasState(State state){

		for (State statei : states) {
			if(statei.getName().equals(state.getName()))
				return true;
		}
		return false;
	}
	
	public synchronized State getCurrentState(){
		
		return currentState;
	}

	public synchronized List<State> getStates() {
		return states;
	}
	
}
