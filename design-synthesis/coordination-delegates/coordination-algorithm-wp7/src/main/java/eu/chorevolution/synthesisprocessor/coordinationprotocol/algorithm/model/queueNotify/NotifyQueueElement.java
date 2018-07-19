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

package eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.queueNotify;

import eu.chorevolution.modelingnotations.coord.Participant;
import eu.chorevolution.modelingnotations.coord.State;

public class NotifyQueueElement {
	
	private State predecessor;
	private Participant coordinationDelegate;
	private State join;
	
	public NotifyQueueElement(State predecessor, Participant coordinationDelegate, State join) {
		this.predecessor = predecessor;
		this.coordinationDelegate = coordinationDelegate;
		this.join = join;
	}

	public State getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(State predecessor) {
		this.predecessor = predecessor;
	}

	public Participant getCoordinationDelegate() {
		return coordinationDelegate;
	}

	public void setCoordinationDelegate(Participant coordinationDelegate) {
		this.coordinationDelegate = coordinationDelegate;
	}

	public State getJoin() {
		return join;
	}

	public void setJoin(State join) {
		this.join = join;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordinationDelegate == null) ? 0 : coordinationDelegate.hashCode());
		result = prime * result + ((join == null) ? 0 : join.hashCode());
		result = prime * result + ((predecessor == null) ? 0 : predecessor.hashCode());
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
		NotifyQueueElement other = (NotifyQueueElement) obj;
		if (coordinationDelegate == null) {
			if (other.coordinationDelegate != null)
				return false;
		} else if (!coordinationDelegate.getName().equals(other.coordinationDelegate.getName()))
			return false;
		if (join == null) {
			if (other.join != null)
				return false;
		} else if (!join.getName().equals(other.join.getName()))
			return false;
		if (predecessor == null) {
			if (other.predecessor != null)
				return false;
		} else if (!predecessor.getName().equals(other.predecessor.getName()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NOTIFY[predecessor=" + predecessor.getName() + ", coordinationDelegate=" + coordinationDelegate.getName() + ", join=" + join.getName() + "]";
	}

	
}
