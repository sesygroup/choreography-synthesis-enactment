package org.choreos.services;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.choreos.services.client.marketingapplication.MarketingApplication;
import org.choreos.services.client.marketingapplication.MarketingApplicationService;
import org.choreos.services.client.marketingapplication.Offer;
import org.choreos.services.monitor.MonitorLogger;
import org.choreos.services.monitor.MonitorLoggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.chorevolution.idm.common.types.ArtifactType;
import eu.chorevolution.idm.common.types.EventType;

@WebService(endpointInterface = "org.choreos.services.MarketingManager")
public class MarketingManagerImpl implements MarketingManager {

    private static Logger logger = LoggerFactory.getLogger(MarketingManagerImpl.class);
    private static MonitorLogger monitorLogger = new MonitorLoggerImpl();
    
	private static final String ROLE_MARKETINGAPPLICATION = "marketingapplication";

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

    public void putEstimationReq(String sessionId, EstimationNeedAlert estimationNeedAlert) throws ScenarioException_Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void requestPrivateOffer(String sessionId, Product product) throws ScenarioException_Exception {
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingManager", ArtifactType.SERVICE, "MarketingManager", "S34","S35", "requestPrivateOffer", null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());

        logger.info("PERFORM -- MarketingManager.requestPrivateOffer(String sessionId, Product product)");

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

        org.choreos.services.client.marketingapplication.Product marketingapplicationProduct = new org.choreos.services.client.marketingapplication.Product();
        marketingapplicationProduct.setName(product.getName());
        marketingapplicationProduct.setBarcode(product.getBarcode());
        marketingapplicationProduct.setBrand(product.getBrand());
        Offer offer = new Offer();
        offer.setItem(marketingapplicationProduct);
        offer.setDiscount(0);
        boolean confirmed = true;

        ManageCallPrivateOfferConfirmationOfMarketingApplication manageCallPrivateOfferConfirmationOfMarketingApplication = new ManageCallPrivateOfferConfirmationOfMarketingApplication(sessionId, offer, confirmed);
        Thread threadManageCallPrivateOfferConfirmationOfMarketingApplication = new Thread(manageCallPrivateOfferConfirmationOfMarketingApplication);
        threadManageCallPrivateOfferConfirmationOfMarketingApplication.start();
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingManager", ArtifactType.SERVICE, "MarketingManager", "S34","S35", "requestPrivateOffer", null, EventType.REPLY_RESPONSE, System.currentTimeMillis());
    }

    public void requestPublicOffer(String sessionId) throws ScenarioException_Exception {
    	monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingManager", ArtifactType.SERVICE, "MarketingManager", "S41","S42", "requestPublicOffer", null, EventType.RECEIVING_REQUEST, System.currentTimeMillis());
        logger.info("PERFORM -- MarketingManager.requestPublicOffer(String sessionId)");

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

        Offer offer = new Offer();
        offer.setDiscount(0);
        offer.setItem(new org.choreos.services.client.marketingapplication.Product());
        boolean confirmed = true;

        ManageCallPublicOfferConfirmationOfMarketingApplication manageCallPublicOfferConfirmationOfMarketingApplication = new ManageCallPublicOfferConfirmationOfMarketingApplication(sessionId, offer, confirmed);
        Thread threadManageCallPublicOfferConfirmationOfMarketingApplication = new Thread(manageCallPublicOfferConfirmationOfMarketingApplication);
        threadManageCallPublicOfferConfirmationOfMarketingApplication.start();
        monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingManager", ArtifactType.SERVICE, "MarketingManager", "S41","S42", "requestPublicOffer", null, EventType.REPLY_RESPONSE, System.currentTimeMillis());
    }

    private class ManageCallPublicOfferConfirmationOfMarketingApplication implements Runnable {

        private String sessionId;
        private Offer offer;
        private boolean confirmed;

        public ManageCallPublicOfferConfirmationOfMarketingApplication() {

        }

        public ManageCallPublicOfferConfirmationOfMarketingApplication(String sessionId, Offer offer, boolean confirmed) {
            this.sessionId = sessionId;
            this.offer = offer;
            this.confirmed = confirmed;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public Offer getOffer() {
            return offer;
        }

        public void setOffer(Offer offer) {
            this.offer = offer;
        }

        public boolean isConfirmed() {
            return confirmed;
        }

        public void setConfirmed(boolean confirmed) {
            this.confirmed = confirmed;
        }

        @Override
        public void run() {
            // call marketingApplication.publicOfferConfirmation(sessionId, offer, confirmed)
            try {
                MarketingApplicationService marketingApplicationService = new MarketingApplicationService(new URL(address.get(ROLE_MARKETINGAPPLICATION)));
                MarketingApplication marketingApplication = marketingApplicationService.getMarketingApplicationPort();
                monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingManager", ArtifactType.SERVICE, "MarketingManager", "S42","S39", "publicOfferConfirmation", null, EventType.SENDING_REQUEST, System.currentTimeMillis());
                marketingApplication.publicOfferConfirmation(sessionId, offer, confirmed);
                monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingManager", ArtifactType.SERVICE, "MarketingManager", "S42","S39", "publicOfferConfirmation", null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());
            } catch (Exception e) {
                logger.error("Error detected:", e);
            }
        }

    }

    private class ManageCallPrivateOfferConfirmationOfMarketingApplication implements Runnable {

        private String sessionId;
        private Offer offer;
        private boolean confirmed;

        public ManageCallPrivateOfferConfirmationOfMarketingApplication() {

        }

        public ManageCallPrivateOfferConfirmationOfMarketingApplication(String sessionId, Offer offer, boolean confirmed) {
            this.sessionId = sessionId;
            this.offer = offer;
            this.confirmed = confirmed;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public Offer getOffer() {
            return offer;
        }

        public void setOffer(Offer offer) {
            this.offer = offer;
        }

        public boolean isConfirmed() {
            return confirmed;
        }

        public void setConfirmed(boolean confirmed) {
            this.confirmed = confirmed;
        }

        @Override
        public void run() {
            // call marketingApplication.privateOfferConfirmation(sessionId, offer, confirmed)
            try {
                MarketingApplicationService marketingApplicationService = new MarketingApplicationService(new URL(address.get(ROLE_MARKETINGAPPLICATION)));
                MarketingApplication marketingApplication = marketingApplicationService.getMarketingApplicationPort();
              //monitorLogger.log("S35","S27",SendingRequest)
                monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingManager", ArtifactType.SERVICE, "MarketingManager", "S35","S27", "privateOfferConfirmation", null, EventType.SENDING_REQUEST, System.currentTimeMillis());
                marketingApplication.privateOfferConfirmation(sessionId, offer, confirmed);
                monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "MarketingManager", ArtifactType.SERVICE, "MarketingManager", "S35","S27", "privateOfferConfirmation", null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());                
            } catch (Exception e) {
                logger.error("Error detected:", e);
            }
        }

    }

}
