package org.choreos.services;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.choreos.services.client.client.Client;
import org.choreos.services.client.client.ClientService;
import org.choreos.services.client.marketingapplication.MarketingApplication;
import org.choreos.services.client.marketingapplication.MarketingApplicationService;
import org.choreos.services.client.smartcart.SmartCart;
import org.choreos.services.client.smartcart.SmartCartService;
import org.choreos.services.monitor.MonitorLogger;
import org.choreos.services.monitor.MonitorLoggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.chorevolution.idm.common.types.ArtifactType;
import eu.chorevolution.idm.common.types.EventType;

@WebService(endpointInterface = "org.choreos.services.SelfCheckOutMachine")
public class SelfCheckOutMachineImpl implements SelfCheckOutMachine {

    private static Logger logger = LoggerFactory.getLogger(SelfCheckOutMachineImpl.class);
    private static MonitorLogger monitorLogger = new MonitorLoggerImpl();
    
	private static final String ROLE_MARKETINGAPPLICATION = "marketingapplication";
	private static final String ROLE_SMARTCART = "smartcart";
	private static final String ROLE_CLIENT = "client";
    
    
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

    public void pay(String sessionId, String comId, List<ShoppingListEntry> shoppingBag) {
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SelfCheckOutMachine", ArtifactType.SERVICE, "SelfCheckOutMachine", "S25", "S19", "pay", null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());
        logger.info("PERFORM -- SelfCheckOutMachine.pay(String sessionId, String comId, List<ShoppingListEntry> shoppingBag)");
        // call marketingApplication.notifyCheckout(sessionId)
        //SLEEP FOR SIMULATING REAL INTERACTION
        try {

        	int running = Integer.parseInt(Configuration.get("running_number"));

            switch (running) {
            case 0:
               Thread.sleep(1000);
               break;
            case 1:
               Thread.sleep(2000);
               break;
            case 2:
               Thread.sleep(4000);
               break;
            case 3:
               Thread.sleep(6000);
               break;
            case 4:
               Thread.sleep(8000);
               break;
            case 5:
               Thread.sleep(10000);
               break;
            case 6:
               Thread.sleep(12000);
               break;
            case 7:
               Thread.sleep(14000);
               break;
            case 8:
               Thread.sleep(16000);
               break;
            case 9:
               Thread.sleep(18000);
               break;
            case 10:
               Thread.sleep(20000);
               break;
            }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        ManageCallNotifyCheckoutOfMarketingApplication manageCallNotifyCheckoutOfMarketingApplication = new ManageCallNotifyCheckoutOfMarketingApplication(sessionId);
        Thread threadManageCallNotifyCheckoutOfMarketingApplication = new Thread(manageCallNotifyCheckoutOfMarketingApplication);
        threadManageCallNotifyCheckoutOfMarketingApplication.start();

    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SelfCheckOutMachine", ArtifactType.SERVICE, "SelfCheckOutMachine", "S25", "S19", "pay", null, EventType.REPLY_RESPONSE, System.currentTimeMillis());
    }

    public boolean checkout(String sessionId, String cartId) throws ScenarioException_Exception {
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SelfCheckOutMachine", ArtifactType.SERVICE, "SelfCheckOutMachine", "S23", "S23", "checkout", null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());
        logger.info("PERFORM -- SelfCheckOutMachine.checkout(String sessionId, String cartId)");
        // call smartCart.payRequired(sessionId, cartId, comId);
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
        String comID = "1";
        ManageCallPayRequiredOfSmartCart manageCallPayRequiredOfsmartCart = new ManageCallPayRequiredOfSmartCart(sessionId, cartId, comID);
        Thread threadManageCallPayRequiredOfsmartCart = new Thread(manageCallPayRequiredOfsmartCart);
        threadManageCallPayRequiredOfsmartCart.start();
        monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SelfCheckOutMachine", ArtifactType.SERVICE, "SelfCheckOutMachine", "S23", "S23", "checkout", null, EventType.REPLY_RESPONSE, System.currentTimeMillis());
        return true;
    }

    

    private class ManageCallPayRequiredOfSmartCart implements Runnable {

        private String sessionId;
        private String cartId;
        private String comId;

        public ManageCallPayRequiredOfSmartCart() {
            sessionId = "";
            cartId = "";
            comId = "";
        }

        public ManageCallPayRequiredOfSmartCart(String sessionId, String cartId, String comId) {
            this.sessionId = sessionId;
            this.cartId = cartId;
            this.comId = comId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getCartId() {
            return cartId;
        }

        public void setCartId(String cartId) {
            this.cartId = cartId;
        }

        public String getComId() {
            return comId;
        }

        public void setComId(String comId) {
            this.comId = comId;
        }

        @Override
        public void run() {
            try {
                SmartCartService smartCartService = new SmartCartService(new URL(address.get(ROLE_SMARTCART)));
                SmartCart smartCart = smartCartService.getSmartCartPort();
            	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SelfCheckOutMachine", ArtifactType.SERVICE, "SelfCheckOutMachine", "S23","S25", "payRequired", null, EventType.SENDING_REQUEST, System.currentTimeMillis());
                smartCart.payRequired(sessionId, cartId, comId);
            	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SelfCheckOutMachine", ArtifactType.SERVICE, "SelfCheckOutMachine", "S23","S25", "payRequired", null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());
            } catch (Exception e) {
                logger.error("Error detected:", e);
            }
        }

    }

    private class ManageCallNotifyCheckoutOfMarketingApplication implements Runnable {

        private String sessionId;

        public ManageCallNotifyCheckoutOfMarketingApplication() {
            sessionId = "";
        }

        public ManageCallNotifyCheckoutOfMarketingApplication(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        @Override
        public void run() {
            try {
            	
            	if (sessionId.charAt(sessionId.length() - 1) == '5') {
            		//Call client service to force add_product after pay and before checking out
                	ClientService clientService = new ClientService(new URL(address.get(ROLE_CLIENT)));
            		Client client = clientService.getClientPort();
            		 
            		client.setEndpointAddress(sessionId);
                  
                  try {
                     Thread.sleep(500);
                  } catch (InterruptedException e) {
                     e.printStackTrace();
                  }
            	}
            	
            	MarketingApplicationService marketingApplicationService = new MarketingApplicationService(new URL(address.get(ROLE_MARKETINGAPPLICATION)));
                MarketingApplication marketingApplication = marketingApplicationService.getMarketingApplicationPort();
            	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SelfCheckOutMachine", ArtifactType.SERVICE, "SelfCheckOutMachine", "S19","S21", "notifyCheckout", null, EventType.SENDING_REQUEST, System.currentTimeMillis());
                marketingApplication.notifyCheckout(sessionId);
            	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "SelfCheckOutMachine", ArtifactType.SERVICE, "SelfCheckOutMachine", "S19","S21", "notifyCheckout", null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());
            } catch (Exception e) {
                logger.error("Error detected:", e);
            }
        }

    }

}
