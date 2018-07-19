
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


@WebService(name = "BasicCommunicationDevice", targetNamespace = "http://services.choreos.org/")
@XmlSeeAlso({ObjectFactory.class})
public interface BasicCommunicationDevice {


    @WebMethod
    @RequestWrapper(localName = "scenarioSetup", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ScenarioSetup")
    @ResponseWrapper(localName = "scenarioSetupResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.ScenarioSetupResponse")
    @Action(input = "http://services.choreos.org/BasicCommunicationDevice/scenarioSetupRequest", output = "http://services.choreos.org/BasicCommunicationDevice/scenarioSetupResponse")
    public void scenarioSetup();

    @WebMethod
    @RequestWrapper(localName = "basicCommDeviceSubscribe", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.BasicCommDeviceSubscribe")
    @ResponseWrapper(localName = "basicCommDeviceSubscribeResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.BasicCommDeviceSubscribeResponse")
    @Action(input = "http://services.choreos.org/BasicCommunicationDevice/basicCommDeviceSubscribeRequest", output = "http://services.choreos.org/BasicCommunicationDevice/basicCommDeviceSubscribeResponse")
    public void basicCommDeviceSubscribe(
        @WebParam(name = "sessionId", targetNamespace = "")
        String sessionId);

    @WebMethod
    @RequestWrapper(localName = "basicCommDeviceUnsubscribe", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.BasicCommDeviceUnsubscribe")
    @ResponseWrapper(localName = "basicCommDeviceUnsubscribeResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.BasicCommDeviceUnsubscribeResponse")
    @Action(input = "http://services.choreos.org/BasicCommunicationDevice/basicCommDeviceUnsubscribeRequest", output = "http://services.choreos.org/BasicCommunicationDevice/basicCommDeviceUnsubscribeResponse")
    public void basicCommDeviceUnsubscribe(
        @WebParam(name = "sessionId", targetNamespace = "")
        String sessionId);


    @WebMethod(operationName = "bcd_receive_sms")
    @RequestWrapper(localName = "bcd_receive_sms", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.BcdReceiveSms")
    @ResponseWrapper(localName = "bcd_receive_smsResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.BcdReceiveSmsResponse")
    @Action(input = "http://services.choreos.org/BasicCommunicationDevice/bcd_receive_smsRequest", output = "http://services.choreos.org/BasicCommunicationDevice/bcd_receive_smsResponse", fault = {
        @FaultAction(className = ScenarioException_Exception.class, value = "http://services.choreos.org/BasicCommunicationDevice/bcd_receive_sms/Fault/ScenarioException")
    })
    public void bcdReceiveSms(
        @WebParam(name = "sessionId", targetNamespace = "")
        String sessionId,
        @WebParam(name = "msg", targetNamespace = "")
        SMSMessage msg)
        throws ScenarioException_Exception
    ;

    @WebMethod
    @RequestWrapper(localName = "setInvocationAddress", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetInvocationAddress")
    @ResponseWrapper(localName = "setInvocationAddressResponse", targetNamespace = "http://services.choreos.org/", className = "org.choreos.services.SetInvocationAddressResponse")
    @Action(input = "http://services.choreos.org/BasicCommunicationDevice/setInvocationAddressRequest", output = "http://services.choreos.org/BasicCommunicationDevice/setInvocationAddressResponse")
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
    @Action(input = "http://services.choreos.org/BasicCommunicationDevice/setEndpointAddressRequest", output = "http://services.choreos.org/BasicCommunicationDevice/setEndpointAddressResponse")
    public void setEndpointAddress(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
