
package org.choreos.services.enactchoreography.client.selfcheckoutmachine;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.choreos.services.startWP7Choreography.client.selfcheckoutmachine package. 
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

    private final static QName _PayResponse_QNAME = new QName("http://services.choreos.org/", "payResponse");
    private final static QName _ScenarioException_QNAME = new QName("http://services.choreos.org/", "ScenarioException");
    private final static QName _ScenarioSetup_QNAME = new QName("http://services.choreos.org/", "scenarioSetup");
    private final static QName _SetInvocationAddressResponse_QNAME = new QName("http://services.choreos.org/", "setInvocationAddressResponse");
    private final static QName _SetEndpointAddress_QNAME = new QName("http://services.choreos.org/", "setEndpointAddress");
    private final static QName _Pay_QNAME = new QName("http://services.choreos.org/", "pay");
    private final static QName _ScenarioSetupResponse_QNAME = new QName("http://services.choreos.org/", "scenarioSetupResponse");
    private final static QName _SetInvocationAddress_QNAME = new QName("http://services.choreos.org/", "setInvocationAddress");
    private final static QName _Checkout_QNAME = new QName("http://services.choreos.org/", "checkout");
    private final static QName _CheckoutResponse_QNAME = new QName("http://services.choreos.org/", "checkoutResponse");
    private final static QName _SetEndpointAddressResponse_QNAME = new QName("http://services.choreos.org/", "setEndpointAddressResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.choreos.services.startWP7Choreography.client.selfcheckoutmachine
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PayResponse }
     * 
     */
    public PayResponse createPayResponse() {
        return new PayResponse();
    }

    /**
     * Create an instance of {@link ScenarioSetup }
     * 
     */
    public ScenarioSetup createScenarioSetup() {
        return new ScenarioSetup();
    }

    /**
     * Create an instance of {@link ScenarioException }
     * 
     */
    public ScenarioException createScenarioException() {
        return new ScenarioException();
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
     * Create an instance of {@link Pay }
     * 
     */
    public Pay createPay() {
        return new Pay();
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
     * Create an instance of {@link CheckoutResponse }
     * 
     */
    public CheckoutResponse createCheckoutResponse() {
        return new CheckoutResponse();
    }

    /**
     * Create an instance of {@link Checkout }
     * 
     */
    public Checkout createCheckout() {
        return new Checkout();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link ShoppingListEntry }
     * 
     */
    public ShoppingListEntry createShoppingListEntry() {
        return new ShoppingListEntry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "payResponse")
    public JAXBElement<PayResponse> createPayResponse(PayResponse value) {
        return new JAXBElement<PayResponse>(_PayResponse_QNAME, PayResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ScenarioSetup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "scenarioSetup")
    public JAXBElement<ScenarioSetup> createScenarioSetup(ScenarioSetup value) {
        return new JAXBElement<ScenarioSetup>(_ScenarioSetup_QNAME, ScenarioSetup.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Pay }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "pay")
    public JAXBElement<Pay> createPay(Pay value) {
        return new JAXBElement<Pay>(_Pay_QNAME, Pay.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Checkout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "checkout")
    public JAXBElement<Checkout> createCheckout(Checkout value) {
        return new JAXBElement<Checkout>(_Checkout_QNAME, Checkout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "checkoutResponse")
    public JAXBElement<CheckoutResponse> createCheckoutResponse(CheckoutResponse value) {
        return new JAXBElement<CheckoutResponse>(_CheckoutResponse_QNAME, CheckoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetEndpointAddressResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setEndpointAddressResponse")
    public JAXBElement<SetEndpointAddressResponse> createSetEndpointAddressResponse(SetEndpointAddressResponse value) {
        return new JAXBElement<SetEndpointAddressResponse>(_SetEndpointAddressResponse_QNAME, SetEndpointAddressResponse.class, null, value);
    }

}
