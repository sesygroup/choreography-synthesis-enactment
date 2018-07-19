
package org.choreos.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _BcdReceiveSmsResponse_QNAME = new QName("http://services.choreos.org/", "bcd_receive_smsResponse");
    private final static QName _BcdReceiveSms_QNAME = new QName("http://services.choreos.org/", "bcd_receive_sms");
    private final static QName _ScenarioException_QNAME = new QName("http://services.choreos.org/", "ScenarioException");
    private final static QName _BasicCommDeviceSubscribeResponse_QNAME = new QName("http://services.choreos.org/", "basicCommDeviceSubscribeResponse");
    private final static QName _ScenarioSetup_QNAME = new QName("http://services.choreos.org/", "scenarioSetup");
    private final static QName _BasicCommDeviceSubscribe_QNAME = new QName("http://services.choreos.org/", "basicCommDeviceSubscribe");
    private final static QName _SetInvocationAddressResponse_QNAME = new QName("http://services.choreos.org/", "setInvocationAddressResponse");
    private final static QName _SetEndpointAddress_QNAME = new QName("http://services.choreos.org/", "setEndpointAddress");
    private final static QName _BasicCommDeviceUnsubscribe_QNAME = new QName("http://services.choreos.org/", "basicCommDeviceUnsubscribe");
    private final static QName _ScenarioSetupResponse_QNAME = new QName("http://services.choreos.org/", "scenarioSetupResponse");
    private final static QName _SetInvocationAddress_QNAME = new QName("http://services.choreos.org/", "setInvocationAddress");
    private final static QName _SetEndpointAddressResponse_QNAME = new QName("http://services.choreos.org/", "setEndpointAddressResponse");
    private final static QName _BasicCommDeviceUnsubscribeResponse_QNAME = new QName("http://services.choreos.org/", "basicCommDeviceUnsubscribeResponse");

    public ObjectFactory() {
    }

    public BcdReceiveSmsResponse createBcdReceiveSmsResponse() {
        return new BcdReceiveSmsResponse();
    }

    public BcdReceiveSms createBcdReceiveSms() {
        return new BcdReceiveSms();
    }

    public ScenarioSetup createScenarioSetup() {
        return new ScenarioSetup();
    }

    public BasicCommDeviceSubscribeResponse createBasicCommDeviceSubscribeResponse() {
        return new BasicCommDeviceSubscribeResponse();
    }

    public ScenarioException createScenarioException() {
        return new ScenarioException();
    }

    public BasicCommDeviceSubscribe createBasicCommDeviceSubscribe() {
        return new BasicCommDeviceSubscribe();
    }

    public SetInvocationAddressResponse createSetInvocationAddressResponse() {
        return new SetInvocationAddressResponse();
    }

    public SetEndpointAddress createSetEndpointAddress() {
        return new SetEndpointAddress();
    }

    public ScenarioSetupResponse createScenarioSetupResponse() {
        return new ScenarioSetupResponse();
    }

    public BasicCommDeviceUnsubscribe createBasicCommDeviceUnsubscribe() {
        return new BasicCommDeviceUnsubscribe();
    }

    public SetInvocationAddress createSetInvocationAddress() {
        return new SetInvocationAddress();
    }

    public SetEndpointAddressResponse createSetEndpointAddressResponse() {
        return new SetEndpointAddressResponse();
    }

    public BasicCommDeviceUnsubscribeResponse createBasicCommDeviceUnsubscribeResponse() {
        return new BasicCommDeviceUnsubscribeResponse();
    }

    public SMSMessage createSMSMessage() {
        return new SMSMessage();
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "bcd_receive_smsResponse")
    public JAXBElement<BcdReceiveSmsResponse> createBcdReceiveSmsResponse(BcdReceiveSmsResponse value) {
        return new JAXBElement<BcdReceiveSmsResponse>(_BcdReceiveSmsResponse_QNAME, BcdReceiveSmsResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "bcd_receive_sms")
    public JAXBElement<BcdReceiveSms> createBcdReceiveSms(BcdReceiveSms value) {
        return new JAXBElement<BcdReceiveSms>(_BcdReceiveSms_QNAME, BcdReceiveSms.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "ScenarioException")
    public JAXBElement<ScenarioException> createScenarioException(ScenarioException value) {
        return new JAXBElement<ScenarioException>(_ScenarioException_QNAME, ScenarioException.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "basicCommDeviceSubscribeResponse")
    public JAXBElement<BasicCommDeviceSubscribeResponse> createBasicCommDeviceSubscribeResponse(BasicCommDeviceSubscribeResponse value) {
        return new JAXBElement<BasicCommDeviceSubscribeResponse>(_BasicCommDeviceSubscribeResponse_QNAME, BasicCommDeviceSubscribeResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "scenarioSetup")
    public JAXBElement<ScenarioSetup> createScenarioSetup(ScenarioSetup value) {
        return new JAXBElement<ScenarioSetup>(_ScenarioSetup_QNAME, ScenarioSetup.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "basicCommDeviceSubscribe")
    public JAXBElement<BasicCommDeviceSubscribe> createBasicCommDeviceSubscribe(BasicCommDeviceSubscribe value) {
        return new JAXBElement<BasicCommDeviceSubscribe>(_BasicCommDeviceSubscribe_QNAME, BasicCommDeviceSubscribe.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setInvocationAddressResponse")
    public JAXBElement<SetInvocationAddressResponse> createSetInvocationAddressResponse(SetInvocationAddressResponse value) {
        return new JAXBElement<SetInvocationAddressResponse>(_SetInvocationAddressResponse_QNAME, SetInvocationAddressResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setEndpointAddress")
    public JAXBElement<SetEndpointAddress> createSetEndpointAddress(SetEndpointAddress value) {
        return new JAXBElement<SetEndpointAddress>(_SetEndpointAddress_QNAME, SetEndpointAddress.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "basicCommDeviceUnsubscribe")
    public JAXBElement<BasicCommDeviceUnsubscribe> createBasicCommDeviceUnsubscribe(BasicCommDeviceUnsubscribe value) {
        return new JAXBElement<BasicCommDeviceUnsubscribe>(_BasicCommDeviceUnsubscribe_QNAME, BasicCommDeviceUnsubscribe.class, null, value);
    }


    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "scenarioSetupResponse")
    public JAXBElement<ScenarioSetupResponse> createScenarioSetupResponse(ScenarioSetupResponse value) {
        return new JAXBElement<ScenarioSetupResponse>(_ScenarioSetupResponse_QNAME, ScenarioSetupResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setInvocationAddress")
    public JAXBElement<SetInvocationAddress> createSetInvocationAddress(SetInvocationAddress value) {
        return new JAXBElement<SetInvocationAddress>(_SetInvocationAddress_QNAME, SetInvocationAddress.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setEndpointAddressResponse")
    public JAXBElement<SetEndpointAddressResponse> createSetEndpointAddressResponse(SetEndpointAddressResponse value) {
        return new JAXBElement<SetEndpointAddressResponse>(_SetEndpointAddressResponse_QNAME, SetEndpointAddressResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "basicCommDeviceUnsubscribeResponse")
    public JAXBElement<BasicCommDeviceUnsubscribeResponse> createBasicCommDeviceUnsubscribeResponse(BasicCommDeviceUnsubscribeResponse value) {
        return new JAXBElement<BasicCommDeviceUnsubscribeResponse>(_BasicCommDeviceUnsubscribeResponse_QNAME, BasicCommDeviceUnsubscribeResponse.class, null, value);
    }

}
