package org.choreos.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.choreos.services.monitor.MonitorLogger;
import org.choreos.services.monitor.MonitorLoggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.chorevolution.idm.common.types.ArtifactType;
import eu.chorevolution.idm.common.types.EventType;

@WebService(endpointInterface = "org.choreos.services.BasicCommunicationDevice")
public class BasicCommunicationDeviceImpl implements BasicCommunicationDevice{
    private static Logger logger = LoggerFactory.getLogger(BasicCommunicationDeviceImpl.class);
    private static MonitorLogger monitorLogger = new MonitorLoggerImpl();
    
    protected Map<String, String> address = new HashMap<String, String>();

    public void scenarioSetup() {
    	monitorLogger.sendToMonitor();
    }
    
    public void setEndpointAddress(String address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setInvocationAddress(String role, String name, List<String> endpoints) {
        logger.info("PERFORM -- setInvocationAddress - parameters: role: "+(role.isEmpty()?"isEmpty parameter":role)+" - name: "+(name.isEmpty()?"isEmpty parameter":name)+" - endpoints[0]: "+(endpoints.get(0).isEmpty()?"isEmpty parameter":endpoints.get(0)));
        if (address.containsKey(role)) {
            address.remove(role);
        }
        address.put(role, endpoints.get(0));
    }

    public void basicCommDeviceSubscribe(String sessionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void basicCommDeviceUnsubscribe(String sessionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void bcdReceiveSms(String sessionId, SMSMessage msg) throws ScenarioException_Exception {
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "BasicCommunicationDevice", ArtifactType.SERVICE, "BasicCommunicationDevice", "S36","S37", "bcd_receive_sms", null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());
        // TODO
        logger.info("PERFORM -- BasicCommunicationDevice.bcdReceiveSms(String sessionId, SMSMessage msg)");
        monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "BasicCommunicationDevice", ArtifactType.SERVICE, "BasicCommunicationDevice", "S36","S37", "bcd_receive_sms", null, EventType.REPLY_RESPONSE, System.currentTimeMillis());
    }
    
}
