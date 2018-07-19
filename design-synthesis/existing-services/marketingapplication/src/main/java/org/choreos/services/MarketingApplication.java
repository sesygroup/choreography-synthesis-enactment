package org.choreos.services;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "MarketingApplication", targetNamespace = "http://services.choreos.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MarketingApplication {

    @WebMethod
    @RequestWrapper(localName = "scenarioSetup", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ScenarioSetup")
    @ResponseWrapper(localName = "scenarioSetupResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ScenarioSetupResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/scenarioSetupRequest", output = "http://services.choreos.org/MarketingApplication/scenarioSetupResponse")
    public void scenarioSetup();

    @WebMethod
    @RequestWrapper(localName = "basicCommDeviceSubscribe", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.BasicCommDeviceSubscribe")
    @ResponseWrapper(localName = "basicCommDeviceSubscribeResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.BasicCommDeviceSubscribeResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/basicCommDeviceSubscribeRequest", output = "http://services.choreos.org/MarketingApplication/basicCommDeviceSubscribeResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/basicCommDeviceSubscribe/Fault/ScenarioException")
    })
    public void basicCommDeviceSubscribe(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "shopAssistAppSubscribe", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ShopAssistAppSubscribe")
    @ResponseWrapper(localName = "shopAssistAppSubscribeResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ShopAssistAppSubscribeResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/shopAssistAppSubscribeRequest", output = "http://services.choreos.org/MarketingApplication/shopAssistAppSubscribeResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/shopAssistAppSubscribe/Fault/ScenarioException")
    })
    public void shopAssistAppSubscribe(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "shopAssistAppUnsubscribe", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ShopAssistAppUnsubscribe")
    @ResponseWrapper(localName = "shopAssistAppUnsubscribeResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ShopAssistAppUnsubscribeResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/shopAssistAppUnsubscribeRequest", output = "http://services.choreos.org/MarketingApplication/shopAssistAppUnsubscribeResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/shopAssistAppUnsubscribe/Fault/ScenarioException")
    })
    public void shopAssistAppUnsubscribe(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "basicCommDeviceUnsubscribe", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.BasicCommDeviceUnsubscribe")
    @ResponseWrapper(localName = "basicCommDeviceUnsubscribeResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.BasicCommDeviceUnsubscribeResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/basicCommDeviceUnsubscribeRequest", output = "http://services.choreos.org/MarketingApplication/basicCommDeviceUnsubscribeResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/basicCommDeviceUnsubscribe/Fault/ScenarioException")
    })
    public void basicCommDeviceUnsubscribe(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId)
            throws ScenarioException_Exception;

    @WebMethod(operationName = "unsubscribeto_supply_authorization")
    @RequestWrapper(localName = "unsubscribeto_supply_authorization", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.UnsubscribetoSupplyAuthorization")
    @ResponseWrapper(localName = "unsubscribeto_supply_authorizationResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.UnsubscribetoSupplyAuthorizationResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/unsubscribeto_supply_authorizationRequest", output = "http://services.choreos.org/MarketingApplication/unsubscribeto_supply_authorizationResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/unsubscribeto_supply_authorization/Fault/ScenarioException")
    })
    public void unsubscribetoSupplyAuthorization(
            @WebParam(name = "callbackAddress", targetNamespace = "") String callbackAddress)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "publicOfferConfirmation", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.PublicOfferConfirmation")
    @ResponseWrapper(localName = "publicOfferConfirmationResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.PublicOfferConfirmationResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/publicOfferConfirmationRequest", output = "http://services.choreos.org/MarketingApplication/publicOfferConfirmationResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/publicOfferConfirmation/Fault/ScenarioException")
    })
    public void publicOfferConfirmation(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId,
            @WebParam(name = "offer", targetNamespace = "") Offer offer,
            @WebParam(name = "confirmed", targetNamespace = "") boolean confirmed)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "proposeAlternative", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ProposeAlternative")
    @ResponseWrapper(localName = "proposeAlternativeResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ProposeAlternativeResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/proposeAlternativeRequest", output = "http://services.choreos.org/MarketingApplication/proposeAlternativeResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/proposeAlternative/Fault/ScenarioException")
    })
    public void proposeAlternative(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId,
            @WebParam(name = "alternativeproduct", targetNamespace = "") Product alternativeproduct,
            @WebParam(name = "availability", targetNamespace = "") Integer availability,
            @WebParam(name = "callbackAddress", targetNamespace = "") String callbackAddress)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "authorize", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.Authorize")
    @ResponseWrapper(localName = "authorizeResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.AuthorizeResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/authorizeRequest", output = "http://services.choreos.org/MarketingApplication/authorizeResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/authorize/Fault/ScenarioException")
    })
    public void authorize(
            @WebParam(name = "sa", targetNamespace = "") SupplyAgreement sa,
            @WebParam(name = "authorized", targetNamespace = "") boolean authorized,
            @WebParam(name = "callbackAddress", targetNamespace = "") String callbackAddress)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "communicateAnswers", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.CommunicateAnswers")
    @ResponseWrapper(localName = "communicateAnswersResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.CommunicateAnswersResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/communicateAnswersRequest", output = "http://services.choreos.org/MarketingApplication/communicateAnswersResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/communicateAnswers/Fault/ScenarioException")
    })
    public void communicateAnswers(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId,
            @WebParam(name = "questionnaire", targetNamespace = "") Questionnaire questionnaire)
            throws ScenarioException_Exception;

    @WebMethod(operationName = "set_estimate")
    @RequestWrapper(localName = "set_estimate", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetEstimate")
    @ResponseWrapper(localName = "set_estimateResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetEstimateResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/set_estimateRequest", output = "http://services.choreos.org/MarketingApplication/set_estimateResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/set_estimate/Fault/ScenarioException")
    })
    public void setEstimate(
            @WebParam(name = "est", targetNamespace = "") Estimate est)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "addProductNotify", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.AddProductNotify")
    @ResponseWrapper(localName = "addProductNotifyResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.AddProductNotifyResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/addProductNotifyRequest", output = "http://services.choreos.org/MarketingApplication/addProductNotifyResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/addProductNotify/Fault/ScenarioException")
    })
    public void addProductNotify(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId,
            @WebParam(name = "product", targetNamespace = "") Product product,
            @WebParam(name = "qty", targetNamespace = "") Integer qty)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "notifyCheckin", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.NotifyCheckin")
    @ResponseWrapper(localName = "notifyCheckinResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.NotifyCheckinResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/notifyCheckinRequest", output = "http://services.choreos.org/MarketingApplication/notifyCheckinResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/notifyCheckin/Fault/ScenarioException")
    })
    public void notifyCheckin(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId,
            @WebParam(name = "shoppingList", targetNamespace = "") List<ShoppingListEntry> shoppingList)
            throws ScenarioException_Exception;

    @WebMethod(operationName = "unsubscribe_to_sales_estimation")
    @RequestWrapper(localName = "unsubscribe_to_sales_estimation", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.UnsubscribeToSalesEstimation")
    @ResponseWrapper(localName = "unsubscribe_to_sales_estimationResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.UnsubscribeToSalesEstimationResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/unsubscribe_to_sales_estimationRequest", output = "http://services.choreos.org/MarketingApplication/unsubscribe_to_sales_estimationResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/unsubscribe_to_sales_estimation/Fault/ScenarioException")
    })
    public void unsubscribeToSalesEstimation(
            @WebParam(name = "callbackAddress", targetNamespace = "") String callbackAddress)
            throws ScenarioException_Exception;

    @WebMethod(operationName = "ma_receive_sms")
    @RequestWrapper(localName = "ma_receive_sms", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.MaReceiveSms")
    @ResponseWrapper(localName = "ma_receive_smsResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.MaReceiveSmsResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/ma_receive_smsRequest", output = "http://services.choreos.org/MarketingApplication/ma_receive_smsResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/ma_receive_sms/Fault/ScenarioException")
    })
    public void maReceiveSms(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId,
            @WebParam(name = "msg", targetNamespace = "") SMSMessage msg)
            throws ScenarioException_Exception;

    @WebMethod(operationName = "subscribe_to_sales_estimation")
    @RequestWrapper(localName = "subscribe_to_sales_estimation", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SubscribeToSalesEstimation")
    @ResponseWrapper(localName = "subscribe_to_sales_estimationResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SubscribeToSalesEstimationResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/subscribe_to_sales_estimationRequest", output = "http://services.choreos.org/MarketingApplication/subscribe_to_sales_estimationResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/subscribe_to_sales_estimation/Fault/ScenarioException")
    })
    public void subscribeToSalesEstimation(
            @WebParam(name = "callbackAddress", targetNamespace = "") String callbackAddress)
            throws ScenarioException_Exception;

    @WebMethod(operationName = "subscribe_to_supply_authorization")
    @RequestWrapper(localName = "subscribe_to_supply_authorization", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SubscribeToSupplyAuthorization")
    @ResponseWrapper(localName = "subscribe_to_supply_authorizationResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SubscribeToSupplyAuthorizationResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/subscribe_to_supply_authorizationRequest", output = "http://services.choreos.org/MarketingApplication/subscribe_to_supply_authorizationResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/subscribe_to_supply_authorization/Fault/ScenarioException")
    })
    public void subscribeToSupplyAuthorization(
            @WebParam(name = "callbackAddress", targetNamespace = "") String callbackAddress)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "notifyCheckout", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.NotifyCheckout")
    @ResponseWrapper(localName = "notifyCheckoutResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.NotifyCheckoutResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/notifyCheckoutRequest", output = "http://services.choreos.org/MarketingApplication/notifyCheckoutResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/notifyCheckout/Fault/ScenarioException")
    })
    public void notifyCheckout(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId)
            throws ScenarioException_Exception;

    @WebMethod(operationName = "shopping_list_communication")
    @RequestWrapper(localName = "shopping_list_communication", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ShoppingListCommunication")
    @ResponseWrapper(localName = "shopping_list_communicationResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ShoppingListCommunicationResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/shopping_list_communicationRequest", output = "http://services.choreos.org/MarketingApplication/shopping_list_communicationResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/shopping_list_communication/Fault/ScenarioException")
    })
    public void shoppingListCommunication(
            @WebParam(name = "user", targetNamespace = "") User user,
            @WebParam(name = "shoppinglist", targetNamespace = "") ShoppingList shoppinglist,
            @WebParam(name = "callbackAddress", targetNamespace = "") String callbackAddress)
            throws ScenarioException_Exception;

    @WebMethod(operationName = "unsubscribe_to_supply_negotiation")
    @RequestWrapper(localName = "unsubscribe_to_supply_negotiation", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.UnsubscribeToSupplyNegotiation")
    @ResponseWrapper(localName = "unsubscribe_to_supply_negotiationResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.UnsubscribeToSupplyNegotiationResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/unsubscribe_to_supply_negotiationRequest", output = "http://services.choreos.org/MarketingApplication/unsubscribe_to_supply_negotiationResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/unsubscribe_to_supply_negotiation/Fault/ScenarioException")
    })
    public void unsubscribeToSupplyNegotiation(
            @WebParam(name = "sesssionId", targetNamespace = "") String sesssionId)
            throws ScenarioException_Exception;

    @WebMethod(operationName = "subscribe_to_supply_negotation")
    @RequestWrapper(localName = "subscribe_to_supply_negotation", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SubscribeToSupplyNegotation")
    @ResponseWrapper(localName = "subscribe_to_supply_negotationResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SubscribeToSupplyNegotationResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/subscribe_to_supply_negotationRequest", output = "http://services.choreos.org/MarketingApplication/subscribe_to_supply_negotationResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/subscribe_to_supply_negotation/Fault/ScenarioException")
    })
    public void subscribeToSupplyNegotation(
            @WebParam(name = "sesssionId", targetNamespace = "") String sesssionId)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "storeBoughtItems", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.StoreBoughtItems")
    @ResponseWrapper(localName = "storeBoughtItemsResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.StoreBoughtItemsResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/storeBoughtItemsRequest", output = "http://services.choreos.org/MarketingApplication/storeBoughtItemsResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/storeBoughtItems/Fault/ScenarioException")
    })
    public void storeBoughtItems(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId,
            @WebParam(name = "items", targetNamespace = "") List<Product> items)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "changeQtyNotify", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ChangeQtyNotify")
    @ResponseWrapper(localName = "changeQtyNotifyResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ChangeQtyNotifyResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/changeQtyNotifyRequest", output = "http://services.choreos.org/MarketingApplication/changeQtyNotifyResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/changeQtyNotify/Fault/ScenarioException")
    })
    public void changeQtyNotify(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId,
            @WebParam(name = "product", targetNamespace = "") Product product,
            @WebParam(name = "qty", targetNamespace = "") Integer qty)
            throws ScenarioException_Exception;

    @WebMethod(operationName = "make_proposal")
    @RequestWrapper(localName = "make_proposal", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.MakeProposal")
    @ResponseWrapper(localName = "make_proposalResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.MakeProposalResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/make_proposalRequest", output = "http://services.choreos.org/MarketingApplication/make_proposalResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/make_proposal/Fault/ScenarioException")
    })
    public void makeProposal(
            @WebParam(name = "sesssionId", targetNamespace = "") String sesssionId,
            @WebParam(name = "proposal", targetNamespace = "") SupplyAgreement proposal)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "privateOfferConfirmation", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.PrivateOfferConfirmation")
    @ResponseWrapper(localName = "privateOfferConfirmationResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.PrivateOfferConfirmationResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/privateOfferConfirmationRequest", output = "http://services.choreos.org/MarketingApplication/privateOfferConfirmationResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/privateOfferConfirmation/Fault/ScenarioException")
    })
    public void privateOfferConfirmation(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId,
            @WebParam(name = "offer", targetNamespace = "") Offer offer,
            @WebParam(name = "confirmed", targetNamespace = "") boolean confirmed)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "removeProductNotify", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.RemoveProductNotify")
    @ResponseWrapper(localName = "removeProductNotifyResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.RemoveProductNotifyResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/removeProductNotifyRequest", output = "http://services.choreos.org/MarketingApplication/removeProductNotifyResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/removeProductNotify/Fault/ScenarioException")
    })
    public void removeProductNotify(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId,
            @WebParam(name = "product", targetNamespace = "") Product product)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "put", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.Put")
    @ResponseWrapper(localName = "putResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.PutResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/putRequest", output = "http://services.choreos.org/MarketingApplication/putResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingApplication/put/Fault/ScenarioException")
    })
    public void put(
            @WebParam(name = "stockLevelNotification", targetNamespace = "") StockLevelNotification stockLevelNotification)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "setInvocationAddress", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetInvocationAddress")
    @ResponseWrapper(localName = "setInvocationAddressResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetInvocationAddressResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/setInvocationAddressRequest", output = "http://services.choreos.org/MarketingApplication/setInvocationAddressResponse")
    public void setInvocationAddress(
            @WebParam(name = "arg0", targetNamespace = "") String arg0,
            @WebParam(name = "arg1", targetNamespace = "") String arg1,
            @WebParam(name = "arg2", targetNamespace = "") List<String> arg2);

    @WebMethod
    @RequestWrapper(localName = "setEndpointAddress", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetEndpointAddress")
    @ResponseWrapper(localName = "setEndpointAddressResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetEndpointAddressResponse")
    @Action(input = "http://services.choreos.org/MarketingApplication/setEndpointAddressRequest", output = "http://services.choreos.org/MarketingApplication/setEndpointAddressResponse")
    public void setEndpointAddress(
            @WebParam(name = "arg0", targetNamespace = "") String arg0);

}
