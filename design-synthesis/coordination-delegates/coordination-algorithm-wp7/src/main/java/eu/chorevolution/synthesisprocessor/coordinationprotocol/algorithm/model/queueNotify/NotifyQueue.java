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
import eu.chorevolution.modelingnotations.coord.WaitElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NotifyQueue {

	private List<NotifyQueueElement> queue;

	public NotifyQueue() {

		queue = new ArrayList<NotifyQueueElement>();
	}

	public synchronized void addNotifyQueueElements(WaitElement waitElement, State join) {

		for (Participant participant : waitElement.getParticipants()) {
			NotifyQueueElement notifyQueueElement = new NotifyQueueElement(waitElement.getState(), participant, join);
			queue.add(notifyQueueElement);			
		}
	}
	
	public synchronized void addNotifyQueueElement(State predecessor, Participant participant, State join){
		
		NotifyQueueElement notifyQueueElement = new NotifyQueueElement(predecessor, participant, join);
		queue.add(notifyQueueElement);
	}
	
	public synchronized void addNotifyQueueElement(NotifyQueueElement notifyQueueElement){
		
		queue.add(notifyQueueElement);
	}

	public synchronized List<NotifyQueueElement> getQueue(){
		return queue;
	}
	
	public synchronized void removeNotifyQueueElement(NotifyQueueElement notifyQueueElement) {

		for (NotifyQueueElement notifyQueueElementQ : queue) {
			if (notifyQueueElementQ.getPredecessor().getName().equals(notifyQueueElement.getPredecessor().getName()) && 
					notifyQueueElementQ.getCoordinationDelegate().getName().equals(notifyQueueElement.getCoordinationDelegate().getName()) && 
					notifyQueueElementQ.getJoin().getName().equals(notifyQueueElement.getJoin().getName())) {
					queue.remove(notifyQueueElement);
					break;
				}			
		}
		
	}
		
	public synchronized void waitAllNotify() {
		
		if (!queue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public synchronized boolean checkAndNotifyQueueEmpty() {

		if(queue.isEmpty()){
			notify();
			return true;
		}
		else{
			return false;
		}
	}


	@Override
	public String toString() {
		return "NotifyQueue [queue=" + queue + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((queue == null) ? 0 : queue.hashCode());
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
		NotifyQueue other = (NotifyQueue) obj;
		if (queue == null) {
			if (other.queue != null)
				return false;
		} else for (Iterator iterator = queue.iterator(); iterator.hasNext();) {
			NotifyQueueElement notifyQueueElement = (NotifyQueueElement) iterator.next();
			for (Iterator iterator2 = ((List<NotifyQueueElement>) obj).iterator(); iterator2.hasNext();) {
				NotifyQueueElement notifyQueueElement2 = (NotifyQueueElement) iterator2.next();
				if(!notifyQueueElement.equals(notifyQueueElement2))
					return false;
			}
		}			
		return true;
	}

	
}
