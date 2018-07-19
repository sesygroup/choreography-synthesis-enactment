package org.choreos.services.cd;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Provider;
import javax.xml.ws.Service;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;

import org.choreos.services.monitor.MonitorLogger;
import org.choreos.services.monitor.MonitorLoggerImpl;
import org.choreos.services.cd.utility.PropertyConfiguration;
import org.choreos.services.cd.utility.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMException;

import eu.chorevolution.idm.common.types.ArtifactType;
import eu.chorevolution.modelingnotations.coord.AllowedOperation;
import eu.chorevolution.modelingnotations.coord.CoordFactory;
import eu.chorevolution.modelingnotations.coord.Participant;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.CoordinationDelegateAlgorithm;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.CoordinationDelegateFactory;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.ForwardMessagesCallback;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.ContextData;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.CoordinationDelegateID;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.ResponseData;

@ServiceMode(value=Service.Mode.MESSAGE)
@WebServiceProvider()
public class CDimpl implements Provider<SOAPMessage>{

    private static Logger logger = LoggerFactory.getLogger(CDimpl.class);
    
	@Override
	public SOAPMessage invoke(SOAPMessage message) {

		SOAPMessage response = null;
		ResponseData responseData = null;
    	try {
    		int length = message.getMimeHeaders().getHeader("soapaction")[0].split("/").length;
			String requestSOAP = message.getMimeHeaders().getHeader("soapaction")[0].split("/")[length-1];
			requestSOAP = requestSOAP.replace("\"","").replace("Request", "");
			if(requestSOAP.equals("setInvocationAddress")){
    			String role = Utilities.getRoleSetInvocationAddressMessage(message);
    			String name = Utilities.getNameSetInvocationAddressMessage(message);
    			List<String> endpoints = Utilities.getEndpointsSetInvocationAddressMessage(message);
    			if(role != null && name != null && endpoints != null){
        			setInvocationAddress(role,name,endpoints);
        		    response = Utilities.createSetInvocationAddressMessageResponse(message);   				
    			}
    		}
			else if (requestSOAP.equals("scenarioSetup")){
				MonitorLogger monitor = new MonitorLoggerImpl();
				monitor.sendToMonitor();
			}
    		else{
    			Map<String, Object> data = new HashMap<String, Object>();
    			String sessionId = message.getSOAPBody().getElementsByTagName("sessionId").item(0).getTextContent();
    			data.put("sessionId", sessionId);
    			data.put("message", message);	
    			ContextData contextData = new ContextData(data);
    			AllowedOperation request = CoordFactory.eINSTANCE.createAllowedOperation();
    			request.setName(requestSOAP);
    			Participant coordinationDelegateFrom = CoordFactory.eINSTANCE.createParticipant();
    			coordinationDelegateFrom.setName(PropertyConfiguration.getInstance().getStringValue("cd_name"));
    			data.put("cdName", coordinationDelegateFrom.getName());
    			data.put("request",request.getName());
    	    	CoordinationDelegateID coordinationDelegateID = new CoordinationDelegateID(PropertyConfiguration.getInstance().getStringValue("cd_name"), sessionId);
       			CoordinationDelegateAlgorithm algorithm = CoordinationDelegateFactory.getCoordinationDelegateAlgorithm(coordinationDelegateID,PropertyConfiguration.getInstance().getStringValue("cd_name"));
    			responseData = algorithm.handleRules(request,coordinationDelegateFrom, new CDcallback(), contextData); 
    			response = (SOAPMessage) responseData.getData(); 
    		}
		} catch (DOMException | SOAPException e) {
			logger.info(e.getMessage());
		}  
    	return response;
	}

	public void setInvocationAddress(String role, String name, List<String> endpoints) {

        logger.info("PERFORM -- setInvocationAddress - parameters: role: " + (role.isEmpty() ? "isEmpty parameter" : role) + " - name: " + (name.isEmpty() ? "isEmpty parameter" : name) + " - endpoints[0]: " + (endpoints.get(0).isEmpty() ? "isEmpty parameter" : endpoints.get(0)));
        if(CoordinationDelegateFactory.containsAddress(role)){
        	CoordinationDelegateFactory.removeAddress(role);
        }
        CoordinationDelegateFactory.addAddress(role, endpoints.get(0));
	}

	public class CDcallback implements ForwardMessagesCallback{

		@Override
		public ResponseData forwardMessage(ContextData contextData) {

			ResponseData response = null;
			Map<String, Object> data = (Map<String, Object>)contextData.getData();
			SOAPMessage message = (SOAPMessage) data.get("message");
			QName portQName = new QName(PropertyConfiguration.getInstance().getStringValue("port_namespaceURI"),PropertyConfiguration.getInstance().getStringValue("port_localPart"));
			try {
				Service service = Service.create((new URL(CoordinationDelegateFactory.getAddress(PropertyConfiguration.getInstance().getStringValue("cd_role"))+"?wsdl")), new QName(PropertyConfiguration.getInstance().getStringValue("service_namespaceURI"),PropertyConfiguration.getInstance().getStringValue("service_localPart")));
				Dispatch<SOAPMessage> smDispatch = service.createDispatch(portQName, SOAPMessage.class, Service.Mode.MESSAGE);
		    	// MONITOR log the start of forwarding of the request
				MonitorLogger monitorLogger = new MonitorLoggerImpl();
				SOAPMessage responseMessage = smDispatch.invoke(message);
				response = new ResponseData(responseMessage);	
		    	// MONITOR log the end of forwarding of the request
			} catch (MalformedURLException e) {
				logger.info(e.getMessage());
			} 
			return response;
		}
	}

}
