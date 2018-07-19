package org.choreos.services.enactchoreography.configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.choreos.services.enactchoreography.client.basiccommunicationdevice.BasicCommunicationDevice;
import org.choreos.services.enactchoreography.client.basiccommunicationdevice.BasicCommunicationDeviceService;
import org.choreos.services.enactchoreography.client.client.Client;
import org.choreos.services.enactchoreography.client.client.ClientService;
import org.choreos.services.enactchoreography.client.instoretotem.InStoreTotem;
import org.choreos.services.enactchoreography.client.instoretotem.InStoreTotemService;
import org.choreos.services.enactchoreography.client.marketingapplication.MarketingApplication;
import org.choreos.services.enactchoreography.client.marketingapplication.MarketingApplicationService;
import org.choreos.services.enactchoreography.client.marketingmanager.MarketingManager;
import org.choreos.services.enactchoreography.client.marketingmanager.MarketingManagerService;
import org.choreos.services.enactchoreography.client.selfcheckoutmachine.SelfCheckOutMachine;
import org.choreos.services.enactchoreography.client.selfcheckoutmachine.SelfCheckOutMachineService;
import org.choreos.services.enactchoreography.client.shopentrance.ShopEntrance;
import org.choreos.services.enactchoreography.client.shopentrance.ShopEntranceService;
import org.choreos.services.enactchoreography.client.shoppingassistantapp.Shoppingassistantapp;
import org.choreos.services.enactchoreography.client.shoppingassistantapp.ShoppingassistantappService;
import org.choreos.services.enactchoreography.client.smartcart.SmartCart;
import org.choreos.services.enactchoreography.client.smartcart.SmartCartService;

/**
 *
 * @author Alexander Perucci
 */
public class Environment {
	private boolean useCDsComponent;

	private static final String CD_CLIENT_SELFCHECKOUTMACHINE = "CD-Client-Selfcheckoutmachine";
	private static final String CD_CLIENT_SHOPENTRANCE = "CD-Client-Shopentrance";
	private static final String CD_CLIENT_SMARTCART = "CD-Client-Smartcart";
	private static final String CD_MARKETINGAPPLICATION_BASICCOMMUNICATIONDEVICE = "CD-Marketingapplication-Basiccommunicationdevice";
	private static final String CD_MARKETINGAPPLICATION_INSTORETOTEM = "CD-Marketingapplication-Instoretotem";
	private static final String CD_MARKETINGAPPLICATION_MARKETINGMANAGER = "CD-Marketingapplication-Marketingmanager";
	private static final String CD_MARKETINGAPPLICATION_SHOPPINGASSISTANTS = "CD-Marketingapplication-Shoppingassistants";
	private static final String CD_MARKETINGMANAGER_MARKETINGAPPLICATION = "CD-Marketingmanager-Marketingapplication";
	private static final String CD_SELFCHECKOUTMACHINE_MARKETINGAPPLICATION = "CD-Selfcheckoutmachine-Marketingapplication";
	private static final String CD_SELFCHECKOUTMACHINE_SMARTCART = "CD-Selfcheckoutmachine-Smartcart";
	private static final String CD_SHOPENTRANCE_MARKETINGAPPLICATION = "CD-Shopentrance-Marketingapplication";
	private static final String CD_SMARTCART_SELFCHECKOUTMACHINE = "CD-Smartcart-Selfcheckoutmachine";

	private static final String CLIENT = "client";
	private static final String BASICCOMMUNICATIONDEVICE = "basiccommunicationdevice";
	private static final String INSTORETOTEM = "instoretotem";
	private static final String MARKETINGMANAGER = "marketingmanager";
	private static final String SHOPPINGASSISTANTS = "shoppingassistants";
	private static final String MARKETINGAPPLICATION = "marketingapplication";
	private static final String SMARTCART = "smartcart";
	private static final String SELFCHECKOUTMACHINE = "selfcheckoutmachine";
	private static final String SHOPENTRANCE = "shopentrance";

	// CD URL
	private Map<String, String> urlCDs = new HashMap<String, String>() {
		{
			put(CD_CLIENT_SELFCHECKOUTMACHINE, "http://" + Configuration.get("cd_client_selfcheckoutmachine_host") + ":" + Configuration.get("cd_client_selfcheckoutmachine_port") + "/CD-client-selfcheckoutmachine/CD-client-selfcheckoutmachine");
			put(CD_CLIENT_SHOPENTRANCE, "http://" + Configuration.get("cd_client_shopentrance_host") + ":" + Configuration.get("cd_client_shopentrance_port") + "/CD-client-shopentrance/CD-client-shopentrance");
			put(CD_CLIENT_SMARTCART, "http://" + Configuration.get("cd_client_smartcart_host") + ":" + Configuration.get("cd_client_smartcart_port") + "/CD-client-smartcart/CD-client-smartcart");
			put(CD_MARKETINGAPPLICATION_BASICCOMMUNICATIONDEVICE, "http://" + Configuration.get("cd_marketingapplication_basiccommunicationdevice_host") + ":" + Configuration.get("cd_marketingapplication_basiccommunicationdevice_port") + "/CD-marketingapplication-basiccommunicationdevice/CD-marketingapplication-basiccommunicationdevice");
			put(CD_MARKETINGAPPLICATION_INSTORETOTEM, "http://" + Configuration.get("cd_marketingapplication_instoretotem_host") + ":" + Configuration.get("cd_marketingapplication_instoretotem_port") + "/CD-marketingapplication-instoretotem/CD-marketingapplication-instoretotem");
			put(CD_MARKETINGAPPLICATION_MARKETINGMANAGER, "http://" + Configuration.get("cd_marketingapplication_marketingmanager_host") + ":" + Configuration.get("cd_marketingapplication_marketingmanager_port") + "/CD-marketingapplication-marketingmanager/CD-marketingapplication-marketingmanager");
			put(CD_MARKETINGAPPLICATION_SHOPPINGASSISTANTS, "http://" + Configuration.get("cd_marketingapplication_shoppingassistants_host") + ":" + Configuration.get("cd_marketingapplication_shoppingassistants_port") + "/CD-marketingapplication-shoppingassistantapp/CD-marketingapplication-shoppingassistantapp");
			put(CD_MARKETINGMANAGER_MARKETINGAPPLICATION, "http://" + Configuration.get("cd_marketingmanager_marketingapplication_host") + ":" + Configuration.get("cd_marketingmanager_marketingapplication_port") + "/CD-marketingmanager-marketingapplication/CD-marketingmanager-marketingapplication");
			put(CD_SELFCHECKOUTMACHINE_MARKETINGAPPLICATION, "http://" + Configuration.get("cd_selfcheckoutmachine_marketingapplication_host") + ":" + Configuration.get("cd_selfcheckoutmachine_marketingapplication_port") + "/CD-selfcheckoutmachine-marketingapplication/CD-selfcheckoutmachine-marketingapplication");
			put(CD_SELFCHECKOUTMACHINE_SMARTCART, "http://" + Configuration.get("cd_selfcheckoutmachine_smartcart_host") + ":" + Configuration.get("cd_selfcheckoutmachine_smartcart_port") + "/CD-selfcheckoutmachine-smartcart/CD-selfcheckoutmachine-smartcart");
			put(CD_SHOPENTRANCE_MARKETINGAPPLICATION, "http://" + Configuration.get("cd_shopentrance_marketingapplicaiton_host") + ":" + Configuration.get("cd_shopentrance_marketingapplicaiton_port") + "/CD-shopentrance-marketingapplication/CD-shopentrance-marketingapplication");
			put(CD_SMARTCART_SELFCHECKOUTMACHINE, "http://" + Configuration.get("cd_smartcart_selfcheckoutmachine_host") + ":" + Configuration.get("cd_smartcart_selfcheckoutmachine_port") + "/CD-smartcart-selfcheckoutmachine/CD-smartcart-selfcheckoutmachine");

		}
	};
	private Map<String, String> urlServices = new HashMap<String, String>() {
		{
			// Client Service URL
			put(CLIENT, "http://" + Configuration.get("client_host") + ":" + Configuration.get("client_port") + "/client/client");
			
			// Provider Services URL
			put(BASICCOMMUNICATIONDEVICE, "http://" + Configuration.get("basiccomunicationdevice_host") + ":" + Configuration.get("basiccomunicationdevice_port") + "/basiccommunicationdevice/basiccommunicationdevice");
			put(INSTORETOTEM, "http://" + Configuration.get("instoretotem_host") + ":" + Configuration.get("instoretotem_port") + "/instoretotem/instoretotem");
			put(SHOPPINGASSISTANTS, "http://" + Configuration.get("shoppingassistants_host") + ":" + Configuration.get("shoppingassistants_port") + "/shoppingassistantapp/shoppingassistantapp");
			
			// Prosumer Services URL
			put(MARKETINGAPPLICATION, "http://" + Configuration.get("marketingapplication_host") + ":" + Configuration.get("marketingapplication_port") + "/marketingapplication/marketingapplication");
			put(MARKETINGMANAGER, "http://" + Configuration.get("marketingmanager_host") + ":" + Configuration.get("marketingmanager_port") + "/marketingmanager/marketingmanager");
			put(SELFCHECKOUTMACHINE, "http://" + Configuration.get("selfcheckoutmachine_host") + ":" + Configuration.get("selfcheckoutmachine_port") + "/selfcheckoutmachine/selfcheckoutmachine");
			put(SHOPENTRANCE, "http://" + Configuration.get("shopentrance_host") + ":" + Configuration.get("shopentrance_port") + "/shopentrance/shopentrance");
			put(SMARTCART, "http://" + Configuration.get("smartcart_host") + ":" + Configuration.get("smartcart_port") + "/smartcart/smartcart");

		}
	};

	private Map<String, String> client_SIA = new HashMap<String, String>();
	private Map<String, String> marketingapplication_SIA = new HashMap<String, String>();
	private Map<String, String> marketingmanager_SIA = new HashMap<String, String>();
	private Map<String, String> selfcheckoutmachine_SIA = new HashMap<String, String>();
	private Map<String, String> shopentrance_SIA = new HashMap<String, String>();
	private Map<String, String> smartcart_SIA = new HashMap<String, String>();

	public Environment(boolean useCDsComponent) {
		this.useCDsComponent = useCDsComponent;
		
		if (useCDsComponent) {
			// client
			client_SIA.put(SELFCHECKOUTMACHINE, urlCDs.get(CD_CLIENT_SELFCHECKOUTMACHINE));
			client_SIA.put(SHOPENTRANCE, urlCDs.get(CD_CLIENT_SHOPENTRANCE));
			client_SIA.put(SMARTCART, urlCDs.get(CD_CLIENT_SMARTCART));

			// marketingapplication
			marketingapplication_SIA.put(BASICCOMMUNICATIONDEVICE, urlCDs.get(CD_MARKETINGAPPLICATION_BASICCOMMUNICATIONDEVICE));
			marketingapplication_SIA.put(INSTORETOTEM, urlCDs.get(CD_MARKETINGAPPLICATION_INSTORETOTEM));
			marketingapplication_SIA.put(MARKETINGMANAGER, urlCDs.get(CD_MARKETINGAPPLICATION_MARKETINGMANAGER));
			marketingapplication_SIA.put(SHOPPINGASSISTANTS, urlCDs.get(CD_MARKETINGAPPLICATION_SHOPPINGASSISTANTS));

			// marketingmanager
			marketingmanager_SIA.put(MARKETINGAPPLICATION, urlCDs.get(CD_MARKETINGMANAGER_MARKETINGAPPLICATION));

			// selfcheckoutmachine
			selfcheckoutmachine_SIA.put(MARKETINGAPPLICATION, urlCDs.get(CD_SELFCHECKOUTMACHINE_MARKETINGAPPLICATION));
			selfcheckoutmachine_SIA.put(SMARTCART, urlCDs.get(CD_SELFCHECKOUTMACHINE_SMARTCART));

			// shopentrance
			shopentrance_SIA.put(MARKETINGAPPLICATION, urlCDs.get(CD_SHOPENTRANCE_MARKETINGAPPLICATION));

			// smartcart
			smartcart_SIA.put(SELFCHECKOUTMACHINE, urlCDs.get(CD_SMARTCART_SELFCHECKOUTMACHINE));

		} else {

			// client
			client_SIA.put(SELFCHECKOUTMACHINE, urlServices.get(SELFCHECKOUTMACHINE));
			client_SIA.put(SHOPENTRANCE, urlServices.get(SHOPENTRANCE));
			client_SIA.put(SMARTCART, urlServices.get(SMARTCART));

			// marketingapplication
			marketingapplication_SIA.put(BASICCOMMUNICATIONDEVICE, urlServices.get(BASICCOMMUNICATIONDEVICE));
			marketingapplication_SIA.put(INSTORETOTEM, urlServices.get(INSTORETOTEM));
			marketingapplication_SIA.put(MARKETINGMANAGER, urlServices.get(MARKETINGMANAGER));
			marketingapplication_SIA.put(SHOPPINGASSISTANTS, urlServices.get(SHOPPINGASSISTANTS));

			// marketingmanager
			marketingmanager_SIA.put(MARKETINGAPPLICATION, urlServices.get(MARKETINGAPPLICATION));

			// selfcheckoutmachine
			selfcheckoutmachine_SIA.put(MARKETINGAPPLICATION, urlServices.get(MARKETINGAPPLICATION));
			selfcheckoutmachine_SIA.put(SMARTCART, urlServices.get(SMARTCART));

			// shopentrance
			shopentrance_SIA.put(MARKETINGAPPLICATION, urlServices.get(MARKETINGAPPLICATION));

			// smartcart
			smartcart_SIA.put(SELFCHECKOUTMACHINE, urlServices.get(SELFCHECKOUTMACHINE));
		}

	}

	/*
	 * NOTE: THIS METHOD HAS BEEN CHANGED IN ORDER TO REALIZE THE END-COREOGRAPHY FUNCTION!
	 */
	public void callScenarioSetupForEndChoreography() throws MalformedURLException {
		// Call scenarioSetup() for prosumer serivices
		ClientService clientService = new ClientService(new URL(urlServices.get(CLIENT)));
		Client client = clientService.getClientPort();
		client.scenarioSetup();

		MarketingApplicationService marketingApplicationService = new MarketingApplicationService(new URL(urlServices.get(MARKETINGAPPLICATION)));
		MarketingApplication marketingApplication = marketingApplicationService.getMarketingApplicationPort();
		marketingApplication.scenarioSetup();

		MarketingManagerService marketingManagerService = new MarketingManagerService(new URL(urlServices.get(MARKETINGMANAGER)));
		MarketingManager marketingManager = marketingManagerService.getMarketingManagerPort();
		marketingManager.scenarioSetup();

		SelfCheckOutMachineService selfCheckOutMachineService = new SelfCheckOutMachineService(new URL(urlServices.get(SELFCHECKOUTMACHINE)));
		SelfCheckOutMachine selfCheckOutMachine = selfCheckOutMachineService.getSelfCheckOutMachinePort();
		selfCheckOutMachine.scenarioSetup();

		ShopEntranceService shopEntranceServiceService = new ShopEntranceService(new URL(urlServices.get(SHOPENTRANCE)));
		ShopEntrance shopEntrance = shopEntranceServiceService.getShopEntrancePort();
		shopEntrance.scenarioSetup();

		SmartCartService smartCartService = new SmartCartService(new URL(urlServices.get(SMARTCART)));
		SmartCart smartCart = smartCartService.getSmartCartPort();
		smartCart.scenarioSetup();

		//Added because missing in EnactChoreography
		InStoreTotemService inStoreTotemService = new InStoreTotemService(new URL(urlServices.get(INSTORETOTEM)));
		InStoreTotem inStoreTotem = inStoreTotemService.getInStoreTotemPort();
		inStoreTotem.scenarioSetup();

		ShoppingassistantappService shoppingassistantappService = new ShoppingassistantappService(new URL(urlServices.get(SHOPPINGASSISTANTS)));
		Shoppingassistantapp shoppingassistantapp = shoppingassistantappService.getShoppingassistantappPort();
		shoppingassistantapp.scenarioSetup();

		// Call scenarioSetup() for CDs components
		if (useCDsComponent) {

			SelfCheckOutMachineService CD_client_selfcheckoutmachineService = new SelfCheckOutMachineService(new URL(urlCDs.get(CD_CLIENT_SELFCHECKOUTMACHINE)));
			SelfCheckOutMachine CD_client_selfcheckoutmachine = CD_client_selfcheckoutmachineService.getSelfCheckOutMachinePort();
			CD_client_selfcheckoutmachine.setInvocationAddress(SELFCHECKOUTMACHINE, SELFCHECKOUTMACHINE, Arrays.asList(urlServices.get(SELFCHECKOUTMACHINE)));
			CD_client_selfcheckoutmachine.scenarioSetup();

			ShopEntranceService CD_client_shopentranceService = new ShopEntranceService(new URL(urlCDs.get(CD_CLIENT_SHOPENTRANCE)));
			ShopEntrance CD_client_shopentrance = CD_client_shopentranceService.getShopEntrancePort();
			CD_client_shopentrance.setInvocationAddress(SHOPENTRANCE, SHOPENTRANCE, Arrays.asList(urlServices.get(SHOPENTRANCE)));
			CD_client_shopentrance.scenarioSetup();

			SmartCartService CD_client_smartcartService = new SmartCartService(new URL(urlCDs.get(CD_CLIENT_SMARTCART)));
			SmartCart CD_client_smartcart = CD_client_smartcartService.getSmartCartPort();
			CD_client_smartcart.setInvocationAddress(SMARTCART, SMARTCART, Arrays.asList(urlServices.get(SMARTCART)));
			CD_client_smartcart.scenarioSetup();

			BasicCommunicationDeviceService CD_marketingapplication_basiccommunicationdeviceService = new BasicCommunicationDeviceService(new URL(urlCDs.get(CD_MARKETINGAPPLICATION_BASICCOMMUNICATIONDEVICE)));
			BasicCommunicationDevice CD_marketingapplication_basiccommunicationdevice = CD_marketingapplication_basiccommunicationdeviceService.getBasicCommunicationDevicePort();
			CD_marketingapplication_basiccommunicationdevice.setInvocationAddress(BASICCOMMUNICATIONDEVICE, BASICCOMMUNICATIONDEVICE, Arrays.asList(urlServices.get(BASICCOMMUNICATIONDEVICE)));
			CD_marketingapplication_basiccommunicationdevice.scenarioSetup();

			InStoreTotemService CD_marketingapplication_instoretotemService = new InStoreTotemService(new URL(urlCDs.get(CD_MARKETINGAPPLICATION_INSTORETOTEM)));
			InStoreTotem CD_marketingapplication_instoretotem = CD_marketingapplication_instoretotemService.getInStoreTotemPort();
			CD_marketingapplication_instoretotem.setInvocationAddress(INSTORETOTEM, INSTORETOTEM, Arrays.asList(urlServices.get(INSTORETOTEM)));
			CD_marketingapplication_instoretotem.scenarioSetup();

			MarketingManagerService CD_marketingapplication_marketingmanagerService = new MarketingManagerService(new URL(urlCDs.get(CD_MARKETINGAPPLICATION_MARKETINGMANAGER)));
			MarketingManager CD_marketingapplication_marketingmanager = CD_marketingapplication_marketingmanagerService.getMarketingManagerPort();
			CD_marketingapplication_marketingmanager.setInvocationAddress(MARKETINGMANAGER, MARKETINGMANAGER, Arrays.asList(urlServices.get(MARKETINGMANAGER)));
			CD_marketingapplication_marketingmanager.scenarioSetup();

			ShoppingassistantappService CD_marketingapplication_shoppingassistantappService = new ShoppingassistantappService(new URL(urlCDs.get(CD_MARKETINGAPPLICATION_SHOPPINGASSISTANTS)));
			Shoppingassistantapp CD_marketingapplication_shoppingassistantapp = CD_marketingapplication_shoppingassistantappService.getShoppingassistantappPort();
			CD_marketingapplication_shoppingassistantapp.setInvocationAddress(SHOPPINGASSISTANTS, SHOPPINGASSISTANTS, Arrays.asList(urlServices.get(SHOPPINGASSISTANTS)));
			CD_marketingapplication_shoppingassistantapp.scenarioSetup();

			MarketingApplicationService CD_marketingmanager_marketingapplicationService = new MarketingApplicationService(new URL(urlCDs.get(CD_MARKETINGMANAGER_MARKETINGAPPLICATION)));
			MarketingApplication CD_marketingmanager_marketingapplication = CD_marketingmanager_marketingapplicationService.getMarketingApplicationPort();
			CD_marketingmanager_marketingapplication.setInvocationAddress(MARKETINGAPPLICATION, MARKETINGAPPLICATION, Arrays.asList(urlServices.get(MARKETINGAPPLICATION)));
			CD_marketingmanager_marketingapplication.scenarioSetup();

			MarketingApplicationService CD_selfcheckoutmachine_marketingapplicationService = new MarketingApplicationService(new URL(urlCDs.get(CD_SELFCHECKOUTMACHINE_MARKETINGAPPLICATION)));
			MarketingApplication CD_selfcheckoutmachine_marketingapplication = CD_selfcheckoutmachine_marketingapplicationService.getMarketingApplicationPort();
			CD_selfcheckoutmachine_marketingapplication.setInvocationAddress(MARKETINGAPPLICATION, MARKETINGAPPLICATION, Arrays.asList(urlServices.get(MARKETINGAPPLICATION)));
			CD_selfcheckoutmachine_marketingapplication.scenarioSetup();

			SmartCartService CD_selfcheckoutmachine_smartcartService = new SmartCartService(new URL(urlCDs.get(CD_SELFCHECKOUTMACHINE_SMARTCART)));
			SmartCart CD_selfcheckoutmachine_smartcart = CD_selfcheckoutmachine_smartcartService.getSmartCartPort();
			CD_selfcheckoutmachine_smartcart.setInvocationAddress(SMARTCART, SMARTCART, Arrays.asList(urlServices.get(SMARTCART)));
			CD_selfcheckoutmachine_smartcart.scenarioSetup();

			MarketingApplicationService CD_shopentrance_marketingapplicationService = new MarketingApplicationService(new URL(urlCDs.get(CD_SHOPENTRANCE_MARKETINGAPPLICATION)));
			MarketingApplication CD_shopentrance_marketingapplication = CD_shopentrance_marketingapplicationService.getMarketingApplicationPort();
			CD_shopentrance_marketingapplication.setInvocationAddress(MARKETINGAPPLICATION, MARKETINGAPPLICATION, Arrays.asList(urlServices.get(MARKETINGAPPLICATION)));
			CD_shopentrance_marketingapplication.scenarioSetup();

			SelfCheckOutMachineService CD_smartcart_selfcheckoutmachineService = new SelfCheckOutMachineService(new URL(urlCDs.get(CD_SMARTCART_SELFCHECKOUTMACHINE)));
			SelfCheckOutMachine CD_smartcart_selfcheckoutmachine = CD_smartcart_selfcheckoutmachineService.getSelfCheckOutMachinePort();
			CD_smartcart_selfcheckoutmachine.setInvocationAddress(SELFCHECKOUTMACHINE, SELFCHECKOUTMACHINE, Arrays.asList(urlServices.get(SELFCHECKOUTMACHINE)));
			CD_smartcart_selfcheckoutmachine.scenarioSetup();
		}
	}

}
