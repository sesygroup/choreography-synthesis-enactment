
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

@WebService(endpointInterface = "org.choreos.services.InStoreTotem")
public class InStoreTotemImpl implements InStoreTotem{

    private static Logger logger = LoggerFactory.getLogger(InStoreTotemImpl.class);
    private static MonitorLogger monitorLogger = new MonitorLoggerImpl();

    protected Map<String, String> address = new HashMap<String, String>();
    
    public void scenarioSetup() {
    	monitorLogger.sendToMonitor();
    }
    
    public void setInvocationAddress(String role, String name, List<String> endpoints) {
        logger.info("PERFORM -- setInvocationAddress - parameters: role: " + (role.isEmpty() ? "isEmpty parameter" : role) + " - name: " + (name.isEmpty() ? "isEmpty parameter" : name) + " - endpoints[0]: " + (endpoints.get(0).isEmpty() ? "isEmpty parameter" : endpoints.get(0)));
        if (address.containsKey(role)) {
            address.remove(role);
        }
        address.put(role, endpoints.get(0));
    }

    public void setEndpointAddress(String address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void publish(String sessionId, Offer offer) throws ScenarioException_Exception {
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "InStoreTotem", ArtifactType.SERVICE, "InStoreTotem", "S39","S29", "publish", null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());
        // TODO
        //SLEEP FOR SIMULATING REAL INTERACTION
        try {
        	int running = Integer.parseInt(Configuration.get("running_number"));

        	switch (running) {
			case 0:
				Thread.sleep(50);
				break;
			case 1:
				Thread.sleep(100);
				break;
			case 2:
				Thread.sleep(200);
				break;
			case 3:
				Thread.sleep(300);
				break;
			case 4:
				Thread.sleep(400);
				break;
			case 5:
				Thread.sleep(500);
				break;
			case 6:
				Thread.sleep(600);
				break;
			case 7:
				Thread.sleep(700);
				break;
			case 8:
				Thread.sleep(800);
				break;
			case 9:
				Thread.sleep(900);
				break;
			case 10:
				Thread.sleep(1000);
				break;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        logger.info("PERFORM -- InStoreTotemImpl.publish(String sessionId, Offer offer)");
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "InStoreTotem", ArtifactType.SERVICE, "InStoreTotem", "S39","S29", "publish", null, EventType.REPLY_RESPONSE, System.currentTimeMillis());
    }

}
