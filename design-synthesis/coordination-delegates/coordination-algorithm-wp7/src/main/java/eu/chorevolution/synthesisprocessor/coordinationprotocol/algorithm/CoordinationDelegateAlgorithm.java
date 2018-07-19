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

import eu.chorevolution.modelingnotations.coord.AllowedOperation;
import eu.chorevolution.modelingnotations.coord.Participant;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.ContextData;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.CoordinationDelegateID;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.ResponseData;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.additionalMessages.AdditionalMessageNotify;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.additionalMessages.AdditionalMessageUpdate;

public interface CoordinationDelegateAlgorithm {

	ResponseData handleRules(AllowedOperation request, Participant coordinationDelegateFrom, ForwardMessagesCallback messagesCallback, ContextData contextData);

	void receiveUpdateCurrentState(AdditionalMessageUpdate additionalMessage);
	
	void receiveNotify(AdditionalMessageNotify additionalMessageNotify);
		
	CoordinationDelegateID getId();

	void setId(CoordinationDelegateID id);

}