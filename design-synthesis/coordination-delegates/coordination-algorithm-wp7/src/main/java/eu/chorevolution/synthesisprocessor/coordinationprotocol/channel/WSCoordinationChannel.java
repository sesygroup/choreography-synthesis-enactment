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

package eu.chorevolution.synthesisprocessor.coordinationprotocol.channel;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.CoordinationDelegateAlgorithm;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.CoordinationDelegateFactory;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.CoordinationDelegateID;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.additionalMessages.AdditionalMessageNotify;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.additionalMessages.AdditionalMessageUpdate;

@WebService(serviceName = "WSCoordinationChannelService", targetNamespace = "http://eu.chorevolution.synthesisprocessor.coordinationprotocol.channel.client/", portName = "WSCoordinationChannelPort")
public class WSCoordinationChannel {

	final Logger logger = LoggerFactory.getLogger(WSCoordinationChannel.class);

	@WebMethod(operationName = "update")
	@Oneway
	public void update(@WebParam(name = "additionalMessage") AdditionalMessageUpdate additionalMessage) {
		CoordinationDelegateID coordinationDelegateID = new CoordinationDelegateID();
		coordinationDelegateID.setCoordinatedServiceEndpointName(additionalMessage.getCoordinationDelegateTo());
		coordinationDelegateID.setChoreographyID(additionalMessage.getChoreographyID());
		CoordinationDelegateAlgorithm algorithm = CoordinationDelegateFactory.getCoordinationDelegateAlgorithm(coordinationDelegateID, additionalMessage.getCoordinationDelegateTo());
		algorithm.receiveUpdateCurrentState(additionalMessage);

	}
	
	@WebMethod(operationName = "notify")
	@Oneway
	public void notify(@WebParam(name = "additionalMessageNotify") AdditionalMessageNotify additionalMessage) {
		CoordinationDelegateID coordinationDelegateID = new CoordinationDelegateID();
		coordinationDelegateID.setCoordinatedServiceEndpointName(additionalMessage.getCoordinationDelegateTo());
		coordinationDelegateID.setChoreographyID(additionalMessage.getChoreographyID());
		CoordinationDelegateAlgorithm algorithm = CoordinationDelegateFactory.getCoordinationDelegateAlgorithm(coordinationDelegateID, additionalMessage.getCoordinationDelegateTo());
		algorithm.receiveNotify(additionalMessage);
	}
}
