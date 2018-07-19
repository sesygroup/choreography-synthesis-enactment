package org.choreos.services;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "SmartCart", targetNamespace = "http://services.choreos.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SmartCart {

    @WebMethod
    @RequestWrapper(localName = "scenarioSetup", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ScenarioSetup")
    @ResponseWrapper(localName = "scenarioSetupResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ScenarioSetupResponse")
    @Action(input = "http://services.choreos.org/SmartCart/scenarioSetupRequest", output = "http://services.choreos.org/SmartCart/scenarioSetupResponse")
    public void scenarioSetup();

    @WebMethod(operationName = "add_product")
    @RequestWrapper(localName = "add_product", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.AddProduct")
    @ResponseWrapper(localName = "add_productResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.AddProductResponse")
    @Action(input = "http://services.choreos.org/SmartCart/add_productRequest", output = "http://services.choreos.org/SmartCart/add_productResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/SmartCart/add_product/Fault/ScenarioException")
    })
    public void addProduct(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId,
            @WebParam(name = "cartId", targetNamespace = "") String cartId,
            @WebParam(name = "product", targetNamespace = "") Product product,
            @WebParam(name = "qty", targetNamespace = "") Integer qty)
            throws ScenarioException_Exception;

    @WebMethod(operationName = "remove_product")
    @RequestWrapper(localName = "remove_product", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.RemoveProduct")
    @ResponseWrapper(localName = "remove_productResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.RemoveProductResponse")
    @Action(input = "http://services.choreos.org/SmartCart/remove_productRequest", output = "http://services.choreos.org/SmartCart/remove_productResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/SmartCart/remove_product/Fault/ScenarioException")
    })
    public void removeProduct(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId,
            @WebParam(name = "cartId", targetNamespace = "") String cartId,
            @WebParam(name = "product", targetNamespace = "") Product product)
            throws ScenarioException_Exception;

    @WebMethod(operationName = "change_qty")
    @RequestWrapper(localName = "change_qty", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ChangeQty")
    @ResponseWrapper(localName = "change_qtyResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ChangeQtyResponse")
    @Action(input = "http://services.choreos.org/SmartCart/change_qtyRequest", output = "http://services.choreos.org/SmartCart/change_qtyResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/SmartCart/change_qty/Fault/ScenarioException")
    })
    public void changeQty(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId,
            @WebParam(name = "cartId", targetNamespace = "") String cartId,
            @WebParam(name = "product", targetNamespace = "") Product product,
            @WebParam(name = "qty", targetNamespace = "") Integer qty)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "subscribeUserToCart", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SubscribeUserToCart")
    @ResponseWrapper(localName = "subscribeUserToCartResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SubscribeUserToCartResponse")
    @Action(input = "http://services.choreos.org/SmartCart/subscribeUserToCartRequest", output = "http://services.choreos.org/SmartCart/subscribeUserToCartResponse")
    public void subscribeUserToCart(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId,
            @WebParam(name = "cartId", targetNamespace = "") String cartId);

    @WebMethod
    @RequestWrapper(localName = "unsubscribeUserFrom", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.UnsubscribeUserFrom")
    @ResponseWrapper(localName = "unsubscribeUserFromResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.UnsubscribeUserFromResponse")
    @Action(input = "http://services.choreos.org/SmartCart/unsubscribeUserFromRequest", output = "http://services.choreos.org/SmartCart/unsubscribeUserFromResponse")
    public void unsubscribeUserFrom(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId,
            @WebParam(name = "cartId", targetNamespace = "") String cartId);

    @WebMethod
    @RequestWrapper(localName = "payRequired", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.PayRequired")
    @ResponseWrapper(localName = "payRequiredResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.PayRequiredResponse")
    @Action(input = "http://services.choreos.org/SmartCart/payRequiredRequest", output = "http://services.choreos.org/SmartCart/payRequiredResponse")
    public void payRequired(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId,
            @WebParam(name = "cartId", targetNamespace = "") String cartId,
            @WebParam(name = "comId", targetNamespace = "") String comId);

    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "isAvailable", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.IsAvailable")
    @ResponseWrapper(localName = "isAvailableResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.IsAvailableResponse")
    @Action(input = "http://services.choreos.org/SmartCart/isAvailableRequest", output = "http://services.choreos.org/SmartCart/isAvailableResponse")
    public boolean isAvailable(
            @WebParam(name = "cartId", targetNamespace = "") String cartId);

    @WebMethod
    @RequestWrapper(localName = "setInvocationAddress", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetInvocationAddress")
    @ResponseWrapper(localName = "setInvocationAddressResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetInvocationAddressResponse")
    @Action(input = "http://services.choreos.org/SmartCart/setInvocationAddressRequest", output = "http://services.choreos.org/SmartCart/setInvocationAddressResponse")
    public void setInvocationAddress(
            @WebParam(name = "arg0", targetNamespace = "") String arg0,
            @WebParam(name = "arg1", targetNamespace = "") String arg1,
            @WebParam(name = "arg2", targetNamespace = "") List<String> arg2);

    @WebMethod
    @RequestWrapper(localName = "setEndpointAddress", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetEndpointAddress")
    @ResponseWrapper(localName = "setEndpointAddressResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetEndpointAddressResponse")
    @Action(input = "http://services.choreos.org/SmartCart/setEndpointAddressRequest", output = "http://services.choreos.org/SmartCart/setEndpointAddressResponse")
    public void setEndpointAddress(
            @WebParam(name = "arg0", targetNamespace = "") String arg0);

}
