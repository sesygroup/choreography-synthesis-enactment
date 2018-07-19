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
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import eu.chorevolution.modelingnotations.coord.State;
import eu.chorevolution.modelingnotations.coord.Tuple;

public class StatesWaitQueue {
	
	private List<AtomicReference<StatesWaitElements>> statesWaiting;

	public StatesWaitQueue() {
		statesWaiting = Collections.synchronizedList(new ArrayList<AtomicReference<StatesWaitElements>>());
	}
	
	public synchronized AtomicReference<StatesWaitElements> addStatesWaitElements(State currentState,List<Tuple> waitTuples){
		
		StatesWaitElements statesWaitElements = new StatesWaitElements();
		for (Tuple tuple : waitTuples) {
			StateWaitElement stateWaitElement = new StateWaitElement(currentState,tuple.getSourceState()); 
			statesWaitElements.addStatesWaitElements(stateWaitElement);
		}
		AtomicReference<StatesWaitElements> atomicReference = new AtomicReference<StatesWaitElements>(statesWaitElements);
		statesWaiting.add(atomicReference);
		return atomicReference;
	}
	
	public synchronized AtomicReference<StatesWaitElements> getWaitElements(State waitState){

		for (AtomicReference<StatesWaitElements> atomicReference : statesWaiting) {
			if(atomicReference.get().containsWaitState(waitState))
				return atomicReference;
		}	
		return null;	
	}
	
	
	public synchronized void removeStatesWaitElements(AtomicReference<StatesWaitElements> statesWaitElements){

		statesWaiting.remove(statesWaitElements);		
	}
	
}
