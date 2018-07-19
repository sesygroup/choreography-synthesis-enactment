package org.choreos.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

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

    public ObjectFactory() {
    }

    public PayResponse createPayResponse() {
        return new PayResponse();
    }

    public ScenarioSetup createScenarioSetup() {
        return new ScenarioSetup();
    }

    public ScenarioException createScenarioException() {
        return new ScenarioException();
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

    public Pay createPay() {
        return new Pay();
    }

    public SetInvocationAddress createSetInvocationAddress() {
        return new SetInvocationAddress();
    }

    public SetEndpointAddressResponse createSetEndpointAddressResponse() {
        return new SetEndpointAddressResponse();
    }

    public CheckoutResponse createCheckoutResponse() {
        return new CheckoutResponse();
    }

    public Checkout createCheckout() {
        return new Checkout();
    }

    public Product createProduct() {
        return new Product();
    }

    public ShoppingListEntry createShoppingListEntry() {
        return new ShoppingListEntry();
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "payResponse")
    public JAXBElement<PayResponse> createPayResponse(PayResponse value) {
        return new JAXBElement<PayResponse>(_PayResponse_QNAME, PayResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "ScenarioException")
    public JAXBElement<ScenarioException> createScenarioException(ScenarioException value) {
        return new JAXBElement<ScenarioException>(_ScenarioException_QNAME, ScenarioException.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "scenarioSetup")
    public JAXBElement<ScenarioSetup> createScenarioSetup(ScenarioSetup value) {
        return new JAXBElement<ScenarioSetup>(_ScenarioSetup_QNAME, ScenarioSetup.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setInvocationAddressResponse")
    public JAXBElement<SetInvocationAddressResponse> createSetInvocationAddressResponse(SetInvocationAddressResponse value) {
        return new JAXBElement<SetInvocationAddressResponse>(_SetInvocationAddressResponse_QNAME, SetInvocationAddressResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setEndpointAddress")
    public JAXBElement<SetEndpointAddress> createSetEndpointAddress(SetEndpointAddress value) {
        return new JAXBElement<SetEndpointAddress>(_SetEndpointAddress_QNAME, SetEndpointAddress.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "pay")
    public JAXBElement<Pay> createPay(Pay value) {
        return new JAXBElement<Pay>(_Pay_QNAME, Pay.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "scenarioSetupResponse")
    public JAXBElement<ScenarioSetupResponse> createScenarioSetupResponse(ScenarioSetupResponse value) {
        return new JAXBElement<ScenarioSetupResponse>(_ScenarioSetupResponse_QNAME, ScenarioSetupResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setInvocationAddress")
    public JAXBElement<SetInvocationAddress> createSetInvocationAddress(SetInvocationAddress value) {
        return new JAXBElement<SetInvocationAddress>(_SetInvocationAddress_QNAME, SetInvocationAddress.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "checkout")
    public JAXBElement<Checkout> createCheckout(Checkout value) {
        return new JAXBElement<Checkout>(_Checkout_QNAME, Checkout.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "checkoutResponse")
    public JAXBElement<CheckoutResponse> createCheckoutResponse(CheckoutResponse value) {
        return new JAXBElement<CheckoutResponse>(_CheckoutResponse_QNAME, CheckoutResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setEndpointAddressResponse")
    public JAXBElement<SetEndpointAddressResponse> createSetEndpointAddressResponse(SetEndpointAddressResponse value) {
        return new JAXBElement<SetEndpointAddressResponse>(_SetEndpointAddressResponse_QNAME, SetEndpointAddressResponse.class, null, value);
    }

}
