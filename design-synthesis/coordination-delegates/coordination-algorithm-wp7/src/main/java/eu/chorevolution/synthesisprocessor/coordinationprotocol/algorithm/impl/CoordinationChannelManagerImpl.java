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

package eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.impl;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.CoordinationChannelManager;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.CoordinationDelegateFactory;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.channel.client.AdditionalMessageNotify;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.channel.client.AdditionalMessageUpdate;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.channel.client.WSCoordinationChannel;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.channel.client.WSCoordinationChannelService;

public class CoordinationChannelManagerImpl implements CoordinationChannelManager {
	
	private static Logger logger = LoggerFactory.getLogger(CoordinationChannelManagerImpl.class);
	
	
	public CoordinationChannelManagerImpl() {
	}

	@Override
	public void update(eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.additionalMessages.AdditionalMessageUpdate additionalMessageUpdate) {
		WSCoordinationChannelService coordinationChannelService = new WSCoordinationChannelService(createUrl(additionalMessageUpdate.getCoordinationDelegateTo()), new QName("http://eu.chorevolution.synthesisprocessor.coordinationprotocol.channel.client/", "WSCoordinationChannelService"));
		WSCoordinationChannel coordinationChannelPort = coordinationChannelService.getWSCoordinationChannelPort();
		AdditionalMessageUpdate newAdditionalMessageUpdate = new AdditionalMessageUpdate(); 
		newAdditionalMessageUpdate.setCoordinatedServiceEndpointName(additionalMessageUpdate.getCoordinatedServiceEndpointName());
		newAdditionalMessageUpdate.setChoreographyID(additionalMessageUpdate.getChoreographyID());
		newAdditionalMessageUpdate.setCoordinationDelegateFrom(additionalMessageUpdate.getCoordinationDelegateFrom());
		newAdditionalMessageUpdate.setCoordinationDelegateTo(additionalMessageUpdate.getCoordinationDelegateTo());
		newAdditionalMessageUpdate.setRequest(additionalMessageUpdate.getRequest());
		newAdditionalMessageUpdate.setState(additionalMessageUpdate.getState());

		// send update to CoordinationDelegateTo
		coordinationChannelPort.update(newAdditionalMessageUpdate);
		
	}
	
	@Override
	public void notify(eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.additionalMessages.AdditionalMessageNotify additionalMessageNotify) {
		WSCoordinationChannelService coordinationChannelService = new WSCoordinationChannelService(createUrl(additionalMessageNotify.getCoordinationDelegateTo()), new QName("http://eu.chorevolution.synthesisprocessor.coordinationprotocol.channel.client/", "WSCoordinationChannelService"));
		WSCoordinationChannel coordinationChannelPort = (WSCoordinationChannel) coordinationChannelService.getWSCoordinationChannelPort();
		AdditionalMessageNotify newAdditionalMessageNotify = new AdditionalMessageNotify(); 
		newAdditionalMessageNotify.setCoordinatedServiceEndpointName(additionalMessageNotify.getCoordinatedServiceEndpointName());
		newAdditionalMessageNotify.setChoreographyID(additionalMessageNotify.getChoreographyID());
		newAdditionalMessageNotify.setCoordinationDelegateFrom(additionalMessageNotify.getCoordinationDelegateFrom());
		newAdditionalMessageNotify.setCoordinationDelegateTo(additionalMessageNotify.getCoordinationDelegateTo());
		newAdditionalMessageNotify.setPrecedessor(additionalMessageNotify.getPrecedessor());;
		newAdditionalMessageNotify.setJoin(additionalMessageNotify.getJoin());
		
		// send notify to CoordinationDelegateTo
		coordinationChannelPort.notify(newAdditionalMessageNotify);
		
	}
	
	private URL createUrl(String coordinationDelegateTo) {
		
		String urlName = getParticipantUrl(coordinationDelegateTo);
		String urlNameNew = urlName.substring(0,urlName.lastIndexOf("/")) + "/WSCoordinationChannel";
		URL url = null;
        try {
            URL baseUrl;
            baseUrl = WSCoordinationChannel.class.getResource(".");
            url = new URL(baseUrl, urlNameNew);
        } catch (MalformedURLException e) {
			logger.debug(e.getStackTrace().toString());
        }
        return url;
	}

	private String getParticipantUrl(String coordinationDelegateTo) {

		return CoordinationDelegateFactory.getAddress(coordinationDelegateTo);
	}



}
