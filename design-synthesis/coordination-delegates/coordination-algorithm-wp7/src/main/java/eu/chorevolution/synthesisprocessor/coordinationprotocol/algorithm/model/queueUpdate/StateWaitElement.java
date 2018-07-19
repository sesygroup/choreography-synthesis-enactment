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

import eu.chorevolution.modelingnotations.coord.State;

public class StateWaitElement {

	private State sourceWaitState;
	private State waitState;
	
	public StateWaitElement(State sourceWaitState, State waitState) {
		this.sourceWaitState = sourceWaitState;
		this.waitState = waitState;
	}

	public synchronized State getSourceWaitState() {
		return sourceWaitState;
	}

	public synchronized void setSourceWaitState(State sourceWaitState) {
		this.sourceWaitState = sourceWaitState;
	}

	public synchronized State getWaitState() {
		return waitState;
	}

	public synchronized void setWaitState(State waitState) {
		this.waitState = waitState;
	}

	@Override
	public String toString() {
		return "UPDATE("+ waitState.getName() + ") ---> StateWaitElement [sourceWaitState=" + sourceWaitState.getName() + ", waitState=" + waitState.getName() + "]";
	}
	
	
}
