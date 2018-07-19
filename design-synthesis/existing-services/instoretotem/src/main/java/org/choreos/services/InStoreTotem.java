
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


@WebService(name = "InStoreTotem", targetNamespace = "http://services.choreos.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface InStoreTotem {


    @WebMethod
    @RequestWrapper(localName = "scenarioSetup", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ScenarioSetup")
    @ResponseWrapper(localName = "scenarioSetupResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ScenarioSetupResponse")
    @Action(input = "http://services.choreos.org/InStoreTotem/scenarioSetupRequest", output = "http://services.choreos.org/InStoreTotem/scenarioSetupResponse")
    public void scenarioSetup();


    @WebMethod
    @RequestWrapper(localName = "publish", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.Publish")
    @ResponseWrapper(localName = "publishResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.PublishResponse")
    @Action(input = "http://services.choreos.org/InStoreTotem/publishRequest", output = "http://services.choreos.org/InStoreTotem/publishResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/InStoreTotem/publish/Fault/ScenarioException")
    })
    public void publish(
        @WebParam(name = "sessionId", targetNamespace = "")
        String sessionId,
        @WebParam(name = "offer", targetNamespace = "")
        Offer offer)
        throws ScenarioException_Exception
    ;

    
    @WebMethod
    @RequestWrapper(localName = "setInvocationAddress", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetInvocationAddress")
    @ResponseWrapper(localName = "setInvocationAddressResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetInvocationAddressResponse")
    @Action(input = "http://services.choreos.org/InStoreTotem/setInvocationAddressRequest", output = "http://services.choreos.org/InStoreTotem/setInvocationAddressResponse")
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
    @Action(input = "http://services.choreos.org/InStoreTotem/setEndpointAddressRequest", output = "http://services.choreos.org/InStoreTotem/setEndpointAddressResponse")
    public void setEndpointAddress(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
