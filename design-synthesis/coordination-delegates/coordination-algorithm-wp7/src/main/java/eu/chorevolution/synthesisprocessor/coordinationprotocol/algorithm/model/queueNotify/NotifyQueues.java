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

import java.util.ArrayList;
import java.util.List;

import eu.chorevolution.modelingnotations.coord.Participant;
import eu.chorevolution.modelingnotations.coord.State;

public class NotifyQueues {

	private List<NotifyQueue> queues;
	
	public NotifyQueues() {	
		queues = new ArrayList<NotifyQueue>();
	}
	
	public void addNotifyQueue(NotifyQueue notifyQueue){
		queues.add(notifyQueue);
	}

	public NotifyQueue getNotifyQueue(NotifyQueueElement notifyQueueElement){

		for (NotifyQueue notifyQueue : queues) {
			for (NotifyQueueElement notifyQueueElementQ : notifyQueue.getQueue()) {
				if(notifyQueueElementQ.equals(notifyQueueElement))
					return notifyQueue;
			}
		}

	    return null;
	}  
	
	public NotifyQueue getNotifyQueue(State predecessor, Participant participant, State join){

		for (NotifyQueue notifyQueue : queues) {
			for (NotifyQueueElement notifyQueueElementQ : notifyQueue.getQueue()) {
				if(notifyQueueElementQ.getPredecessor().getName().equals(predecessor.getName()) &&
						   notifyQueueElementQ.getCoordinationDelegate().getName().equals(participant.getName()) &&
						   notifyQueueElementQ.getJoin().getName().equals(join.getName())){
						   return notifyQueue;	
				}				
			}
		}
		
	    return null;
	}
	
}
