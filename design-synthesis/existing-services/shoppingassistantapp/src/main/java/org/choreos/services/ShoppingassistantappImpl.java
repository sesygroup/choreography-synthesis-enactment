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

@WebService(endpointInterface = "org.choreos.services.Shoppingassistantapp")
public class ShoppingassistantappImpl implements Shoppingassistantapp {

    private static Logger logger = LoggerFactory.getLogger(ShoppingassistantappImpl.class);
    private static MonitorLogger monitorLogger = new MonitorLoggerImpl();

    protected Map<String, String> address = new HashMap<String, String>();

    public void scenarioSetup() {
    	monitorLogger.sendToMonitor();
    }

    public void setEndpointAddress(String address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setInvocationAddress(String role, String name, List<String> endpoints) {
        logger.info("PERFORM -- setInvocationAddress - parameters: role: " + (role.isEmpty() ? "isEmpty parameter" : role) + " - name: " + (name.isEmpty() ? "isEmpty parameter" : name) + " - endpoints[0]: " + (endpoints.get(0).isEmpty() ? "isEmpty parameter" : endpoints.get(0)));
        if (address.containsKey(role)) {
            address.remove(role);
        }
        address.put(role, endpoints.get(0));
    }

    public void shopAssistAppSubscribe(String sessionId) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void shopAssistAppUnsubscribe(String sessionId) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void privateOffer(String sessionId, Offer offer) throws ScenarioException_Exception {
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "ShoppingAssistants", ArtifactType.SERVICE, "ShoppingAssistants", "S31","S32", "private_offer", null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());
        // TODO
        //SLEEP FOR SIMULATING REAL INTERACTION
        try {
        	int running = Integer.parseInt(Configuration.get("running_number"));

            switch (running) {
            case 0:
               Thread.sleep(100);
               break;
            case 1:
               Thread.sleep(200);
               break;
            case 2:
               Thread.sleep(400);
               break;
            case 3:
               Thread.sleep(600);
               break;
            case 4:
               Thread.sleep(800);
               break;
            case 5:
               Thread.sleep(1000);
               break;
            case 6:
               Thread.sleep(1200);
               break;
            case 7:
               Thread.sleep(1400);
               break;
            case 8:
               Thread.sleep(1600);
               break;
            case 9:
               Thread.sleep(1800);
               break;
            case 10:
               Thread.sleep(2000);
               break;
            }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        logger.info("PERFORM -- ShoppingassistantappImpl.privateOffer(String sessionId, Offer offer)");
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "ShoppingAssistants", ArtifactType.SERVICE, "ShoppingAssistants", "S31","S32", "private_offer", null, EventType.REPLY_RESPONSE, System.currentTimeMillis());
    }

    public void recordBoughtItems(String sessionId, List<Product> items) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void communicateQuestionnaire(String sessionId, Questionnaire q) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void remind(String sessionId, Reminder rem) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void communicateIncentive(String sessionId, Specialoffer inc) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
