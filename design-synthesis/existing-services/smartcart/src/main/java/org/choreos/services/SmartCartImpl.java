package org.choreos.services;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.choreos.services.client.selfcheckoutmachine.SelfCheckOutMachine;
import org.choreos.services.client.selfcheckoutmachine.SelfCheckOutMachineService;
import org.choreos.services.client.selfcheckoutmachine.ShoppingListEntry;
import org.choreos.services.monitor.MonitorLogger;
import org.choreos.services.monitor.MonitorLoggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.chorevolution.idm.common.types.ArtifactType;
import eu.chorevolution.idm.common.types.EventType;

@WebService(endpointInterface = "org.choreos.services.SmartCart")
public class SmartCartImpl implements SmartCart {

    private static Logger logger = LoggerFactory.getLogger(SmartCartImpl.class);
    private static MonitorLogger monitorLogger = new MonitorLoggerImpl();

	private static final String ROLE_SELFCHECKOUTMACHINE = "selfcheckoutmachine";

    protected Map<String, String> address = new HashMap<String, String>();
    
    public void scenarioSetup() {
    	monitorLogger.sendToMonitor();
    }

    public void setEndpointAddress(String address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setInvocationAddress(String role, String name, List<String> endpoints) {
        logger.info("PERFORM -- setInvocationAddress - parameters: role: " + (role.isEmpty() ? "isEmpty parameter" : role) + " - name: " + (name.isEmpty() ? "isEmpty parameter" : name) + " - endpoints[0]: " + (endpoints.get(0).isEmpty() ? "isEmpty parameter" : endpoints.get(0)));
        if (address.containsKey(name)) {
            address.remove(name);
        }
        address.put(name, endpoints.get(0));
    }

    public void addProduct(String sessionId, String cartId, Product product, Integer qty) throws ScenarioException_Exception {
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SmartCart", ArtifactType.SERVICE, "SmartCart", "S15", "S16", "add_product", null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());
        // TODO
        //SLEEP FOR SIMULATING REAL INTERACTION
        try {
            int running = Integer.parseInt(Configuration.get("running_number"));

            switch (running) {
            case 0:
               Thread.sleep(20);
               break;
            case 1:
               Thread.sleep(40);
               break;
            case 2:
               Thread.sleep(80);
               break;
            case 3:
               Thread.sleep(120);
               break;
            case 4:
               Thread.sleep(160);
               break;
            case 5:
               Thread.sleep(200);
               break;
            case 6:
               Thread.sleep(240);
               break;
            case 7:
               Thread.sleep(280);
               break;
            case 8:
               Thread.sleep(320);
               break;
            case 9:
               Thread.sleep(360);
               break;
            case 10:
               Thread.sleep(400);
               break;
            }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        logger.info("PERFORM -- SmartCart.addProduct(String sessionId, String cartId, Product product, Integer qty)");
		monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SmartCart", ArtifactType.SERVICE, "SmartCart", "S10", "S11", "add_product", null, EventType.REPLY_RESPONSE, System.currentTimeMillis());

    }

    public void removeProduct(String sessionId, String cartId, Product product) throws ScenarioException_Exception {
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SmartCart", ArtifactType.SERVICE, "SmartCart", "S6", "S7", "remove_product", null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());
        // TODO
        logger.info("PERFORM -- SmartCart.removeProduct(String sessionId, String cartId, Product product)");
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SmartCart", ArtifactType.SERVICE, "SmartCart", "S6", "S7", "remove_product", null, EventType.REPLY_RESPONSE, System.currentTimeMillis());
    }

    public void changeQty(String sessionId, String cartId, Product product, Integer qty) throws ScenarioException_Exception {
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SmartCart", ArtifactType.SERVICE, "SmartCart", "S4", "S5", "change_qty", null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());
        // TODO
    	logger.info("PERFORM -- SmartCart.changeQty(String sessionId, String cartId, Product product, Integer qty)");
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SmartCart", ArtifactType.SERVICE, "SmartCart", "S4", "S5", "change_qty", null, EventType.REPLY_RESPONSE, System.currentTimeMillis());
    }

    public void subscribeUserToCart(String sessionId, String cartId) {
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SmartCart", ArtifactType.SERVICE, "SmartCart", "S10","S11", "subscribeUserToCart", null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());
    	// TODO
        logger.info("PERFORM -- SmartCart.subscribeUserToCart(String sessionId, String cartId)");

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
        
        monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SmartCart", ArtifactType.SERVICE, "SmartCart", "S10","S11", "subscribeUserToCart", null, EventType.REPLY_RESPONSE, System.currentTimeMillis());
    }

    public void unsubscribeUserFrom(String sessionId, String cartId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void payRequired(String sessionId, String cartId, String comId) {
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SmartCart", ArtifactType.SERVICE, "SmartCart", "S23","S25", "payRequired", null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());
        logger.info("PERFORM -- SmartCart.payRequired(String sessionId, String cartId, String comId)");
        //call selfCheckOutMachine.pay(sessionId, comId, shoppingBag);
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
        List<ShoppingListEntry> shoppingBag = new ArrayList<>();
        ManageCallPayOfSelfCheckOutMachine manageCallPayOfSelfCheckOutMachine = new ManageCallPayOfSelfCheckOutMachine(sessionId, comId, shoppingBag);
        Thread threadManageCallPayOfSelfCheckOutMachine = new Thread(manageCallPayOfSelfCheckOutMachine);
        threadManageCallPayOfSelfCheckOutMachine.start();
        monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SmartCart", ArtifactType.SERVICE, "SmartCart", "S23","S25", "payRequired", null, EventType.REPLY_RESPONSE, System.currentTimeMillis());
    }

    public boolean isAvailable(String cartId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class ManageCallPayOfSelfCheckOutMachine implements Runnable {

        private String sessionId;
        private String comId;
        List<ShoppingListEntry> shoppingBag;

        public ManageCallPayOfSelfCheckOutMachine() {
            List<ShoppingListEntry> shoppingBag = new ArrayList<>();
            sessionId = "";
            comId = "";
        }

        public ManageCallPayOfSelfCheckOutMachine(String sessionId, String comId, List<ShoppingListEntry> shoppingBag) {
            this.sessionId = sessionId;
            this.comId = comId;
            this.shoppingBag = shoppingBag;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getComId() {
            return comId;
        }

        public void setComId(String comId) {
            this.comId = comId;
        }

        public List<ShoppingListEntry> getShoppingBag() {
            return shoppingBag;
        }

        public void setShoppingBag(List<ShoppingListEntry> shoppingBag) {
            this.shoppingBag = shoppingBag;
        }

        @Override
        public void run() {
            try {
                SelfCheckOutMachineService selfCheckOutMachineService = new SelfCheckOutMachineService(new URL(address.get(ROLE_SELFCHECKOUTMACHINE)));
                SelfCheckOutMachine selfCheckOutMachine = selfCheckOutMachineService.getSelfCheckOutMachinePort();
                // TODO how to define shoppingBag ?
            	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SmartCart", ArtifactType.SERVICE, "SmartCart", "S25","S19", "pay", null, EventType.SENDING_REQUEST, System.currentTimeMillis());
                selfCheckOutMachine.pay(sessionId, comId, shoppingBag);
                monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SmartCart", ArtifactType.SERVICE, "SmartCart", "S25","S19", "pay", null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());

            } catch (Exception e) {
                logger.error("Error detected:", e);
            }
        }

    }

}
