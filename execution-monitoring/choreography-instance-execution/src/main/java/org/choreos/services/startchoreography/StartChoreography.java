package org.choreos.services.startchoreography;

import java.net.URL;

import org.choreos.services.monitor.MonitorLogger;
import org.choreos.services.monitor.MonitorLoggerImpl;
import org.choreos.services.startchoreography.client.Client;
import org.choreos.services.startchoreography.client.ClientService;
import org.choreos.services.startchoreography.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexander Perucci
 */
public class StartChoreography implements Runnable {
	private static Logger logger = LoggerFactory.getLogger(StartChoreography.class);

	private String sessionID;

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			
		}
		
		new Thread(new Runnable() {
			public void run() {
				try {
					
					// String sessionID = Long.toString(System.nanoTime());
					logger.info("START WP7 Choreography - sessionID = " + sessionID);
					// http://192.168.195.166:8080/client/client
					ClientService clientService = new ClientService(new URL("http://" + Configuration.get("client_host")
							+ ":" + Configuration.get("client_port") + "/client/client"));
					Client client = clientService.getClientPort();
					client.start(sessionID);
					logger.info("END WP7 Choreography");

				} catch (Exception e) {
					logger.error("Error detected:", e);
				}
			}
		}).start();
	}

	public static void main(String[] args) throws Exception {
		String[] sessionIds = Configuration.get("SESSION_IDs").split(",");
		for (String sessionId : sessionIds) {

			MonitorLogger monitorLogger = new MonitorLoggerImpl();
			monitorLogger.sendInstanceData("WP7", Long.parseLong(sessionId), "WP7 Choreography Instance");

			StartChoreography startChoreography = new StartChoreography();
			startChoreography.setSessionID(sessionId);
			startChoreography.run();
		}

	}

	/*
	 * ----- possible interaction ----- RUN -- Client.start() RUN --
	 * ShopEntrance.checkInAndAssignCart(String sessionId,
	 * List<ShoppingListEntry> shoopingList) RUN --
	 * SmartCart.subscribeUserToCart(String sessionId, String cartId) RUN --
	 * SmartCart.changeQty(String sessionId, String cartId, Product product,
	 * Integer qty) RUN -- MarketingApplication.notifyCheckin(String sessionId,
	 * List<ShoppingListEntry> shoppingList) RUN --
	 * SelfCheckOutMachine.checkout(String sessionId, String cartId) RUN --
	 * SmartCart.payRequired(String sessionId, String cartId, String comId) RUN
	 * -- SelfCheckOutMachine.pay(String sessionId, String comId,
	 * List<ShoppingListEntry> shoppingBag) RUN --
	 * MarketingApplication.notifyCheckout(String sessionId)
	 */
	/*
	 * ----- possible interaction ----- RUN -- Client.start() RUN --
	 * ShopEntrance.checkInAndAssignCart(String sessionId,
	 * List<ShoppingListEntry> shoopingList) RUN --
	 * SmartCart.subscribeUserToCart(String sessionId, String cartId) RUN --
	 * SmartCart.changeQty(String sessionId, String cartId, Product product,
	 * Integer qty) RUN -- MarketingApplication.notifyCheckin(String sessionId,
	 * List<ShoppingListEntry> shoppingList) RUN --
	 * SelfCheckOutMachine.checkout(String sessionId, String cartId) RUN --
	 * MarketingManager.requestPrivateOffer(String sessionId, Product product)
	 * RUN -- MarketingManager.requestPublicOffer(String sessionId) RUN --
	 * SmartCart.payRequired(String sessionId, String cartId, String comId) RUN
	 * -- SelfCheckOutMachine.pay(String sessionId, String comId,
	 * List<ShoppingListEntry> shoppingBag) RUN --
	 * MarketingApplication.privateOfferConfirmation(String sessionId, Offer
	 * offer, boolean confirmed) RUN --
	 * MarketingApplication.publicOfferConfirmation(String sessionId,Offer
	 * offer, boolean confirmed) RUN -- InStoreTotemImpl.publish(String
	 * sessionId, Offer offer) RUN -- MarketingApplication.notifyCheckout(String
	 * sessionId) RUN -- ShoppingassistantappImpl.privateOffer(String sessionId,
	 * Offer offer)
	 */
}
