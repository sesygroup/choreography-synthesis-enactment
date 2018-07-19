package org.choreos.services;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.choreos.services.client.marketingapplication.MarketingApplication;
import org.choreos.services.client.marketingapplication.MarketingApplicationService;
import org.choreos.services.monitor.MonitorLogger;
import org.choreos.services.monitor.MonitorLoggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.chorevolution.idm.common.types.ArtifactType;
import eu.chorevolution.idm.common.types.EventType;

@WebService(endpointInterface = "org.choreos.services.ShopEntrance")
public class ShopEntranceImpl implements ShopEntrance {

    private static Logger logger = LoggerFactory.getLogger(ShopEntranceImpl.class);
    private static MonitorLogger monitorLogger = new MonitorLoggerImpl();
    

    private static final String ROLE_MARKETINGAPPLICATION = "marketingapplication";

    protected Map<String, String> address = new HashMap<String, String>();
    
    public void scenarioSetup() {
    	monitorLogger.sendToMonitor();
    }

    public void setEndpointAddress(String address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // TODO
    public void setInvocationAddress(String role, String name, List<String> endpoints) {
        logger.info("PERFORM -- setInvocationAddress - parameters: role: " + (role.isEmpty() ? "isEmpty parameter" : role) + " - name: " + (name.isEmpty() ? "isEmpty parameter" : name) + " - endpoints[0]: " + (endpoints.get(0).isEmpty() ? "isEmpty parameter" : endpoints.get(0)));
        if (address.containsKey(role)) {
            address.remove(role);
        }
        address.put(role, endpoints.get(0));
    }

    public String checkInAndAssignCart(String sessionId, List<ShoppingListEntry> shoopingList) throws ScenarioException_Exception {
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "ShopEntrance", ArtifactType.SERVICE, "ShopEntrance", "S0", "S1", "check_in_and_assign_cart", null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());
    	logger.info("PERFORM -- ShopEntrance.checkInAndAssignCart(String sessionId, List<ShoppingListEntry> shoopingList)");
        List<org.choreos.services.client.marketingapplication.ShoppingListEntry> shoopingListEntrys = new ArrayList<>();
        for (ShoppingListEntry entry : shoopingList) {
            org.choreos.services.client.marketingapplication.ShoppingListEntry shoppingListEntryMarketingapplication = new org.choreos.services.client.marketingapplication.ShoppingListEntry();
            org.choreos.services.client.marketingapplication.Product product = new org.choreos.services.client.marketingapplication.Product();
            product.setBarcode(entry.getItem().getBarcode());
            product.setBrand(entry.getItem().getBrand());
            product.setName(entry.getItem().getName());
            shoppingListEntryMarketingapplication.setItem(product);
            shoppingListEntryMarketingapplication.setQty(entry.getQty());
            shoopingListEntrys.add(shoppingListEntryMarketingapplication);
        }

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

        // call marketingApplication.notifyCheckin(sessionId, shoopingListEntrys)
        ManageCallNotifyCheckinOfMarketingApplication ManageCallNotifyCheckinOfMarketingApplication = new ManageCallNotifyCheckinOfMarketingApplication(sessionId, shoopingListEntrys);
        Thread threadManageCallNotifyCheckinOfMarketingApplication = new Thread(ManageCallNotifyCheckinOfMarketingApplication);
        threadManageCallNotifyCheckinOfMarketingApplication.start();
        monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "ShopEntrance", ArtifactType.SERVICE, "ShopEntrance", "S0", "S1", "check_in_and_assign_cart", null, EventType.REPLY_RESPONSE, System.currentTimeMillis());
        return sessionId;
    }

    public void register(String cartId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class ManageCallNotifyCheckinOfMarketingApplication implements Runnable {

        private String sessionId;
        private List<org.choreos.services.client.marketingapplication.ShoppingListEntry> shoopingList;

        public ManageCallNotifyCheckinOfMarketingApplication() {
            sessionId = "";
            shoopingList = new ArrayList<>();
        }

        public ManageCallNotifyCheckinOfMarketingApplication(String sessionId, List<org.choreos.services.client.marketingapplication.ShoppingListEntry> shoopingList) {
            this.sessionId = sessionId;
            this.shoopingList = shoopingList;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public List<org.choreos.services.client.marketingapplication.ShoppingListEntry> getShoopingList() {
            return shoopingList;
        }

        @Override
        public void run() {
            try {
            	MarketingApplicationService marketingApplicationService = new MarketingApplicationService(new URL(address.get(ROLE_MARKETINGAPPLICATION)));
                MarketingApplication marketingApplication = marketingApplicationService.getMarketingApplicationPort();
                monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "ShopEntrance", ArtifactType.SERVICE, "ShopEntrance", "S12","S13", "notifyCheckin", null, EventType.SENDING_REQUEST, System.currentTimeMillis());
                marketingApplication.notifyCheckin(sessionId, shoopingList);
                monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "ShopEntrance", ArtifactType.SERVICE, "ShopEntrance", "S12","S13", "notifyCheckin", null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());
            } catch (Exception e) {
                logger.error("Error detected:", e);
            }
        }

    }
}
