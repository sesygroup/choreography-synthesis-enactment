package org.choreos.services;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.choreos.services.client.selfcheckoutmachine.SelfCheckOutMachine;
import org.choreos.services.client.selfcheckoutmachine.SelfCheckOutMachineService;
import org.choreos.services.client.shopentrance.Product;
import org.choreos.services.client.shopentrance.ShopEntrance;
import org.choreos.services.client.shopentrance.ShopEntranceService;
import org.choreos.services.client.shopentrance.ShoppingListEntry;
import org.choreos.services.client.smartcart.ScenarioException_Exception;
import org.choreos.services.client.smartcart.SmartCart;
import org.choreos.services.client.smartcart.SmartCartService;
import org.choreos.services.monitor.MonitorLogger;
import org.choreos.services.monitor.MonitorLoggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.chorevolution.idm.common.types.ArtifactType;
import eu.chorevolution.idm.common.types.EventType;

@WebService(endpointInterface = "org.choreos.services.Client")
public class ClientImpl implements Client {
	private static Logger logger = LoggerFactory.getLogger(ClientImpl.class);
	private static MonitorLogger monitorLogger = new MonitorLoggerImpl();

	private static final String ROLE_SELFCHECKOUTMACHINE = "selfcheckoutmachine";
	private static final String ROLE_SHOPENTRANCE = "shopentrance";
	private static final String ROLE_SMARTCART = "smartcart";

	protected Map<String, String> address = new HashMap<String, String>();

	public void scenarioSetup() {
		monitorLogger.sendToMonitor(); 
	}

	//Method modified in order to perform another add_product after payment
	public void setEndpointAddress(String address) {
		try {
			SmartCartService smartCartService = new SmartCartService(new URL(this.address.get(ROLE_SMARTCART)));
			SmartCart smartCart = smartCartService.getSmartCartPort();

			String cartID = Long.toString(System.nanoTime());
			org.choreos.services.client.smartcart.Product productSmartCart = new org.choreos.services.client.smartcart.Product();
			productSmartCart.setBarcode("barcode");
			productSmartCart.setBrand("brand");
			productSmartCart.setName("name");
			int quantity = 3;

			//SessionID is passed with the address parameter
			ManageProduct manageProduct = new ManageProduct(productSmartCart, address, cartID, quantity);
		   Thread threadManageProduct = new Thread(manageProduct);
		   threadManageProduct.start();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}

	public void setInvocationAddress(String role, String name, List<String> endpoints) {
		logger.info("PERFORM -- setInvocationAddress - parameters: role: " + (role.isEmpty() ? "isEmpty parameter" : role) + " - name: " + (name.isEmpty() ? "isEmpty parameter" : name) + " - endpoints[0]: " + (endpoints.get(0).isEmpty() ? "isEmpty parameter" : endpoints.get(0)));
		if (address.containsKey(role)) {
			address.remove(role);
		}
		address.put(role, endpoints.get(0));
	}

	public void start(String sessionID) {
		logger.info("PERFORM -- Client.start(sessionID)");

		String cartID = Long.toString(System.nanoTime());

		org.choreos.services.client.smartcart.Product productSmartCart = new org.choreos.services.client.smartcart.Product();
		productSmartCart.setBarcode("barcode");
		productSmartCart.setBrand("brand");
		productSmartCart.setName("name");
		int quantity = 3;
		ManageProduct manageProduct = new ManageProduct(productSmartCart, sessionID, cartID, quantity);
		Thread threadManageProduct = new Thread(manageProduct);

		Product productShopEntrance = new Product();
		productShopEntrance.setBarcode("barcode");
		productShopEntrance.setBrand("brand");
		productShopEntrance.setName("name");

		ShoppingListEntry shoppingListEntry = new ShoppingListEntry();
		shoppingListEntry.setItem(productShopEntrance);
		shoppingListEntry.setQty(3);

		List<ShoppingListEntry> shoppingListEntrys = new ArrayList<>();
		shoppingListEntrys.add(shoppingListEntry);

		monitorLogger.sendEventData("WP7", Long.parseLong(sessionID), "Client", ArtifactType.SERVICE, "Client", "S0", "S1", "check_in_and_assign_cart", null, EventType.SENDING_REQUEST, System.currentTimeMillis());
		callCheckInAndAssignCartOfShopEntrance(sessionID, shoppingListEntrys);
		monitorLogger.sendEventData("WP7", Long.parseLong(sessionID), "Client", ArtifactType.SERVICE, "Client", "S0", "S1", "check_in_and_assign_cart", null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());

		// END call

		// START call smartCart.subscribeUserToCart(sessionId, cartId)
		// String cartID = Long.toString(System.nanoTime());

		monitorLogger.sendEventData("WP7", Long.parseLong(sessionID), "Client", ArtifactType.SERVICE, "Client", "S10", "S11", "subscribeUserToCart", null, EventType.SENDING_REQUEST, System.currentTimeMillis());
		callSubscribeUserToCartOfSmartCart(sessionID, cartID);
		monitorLogger.sendEventData("WP7", Long.parseLong(sessionID), "Client", ArtifactType.SERVICE, "Client", "S10", "S11", "subscribeUserToCart", null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());

		// END call

		////////
		// TODO: implement JOIN1 represented in CLTS Model: it's possible ??
		////////
		
		threadManageProduct.start();

	}

	private String callCheckInAndAssignCartOfShopEntrance(String sessionId, List<ShoppingListEntry> shoppingList) {
		String shopEntranceResponse = null;
		try {
			ShopEntranceService shopEntranceService = new ShopEntranceService(new URL(address.get(ROLE_SHOPENTRANCE)));
			ShopEntrance shopEntrance = shopEntranceService.getShopEntrancePort();
			shopEntranceResponse = shopEntrance.checkInAndAssignCart(sessionId, shoppingList);
		} catch (Exception e) {
			logger.error("Error detected:", e);
		}

		return shopEntranceResponse;
	}

	private void callSubscribeUserToCartOfSmartCart(String sessionId, String cartId) {
		try {
			SmartCartService smartCartService = new SmartCartService(new URL(address.get(ROLE_SMARTCART)));
			SmartCart smartCart = smartCartService.getSmartCartPort();
			smartCart.subscribeUserToCart(sessionId, cartId);
		} catch (Exception e) {
			logger.error("Error detected:", e);
		}
	}

	// FORK2 represented in the CLTS MODEL
	private class ManageProduct implements Runnable {

		private org.choreos.services.client.smartcart.Product productSmartCart;
		private String sessionId;
		private String cartId;
		private int quantity;

		public ManageProduct() {
			productSmartCart = new org.choreos.services.client.smartcart.Product();
			sessionId = "";
			cartId = "";
			quantity = -1;
		}

		public ManageProduct(org.choreos.services.client.smartcart.Product productSmartCart, String sessionId, String cartId, int quantity) {
			this.productSmartCart = productSmartCart;
			this.sessionId = sessionId;
			this.cartId = cartId;
			this.quantity = quantity;
		}

		public org.choreos.services.client.smartcart.Product getProductSmartCart() {
			return productSmartCart;
		}

		public void setProductSmartCart(org.choreos.services.client.smartcart.Product productSmartCart) {
			this.productSmartCart = productSmartCart;
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

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		@Override
		public void run() {
			try {
				SmartCartService smartCartService = new SmartCartService(new URL(address.get(ROLE_SMARTCART)));

				SmartCart smartCart = smartCartService.getSmartCartPort();

				// ALT1 represented in the CLTS MODEL
				boolean conditionALT1 = true;
				while (conditionALT1) {
					boolean addProduct = true;
					boolean removeProduct = false;
					if (addProduct) {
						// call smartCart.addProduct(sessionId,
						// cartId,product,qty)
						try {
							//Thread.sleep(60000);
							monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "Client", ArtifactType.SERVICE, "Client", "S15", "S16", "add_product", null, EventType.SENDING_REQUEST, System.currentTimeMillis());
							smartCart.addProduct(sessionId, cartId, productSmartCart, quantity);
							monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "Client", ArtifactType.SERVICE, "Client", "S15", "S16", "add_product", null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());
						} catch (Exception e) {
							logger.error("Error detected:", e);
						}
					} else if (removeProduct) {
						// call smartCart.removeProduct(sessionId,
						// cartId,product)
						try {
							monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "Client", ArtifactType.SERVICE, "Client", "S6", "S7", "remove_product", null, EventType.SENDING_REQUEST, System.currentTimeMillis());
							smartCart.removeProduct(sessionId, cartId, productSmartCart);
							monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "Client", ArtifactType.SERVICE, "Client", "S6", "S7", "remove_product", null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());
						} catch (Exception e) {
							logger.error("Error detected:", e);
						}
					} else {
						// call smartCart.changeQty(sessionId,
						// cartId,product,qty)
						try {
							monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "Client", ArtifactType.SERVICE, "Client", "S4", "S5", "change_qty", null, EventType.SENDING_REQUEST, System.currentTimeMillis());
							smartCart.changeQty(sessionId, cartId, productSmartCart, quantity);
							monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "Client", ArtifactType.SERVICE, "Client", "S4", "S5", "change_qty", null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());
						} catch (Exception e) {
							logger.error("Error detected:", e);
						}
					}
					conditionALT1 = false;
				}
			} catch (Exception e) {
				logger.error("Error detected:", e);
			}

			try {
				// call selfCheckOutMachine.checkout(sessionID, cartID)
				SelfCheckOutMachineService selfCheckOutMachineService = new SelfCheckOutMachineService(new URL(address.get(ROLE_SELFCHECKOUTMACHINE)));
				SelfCheckOutMachine selfCheckOutMachine = selfCheckOutMachineService.getSelfCheckOutMachinePort();
				//Thread.sleep(25000);
				monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "Client", ArtifactType.SERVICE, "Client", "S22", "S23", "checkout", null, EventType.SENDING_REQUEST, System.currentTimeMillis());
				selfCheckOutMachine.checkout(sessionId, cartId);
				monitorLogger.sendEventData("WP7", Long.parseLong(sessionId), "Client", ArtifactType.SERVICE, "Client", "S22", "S23", "checkout", null, EventType.RECEIVING_RESPONSE, System.currentTimeMillis());
			} catch (Exception e) {
				logger.error("Error detected:", e);
			}

		}

	}

}
