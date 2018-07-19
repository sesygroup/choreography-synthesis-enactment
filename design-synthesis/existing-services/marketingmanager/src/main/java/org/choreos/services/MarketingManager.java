
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


@WebService(name = "MarketingManager", targetNamespace = "http://services.choreos.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MarketingManager {


    @WebMethod
    @RequestWrapper(localName = "scenarioSetup", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ScenarioSetup")
    @ResponseWrapper(localName = "scenarioSetupResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ScenarioSetupResponse")
    @Action(input = "http://services.choreos.org/MarketingManager/scenarioSetupRequest", output = "http://services.choreos.org/MarketingManager/scenarioSetupResponse")
    public void scenarioSetup();

    @WebMethod
    @RequestWrapper(localName = "putEstimationReq", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.PutEstimationReq")
    @ResponseWrapper(localName = "putEstimationReqResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.PutEstimationReqResponse")
    @Action(input = "http://services.choreos.org/MarketingManager/putEstimationReqRequest", output = "http://services.choreos.org/MarketingManager/putEstimationReqResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingManager/putEstimationReq/Fault/ScenarioException")
    })
    public void putEstimationReq(
        @WebParam(name = "sessionId", targetNamespace = "")
        String sessionId,
        @WebParam(name = "estimationNeedAlert", targetNamespace = "")
        EstimationNeedAlert estimationNeedAlert)
        throws ScenarioException_Exception
    ;

    @WebMethod
    @RequestWrapper(localName = "requestPrivateOffer", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.RequestPrivateOffer")
    @ResponseWrapper(localName = "requestPrivateOfferResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.RequestPrivateOfferResponse")
    @Action(input = "http://services.choreos.org/MarketingManager/requestPrivateOfferRequest", output = "http://services.choreos.org/MarketingManager/requestPrivateOfferResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingManager/requestPrivateOffer/Fault/ScenarioException")
    })
    public void requestPrivateOffer(
        @WebParam(name = "sessionId", targetNamespace = "")
        String sessionId,
        @WebParam(name = "product", targetNamespace = "")
        Product product)
        throws ScenarioException_Exception
    ;

   
    @WebMethod
    @RequestWrapper(localName = "requestPublicOffer", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.RequestPublicOffer")
    @ResponseWrapper(localName = "requestPublicOfferResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.RequestPublicOfferResponse")
    @Action(input = "http://services.choreos.org/MarketingManager/requestPublicOfferRequest", output = "http://services.choreos.org/MarketingManager/requestPublicOfferResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/MarketingManager/requestPublicOffer/Fault/ScenarioException")
    })
    public void requestPublicOffer(
        @WebParam(name = "sessionId", targetNamespace = "")
        String sessionId)
        throws ScenarioException_Exception
    ;

   
    @WebMethod
    @RequestWrapper(localName = "setInvocationAddress", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetInvocationAddress")
    @ResponseWrapper(localName = "setInvocationAddressResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetInvocationAddressResponse")
    @Action(input = "http://services.choreos.org/MarketingManager/setInvocationAddressRequest", output = "http://services.choreos.org/MarketingManager/setInvocationAddressResponse")
    public void setInvocationAddress(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        List<String> arg2);

   
    @WebMethod
    @RequestWrapper(localName = "setEndpointAddress", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetEndpointAddress")
    @ResponseWrapper(localName = "setEndpointAddressResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetEndpointAddressResponse")
    @Action(input = "http://services.choreos.org/MarketingManager/setEndpointAddressRequest", output = "http://services.choreos.org/MarketingManager/setEndpointAddressResponse")
    public void setEndpointAddress(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
