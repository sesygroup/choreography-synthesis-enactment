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

@WebService(name = "ShopEntrance", targetNamespace = "http://services.choreos.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ShopEntrance {

    @WebMethod
    @RequestWrapper(localName = "scenarioSetup", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ScenarioSetup")
    @ResponseWrapper(localName = "scenarioSetupResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ScenarioSetupResponse")
    @Action(input = "http://services.choreos.org/ShopEntrance/scenarioSetupRequest", output = "http://services.choreos.org/ShopEntrance/scenarioSetupResponse")
    public void scenarioSetup();

    @WebMethod(operationName = "check_in_and_assign_cart")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "check_in_and_assign_cart", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.CheckInAndAssignCart")
    @ResponseWrapper(localName = "check_in_and_assign_cartResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.CheckInAndAssignCartResponse")
    @Action(input = "http://services.choreos.org/ShopEntrance/check_in_and_assign_cartRequest", output = "http://services.choreos.org/ShopEntrance/check_in_and_assign_cartResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/ShopEntrance/check_in_and_assign_cart/Fault/ScenarioException")
    })
    public String checkInAndAssignCart(
            @WebParam(name = "sessionId", targetNamespace = "") String sessionId,
            @WebParam(name = "shoopingList", targetNamespace = "") List<ShoppingListEntry> shoopingList)
            throws ScenarioException_Exception;

    @WebMethod
    @RequestWrapper(localName = "register", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.Register")
    @ResponseWrapper(localName = "registerResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.RegisterResponse")
    @Action(input = "http://services.choreos.org/ShopEntrance/registerRequest", output = "http://services.choreos.org/ShopEntrance/registerResponse")
    public void register(
            @WebParam(name = "cart_id", targetNamespace = "") String cartId);

    @WebMethod
    @RequestWrapper(localName = "setInvocationAddress", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetInvocationAddress")
    @ResponseWrapper(localName = "setInvocationAddressResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetInvocationAddressResponse")
    @Action(input = "http://services.choreos.org/ShopEntrance/setInvocationAddressRequest", output = "http://services.choreos.org/ShopEntrance/setInvocationAddressResponse")
    public void setInvocationAddress(
            @WebParam(name = "arg0", targetNamespace = "") String arg0,
            @WebParam(name = "arg1", targetNamespace = "") String arg1,
            @WebParam(name = "arg2", targetNamespace = "") List<String> arg2);

    @WebMethod
    @RequestWrapper(localName = "setEndpointAddress", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetEndpointAddress")
    @ResponseWrapper(localName = "setEndpointAddressResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetEndpointAddressResponse")
    @Action(input = "http://services.choreos.org/ShopEntrance/setEndpointAddressRequest", output = "http://services.choreos.org/ShopEntrance/setEndpointAddressResponse")
    public void setEndpointAddress(
            @WebParam(name = "arg0", targetNamespace = "") String arg0);

}
