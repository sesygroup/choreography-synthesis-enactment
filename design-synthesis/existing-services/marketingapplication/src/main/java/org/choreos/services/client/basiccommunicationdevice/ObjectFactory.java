
package org.choreos.services.client.basiccommunicationdevice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.choreos.services.client.basiccommunicationdevice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
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

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.choreos.services.client.basiccommunicationdevice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BcdReceiveSmsResponse }
     * 
     */
    public BcdReceiveSmsResponse createBcdReceiveSmsResponse() {
        return new BcdReceiveSmsResponse();
    }

    /**
     * Create an instance of {@link BcdReceiveSms }
     * 
     */
    public BcdReceiveSms createBcdReceiveSms() {
        return new BcdReceiveSms();
    }

    /**
     * Create an instance of {@link ScenarioSetup }
     * 
     */
    public ScenarioSetup createScenarioSetup() {
        return new ScenarioSetup();
    }

    /**
     * Create an instance of {@link BasicCommDeviceSubscribeResponse }
     * 
     */
    public BasicCommDeviceSubscribeResponse createBasicCommDeviceSubscribeResponse() {
        return new BasicCommDeviceSubscribeResponse();
    }

    /**
     * Create an instance of {@link ScenarioException }
     * 
     */
    public ScenarioException createScenarioException() {
        return new ScenarioException();
    }

    /**
     * Create an instance of {@link BasicCommDeviceSubscribe }
     * 
     */
    public BasicCommDeviceSubscribe createBasicCommDeviceSubscribe() {
        return new BasicCommDeviceSubscribe();
    }

    /**
     * Create an instance of {@link SetInvocationAddressResponse }
     * 
     */
    public SetInvocationAddressResponse createSetInvocationAddressResponse() {
        return new SetInvocationAddressResponse();
    }

    /**
     * Create an instance of {@link SetEndpointAddress }
     * 
     */
    public SetEndpointAddress createSetEndpointAddress() {
        return new SetEndpointAddress();
    }

    /**
     * Create an instance of {@link ScenarioSetupResponse }
     * 
     */
    public ScenarioSetupResponse createScenarioSetupResponse() {
        return new ScenarioSetupResponse();
    }

    /**
     * Create an instance of {@link BasicCommDeviceUnsubscribe }
     * 
     */
    public BasicCommDeviceUnsubscribe createBasicCommDeviceUnsubscribe() {
        return new BasicCommDeviceUnsubscribe();
    }

    /**
     * Create an instance of {@link SetInvocationAddress }
     * 
     */
    public SetInvocationAddress createSetInvocationAddress() {
        return new SetInvocationAddress();
    }

    /**
     * Create an instance of {@link SetEndpointAddressResponse }
     * 
     */
    public SetEndpointAddressResponse createSetEndpointAddressResponse() {
        return new SetEndpointAddressResponse();
    }

    /**
     * Create an instance of {@link BasicCommDeviceUnsubscribeResponse }
     * 
     */
    public BasicCommDeviceUnsubscribeResponse createBasicCommDeviceUnsubscribeResponse() {
        return new BasicCommDeviceUnsubscribeResponse();
    }

    /**
     * Create an instance of {@link SMSMessage }
     * 
     */
    public SMSMessage createSMSMessage() {
        return new SMSMessage();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BcdReceiveSmsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "bcd_receive_smsResponse")
    public JAXBElement<BcdReceiveSmsResponse> createBcdReceiveSmsResponse(BcdReceiveSmsResponse value) {
        return new JAXBElement<BcdReceiveSmsResponse>(_BcdReceiveSmsResponse_QNAME, BcdReceiveSmsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BcdReceiveSms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "bcd_receive_sms")
    public JAXBElement<BcdReceiveSms> createBcdReceiveSms(BcdReceiveSms value) {
        return new JAXBElement<BcdReceiveSms>(_BcdReceiveSms_QNAME, BcdReceiveSms.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScenarioException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "ScenarioException")
    public JAXBElement<ScenarioException> createScenarioException(ScenarioException value) {
        return new JAXBElement<ScenarioException>(_ScenarioException_QNAME, ScenarioException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicCommDeviceSubscribeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "basicCommDeviceSubscribeResponse")
    public JAXBElement<BasicCommDeviceSubscribeResponse> createBasicCommDeviceSubscribeResponse(BasicCommDeviceSubscribeResponse value) {
        return new JAXBElement<BasicCommDeviceSubscribeResponse>(_BasicCommDeviceSubscribeResponse_QNAME, BasicCommDeviceSubscribeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScenarioSetup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "scenarioSetup")
    public JAXBElement<ScenarioSetup> createScenarioSetup(ScenarioSetup value) {
        return new JAXBElement<ScenarioSetup>(_ScenarioSetup_QNAME, ScenarioSetup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicCommDeviceSubscribe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "basicCommDeviceSubscribe")
    public JAXBElement<BasicCommDeviceSubscribe> createBasicCommDeviceSubscribe(BasicCommDeviceSubscribe value) {
        return new JAXBElement<BasicCommDeviceSubscribe>(_BasicCommDeviceSubscribe_QNAME, BasicCommDeviceSubscribe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetInvocationAddressResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setInvocationAddressResponse")
    public JAXBElement<SetInvocationAddressResponse> createSetInvocationAddressResponse(SetInvocationAddressResponse value) {
        return new JAXBElement<SetInvocationAddressResponse>(_SetInvocationAddressResponse_QNAME, SetInvocationAddressResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetEndpointAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setEndpointAddress")
    public JAXBElement<SetEndpointAddress> createSetEndpointAddress(SetEndpointAddress value) {
        return new JAXBElement<SetEndpointAddress>(_SetEndpointAddress_QNAME, SetEndpointAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicCommDeviceUnsubscribe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "basicCommDeviceUnsubscribe")
    public JAXBElement<BasicCommDeviceUnsubscribe> createBasicCommDeviceUnsubscribe(BasicCommDeviceUnsubscribe value) {
        return new JAXBElement<BasicCommDeviceUnsubscribe>(_BasicCommDeviceUnsubscribe_QNAME, BasicCommDeviceUnsubscribe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScenarioSetupResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "scenarioSetupResponse")
    public JAXBElement<ScenarioSetupResponse> createScenarioSetupResponse(ScenarioSetupResponse value) {
        return new JAXBElement<ScenarioSetupResponse>(_ScenarioSetupResponse_QNAME, ScenarioSetupResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetInvocationAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setInvocationAddress")
    public JAXBElement<SetInvocationAddress> createSetInvocationAddress(SetInvocationAddress value) {
        return new JAXBElement<SetInvocationAddress>(_SetInvocationAddress_QNAME, SetInvocationAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetEndpointAddressResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setEndpointAddressResponse")
    public JAXBElement<SetEndpointAddressResponse> createSetEndpointAddressResponse(SetEndpointAddressResponse value) {
        return new JAXBElement<SetEndpointAddressResponse>(_SetEndpointAddressResponse_QNAME, SetEndpointAddressResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasicCommDeviceUnsubscribeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "basicCommDeviceUnsubscribeResponse")
    public JAXBElement<BasicCommDeviceUnsubscribeResponse> createBasicCommDeviceUnsubscribeResponse(BasicCommDeviceUnsubscribeResponse value) {
        return new JAXBElement<BasicCommDeviceUnsubscribeResponse>(_BasicCommDeviceUnsubscribeResponse_QNAME, BasicCommDeviceUnsubscribeResponse.class, null, value);
    }

}
