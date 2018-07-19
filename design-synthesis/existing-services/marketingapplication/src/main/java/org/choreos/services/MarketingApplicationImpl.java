package org.choreos.services;

import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.choreos.services.client.basiccommunicationdevice.BasicCommunicationDevice;
import org.choreos.services.client.basiccommunicationdevice.BasicCommunicationDeviceService;
import org.choreos.services.client.instoretotem.InStoreTotem;
import org.choreos.services.client.instoretotem.InStoreTotemService;
import org.choreos.services.client.marketingmanager.MarketingManager;
import org.choreos.services.client.marketingmanager.MarketingManagerService;
import org.choreos.services.client.shoppingassistantapp.Shoppingassistantapp;
import org.choreos.services.client.shoppingassistantapp.ShoppingassistantappService;
import org.choreos.services.monitor.MonitorLogger;
import org.choreos.services.monitor.MonitorLoggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import eu.chorevolution.idm.common.types.ArtifactType;
import eu.chorevolution.idm.common.types.EventType;

@WebService(endpointInterface = "org.choreos.services.MarketingApplication")
public class MarketingApplicationImpl implements MarketingApplication {

    private static Logger logger = LoggerFactory.getLogger(MarketingApplicationImpl.class);
    private static MonitorLogger monitorLogger = new MonitorLoggerImpl();

    private static final String ROLE_BASICCOMMUNICATIONDEVICE = "basiccommunicationdevice";
	private static final String ROLE_INSTORETOTEM = "instoretotem";
	private static final String ROLE_MARKETINGMANAGER = "marketingmanager";
	private static final String ROLE_SHOPPINGASSISTANTS = "shoppingassistants";
	
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

    public void basicCommDeviceSubscribe(String sessionId) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void shopAssistAppSubscribe(String sessionId) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void shopAssistAppUnsubscribe(String sessionId) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void basicCommDeviceUnsubscribe(String sessionId) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void unsubscribetoSupplyAuthorization(String callbackAddress) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void publicOfferConfirmation(String sessionId, Offer offer, boolean confirmed) throws ScenarioException_Exception {
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S42","S39", "publicOfferConfirmation", null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());
        logger.info("PERFORM -- MarketingApplication.publicOfferConfirmation(String sessionId,Offer offer, boolean confirmed)");

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

        org.choreos.services.client.instoretotem.Offer inStoreTotemOffer = new org.choreos.services.client.instoretotem.Offer();
        org.choreos.services.client.instoretotem.Product inStoreTotemProduct = new org.choreos.services.client.instoretotem.Product();
        inStoreTotemProduct.setName(offer.getItem().getName());
        inStoreTotemProduct.setBarcode(offer.getItem().getBarcode());
        inStoreTotemProduct.setBrand(offer.getItem().getBrand());
        inStoreTotemOffer.setItem(inStoreTotemProduct);
        inStoreTotemOffer.setDiscount(offer.getDiscount());

        ManageCallPublicationOfInStoreTotem manageCallPublicationOfInStoreTotem = new ManageCallPublicationOfInStoreTotem(sessionId, inStoreTotemOffer);
        Thread threadManageCallPublicationOfInStoreTotem = new Thread(manageCallPublicationOfInStoreTotem);
        threadManageCallPublicationOfInStoreTotem.start();
        monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S42","S39", "publicOfferConfirmation", null, EventType.REPLY_RESPONSE, System.currentTimeMillis());
    }

    public void proposeAlternative(String sessionId, Product alternativeproduct, Integer availability, String callbackAddress) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void authorize(SupplyAgreement sa, boolean authorized, String callbackAddress) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void communicateAnswers(String sessionId, Questionnaire questionnaire) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setEstimate(Estimate est) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addProductNotify(String sessionId, Product product, Integer qty) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void notifyCheckin(String sessionId, List<ShoppingListEntry> shoppingList) throws ScenarioException_Exception {
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S12","S13", "notifyCheckin", null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());
        logger.info("PERFORM -- MarketingApplication.notifyCheckin(String sessionId, List<ShoppingListEntry> shoppingList)");

        //SLEEP FOR SIMULATING REAL INTERACTION
        try {
        	int running = Integer.parseInt(Configuration.get("running_number"));

            switch (running) {
            case 0:
               Thread.sleep(200);
               break;
            case 1:
               Thread.sleep(400);
               break;
            case 2:
               Thread.sleep(800);
               break;
            case 3:
               Thread.sleep(1200);
               break;
            case 4:
               Thread.sleep(1600);
               break;
            case 5:
               Thread.sleep(2000);
               break;
            case 6:
               Thread.sleep(2400);
               break;
            case 7:
               Thread.sleep(2800);
               break;
            case 8:
               Thread.sleep(3200);
               break;
            case 9:
               Thread.sleep(3600);
               break;
            case 10:
               Thread.sleep(4000);
               break;
            }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        // TODO
        // START FORK2 represented in the CLTS MODEL
        ManagePublicOffer managePublicOffer = new ManagePublicOffer(sessionId, shoppingList);
        Thread threadManagePublicOffer = new Thread(managePublicOffer);
        threadManagePublicOffer.start();

        ManagePrivateOffer managePrivateOffer = new ManagePrivateOffer(sessionId, shoppingList);
        Thread threadmanagePrivateOffer = new Thread(managePrivateOffer);
        threadmanagePrivateOffer.start();
        // END FORK2 represented in the CLTS MODEL
        monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S12","S13", "notifyCheckin", null, EventType.REPLY_RESPONSE, System.currentTimeMillis());
    }

    public void unsubscribeToSalesEstimation(String callbackAddress) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void maReceiveSms(String sessionId, SMSMessage msg) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void subscribeToSalesEstimation(String callbackAddress) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void subscribeToSupplyAuthorization(String callbackAddress) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void notifyCheckout(String sessionId) throws ScenarioException_Exception {
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S19","S21", "notifyCheckout", null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());
        // TODO
        //SLEEP FOR SIMULATING REAL INTERACTION
        try {
        	int running = Integer.parseInt(Configuration.get("running_number"));

            switch (running) {
            case 0:
               Thread.sleep(5);
               break;
            case 1:
               Thread.sleep(10);
               break;
            case 2:
               Thread.sleep(20);
               break;
            case 3:
               Thread.sleep(30);
               break;
            case 4:
               Thread.sleep(40);
               break;
            case 5:
               Thread.sleep(50);
               break;
            case 6:
               Thread.sleep(60);
               break;
            case 7:
               Thread.sleep(70);
               break;
            case 8:
               Thread.sleep(80);
               break;
            case 9:
               Thread.sleep(90);
               break;
            case 10:
               Thread.sleep(100);
               break;
            }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        logger.info("PERFORM -- MarketingApplication.notifyCheckout(String sessionId)");
        monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S19","S21", "notifyCheckout", null, EventType.REPLY_RESPONSE, System.currentTimeMillis());
    }

    public void shoppingListCommunication(User user, ShoppingList shoppinglist, String callbackAddress) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void unsubscribeToSupplyNegotiation(String sesssionId) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void subscribeToSupplyNegotation(String sesssionId) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void storeBoughtItems(String sessionId, List<Product> items) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void changeQtyNotify(String sessionId, Product product, Integer qty) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void makeProposal(String sesssionId, SupplyAgreement proposal) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void privateOfferConfirmation(String sessionId, Offer offer, boolean confirmed) throws ScenarioException_Exception {
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S35","S27", "privateOfferConfirmation", null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());
    	logger.info("PERFORM -- MarketingApplication.privateOfferConfirmation(String sessionId, Offer offer, boolean confirmed)");
        //SLEEP FOR SIMULATING REAL INTERACTION
        try {
        	int running = Integer.parseInt(Configuration.get("running_number"));

            switch (running) {
            case 0:
               Thread.sleep(300);
               break;
            case 1:
               Thread.sleep(600);
               break;
            case 2:
               Thread.sleep(1200);
               break;
            case 3:
               Thread.sleep(1800);
               break;
            case 4:
               Thread.sleep(2400);
               break;
            case 5:
               Thread.sleep(3000);
               break;
            case 6:
               Thread.sleep(3600);
               break;
            case 7:
               Thread.sleep(4200);
               break;
            case 8:
               Thread.sleep(4800);
               break;
            case 9:
               Thread.sleep(5400);
               break;
            case 10:
               Thread.sleep(6000);
               break;
            }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        boolean conditionALT5 = true;
        if (conditionALT5) {
            org.choreos.services.client.shoppingassistantapp.Offer shoppingassistantappOffer = new org.choreos.services.client.shoppingassistantapp.Offer();
            org.choreos.services.client.shoppingassistantapp.Product shoppingassistantappProduct = new org.choreos.services.client.shoppingassistantapp.Product();
            shoppingassistantappProduct.setName(offer.getItem().getName());
            shoppingassistantappProduct.setBarcode(offer.getItem().getBarcode());
            shoppingassistantappProduct.setBrand(offer.getItem().getBrand());
            shoppingassistantappOffer.setItem(shoppingassistantappProduct);
            shoppingassistantappOffer.setDiscount(offer.getDiscount());

            ManageCallPrivateOfferOfShoppingassistantapp manageCallPrivateOfferOfShoppingassistantapp = new ManageCallPrivateOfferOfShoppingassistantapp(sessionId, shoppingassistantappOffer);
            Thread threadManageCallPrivateOfferOfShoppingassistantapp = new Thread(manageCallPrivateOfferOfShoppingassistantapp);
            threadManageCallPrivateOfferOfShoppingassistantapp.start();

        } else {
            org.choreos.services.client.basiccommunicationdevice.SMSMessage message = new org.choreos.services.client.basiccommunicationdevice.SMSMessage();
            message.setDate(XMLGregorianCalendarImpl.createDate(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_WEEK_IN_MONTH, Calendar.ZONE_OFFSET));
            message.setFrom("");
            message.setText("");
            ManageCallBcdReceiveSmsOfBasicCommunicationDevice manageCallBcdReceiveSmsOfBasicCommunicationDevice = new ManageCallBcdReceiveSmsOfBasicCommunicationDevice(sessionId, message);
            Thread threadManageCallBcdReceiveSmsOfBasicCommunicationDevice = new Thread(manageCallBcdReceiveSmsOfBasicCommunicationDevice);
            threadManageCallBcdReceiveSmsOfBasicCommunicationDevice.start();
        }
        monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S35","S27", "privateOfferConfirmation", null, EventType.REPLY_RESPONSE, System.currentTimeMillis());
    }

    public void removeProductNotify(String sessionId, Product product) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void put(StockLevelNotification stockLevelNotification) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class ManagePublicOffer implements Runnable {

        private String sessionId;
        private List<ShoppingListEntry> shoppingList;

        public ManagePublicOffer() {
        }

        public ManagePublicOffer(String sessionId, List<ShoppingListEntry> shoppingList) {
            this.sessionId = sessionId;
            this.shoppingList = shoppingList;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public List<ShoppingListEntry> getShoppingList() {
            return shoppingList;
        }

        public void setShoppingList(List<ShoppingListEntry> shoppingList) {
            this.shoppingList = shoppingList;
        }

        @Override
        public void run() {
            try {
                MarketingManagerService marketingManagerService = new MarketingManagerService(new URL(address.get(ROLE_MARKETINGMANAGER)));
                MarketingManager marketingManager = marketingManagerService.getMarketingManagerPort();
                // ALT3 represented in the CLTS MODEL
                for (ShoppingListEntry shoppingListEntry : shoppingList) {
                    //call marketingManager.requestPublicOffer(sessionId)
                    try {
                    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S41","S42", "requestPublicOffer", null, EventType.SENDING_REQUEST, System.currentTimeMillis());
                        marketingManager.requestPublicOffer(sessionId);
                        monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S41","S42", "requestPublicOffer", null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());
                    } catch (org.choreos.services.client.marketingmanager.ScenarioException_Exception ex) {
                    }
                }
            } catch (Exception e) {
                logger.error("Error detected:", e);
            }
        }

    }

    private class ManagePrivateOffer implements Runnable {

        private String sessionId;
        private List<ShoppingListEntry> shoppingList;

        public ManagePrivateOffer() {
        }

        public ManagePrivateOffer(String sessionId, List<ShoppingListEntry> shoppingList) {
            this.sessionId = sessionId;
            this.shoppingList = shoppingList;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public List<ShoppingListEntry> getShoppingList() {
            return shoppingList;
        }

        public void setShoppingList(List<ShoppingListEntry> shoppingList) {
            this.shoppingList = shoppingList;
        }

        @Override
        public void run() {
            try {
                MarketingManagerService marketingManagerService = new MarketingManagerService(new URL(address.get(ROLE_MARKETINGMANAGER)));
                MarketingManager marketingManager = marketingManagerService.getMarketingManagerPort();
                // ALT4 represented in the CLTS MODEL
                for (ShoppingListEntry shoppingListEntry : shoppingList) {
                    org.choreos.services.client.marketingmanager.Product product = new org.choreos.services.client.marketingmanager.Product();
                    product.setBarcode(shoppingListEntry.getItem().getBarcode());
                    product.setBrand(shoppingListEntry.getItem().getBrand());
                    product.setName(shoppingListEntry.getItem().getName());
                    //call marketingManager.requestPrivateOffer(sessionId, product)
                    try {
                    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S34","S35", "requestPrivateOffer", null, EventType.SENDING_REQUEST, System.currentTimeMillis());
                        marketingManager.requestPrivateOffer(sessionId, product);
                        monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S34","S35", "requestPrivateOffer", null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());
                    } catch (org.choreos.services.client.marketingmanager.ScenarioException_Exception ex) {

                    }

                }
            } catch (Exception e) {
                logger.error("Error detected:", e);
            }

        }

    }

    private class ManageCallPublicationOfInStoreTotem implements Runnable {

        private String sessionId;
        private org.choreos.services.client.instoretotem.Offer offer;

        public ManageCallPublicationOfInStoreTotem() {
        }

        public ManageCallPublicationOfInStoreTotem(String sessionId, org.choreos.services.client.instoretotem.Offer offer) {
            this.sessionId = sessionId;
            this.offer = offer;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public org.choreos.services.client.instoretotem.Offer getOffer() {
            return offer;
        }

        public void setOffer(org.choreos.services.client.instoretotem.Offer offer) {
            this.offer = offer;
        }

        @Override
        public void run() {
            // call inStoreTotem.publish(sessionId, offer)
            try {
                InStoreTotemService inStoreTotemService = new InStoreTotemService(new URL(address.get(ROLE_INSTORETOTEM)));
                InStoreTotem inStoreTotem = inStoreTotemService.getInStoreTotemPort();
                monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S39","S29", "publish", null, EventType.SENDING_REQUEST, System.currentTimeMillis());
                inStoreTotem.publish(sessionId, offer);
                monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S39","S29", "publish", null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());
            } catch (Exception e) {
                logger.error("Error detected:", e);
            }
        }

    }

    private class ManageCallPrivateOfferOfShoppingassistantapp implements Runnable {

        private String sessionId;
        private org.choreos.services.client.shoppingassistantapp.Offer offer;

        public ManageCallPrivateOfferOfShoppingassistantapp() {
        }

        public ManageCallPrivateOfferOfShoppingassistantapp(String sessionId, org.choreos.services.client.shoppingassistantapp.Offer offer) {
            this.sessionId = sessionId;
            this.offer = offer;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public org.choreos.services.client.shoppingassistantapp.Offer getOffer() {
            return offer;
        }

        public void setOffer(org.choreos.services.client.shoppingassistantapp.Offer offer) {
            this.offer = offer;
        }

        @Override
        public void run() {
            //call shoppingassistantapp.privateOffer(sessionId, offer)
            try {
                ShoppingassistantappService shoppingassistantappService = new ShoppingassistantappService(new URL(address.get(ROLE_SHOPPINGASSISTANTS)));
                Shoppingassistantapp shoppingassistantapp = shoppingassistantappService.getShoppingassistantappPort();
                monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S31","S32", "private_offer", null, EventType.SENDING_REQUEST, System.currentTimeMillis());
                shoppingassistantapp.privateOffer(sessionId, offer);
                monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S31","S32", "private_offer", null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());
            } catch (Exception e) {
                logger.error("Error detected:", e);
            }
        }

    }

    private class ManageCallBcdReceiveSmsOfBasicCommunicationDevice implements Runnable {

        private String sessionId;
        private org.choreos.services.client.basiccommunicationdevice.SMSMessage message;

        public ManageCallBcdReceiveSmsOfBasicCommunicationDevice() {
        }

        public ManageCallBcdReceiveSmsOfBasicCommunicationDevice(String sessionId, org.choreos.services.client.basiccommunicationdevice.SMSMessage message) {
            this.sessionId = sessionId;
            this.message = message;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public org.choreos.services.client.basiccommunicationdevice.SMSMessage getMessage() {
            return message;
        }

        public void setMessage(org.choreos.services.client.basiccommunicationdevice.SMSMessage message) {
            this.message = message;
        }

        @Override
        public void run() {
            // call basicCommunicationDevice.bcdReceiveSms(sessionId, message)
            try {
                BasicCommunicationDeviceService basicCommunicationDeviceService = new BasicCommunicationDeviceService(new URL(address.get(ROLE_BASICCOMMUNICATIONDEVICE)));
                BasicCommunicationDevice basicCommunicationDevice = basicCommunicationDeviceService.getBasicCommunicationDevicePort();
                monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S36","S37", "bcd_receive_sms", null, EventType.SENDING_REQUEST, System.currentTimeMillis());
                basicCommunicationDevice.bcdReceiveSms(sessionId, message);
                monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingApplication", ArtifactType.SERVICE, "MarketingApplication", "S36","S37", "bcd_receive_sms", null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());
            } catch (Exception e) {
                logger.error("Error detected:", e);
            }
        }
    }
}
