package org.choreos.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _CheckInAndAssignCartResponse_QNAME = new QName("http://services.choreos.org/", "check_in_and_assign_cartResponse");
    private final static QName _Register_QNAME = new QName("http://services.choreos.org/", "register");
    private final static QName _CheckInAndAssignCart_QNAME = new QName("http://services.choreos.org/", "check_in_and_assign_cart");
    private final static QName _ScenarioException_QNAME = new QName("http://services.choreos.org/", "ScenarioException");
    private final static QName _ScenarioSetup_QNAME = new QName("http://services.choreos.org/", "scenarioSetup");
    private final static QName _SetInvocationAddressResponse_QNAME = new QName("http://services.choreos.org/", "setInvocationAddressResponse");
    private final static QName _SetEndpointAddress_QNAME = new QName("http://services.choreos.org/", "setEndpointAddress");
    private final static QName _ScenarioSetupResponse_QNAME = new QName("http://services.choreos.org/", "scenarioSetupResponse");
    private final static QName _SetInvocationAddress_QNAME = new QName("http://services.choreos.org/", "setInvocationAddress");
    private final static QName _RegisterResponse_QNAME = new QName("http://services.choreos.org/", "registerResponse");
    private final static QName _SetEndpointAddressResponse_QNAME = new QName("http://services.choreos.org/", "setEndpointAddressResponse");

    public ObjectFactory() {
    }

    public Register createRegister() {
        return new Register();
    }

    public CheckInAndAssignCartResponse createCheckInAndAssignCartResponse() {
        return new CheckInAndAssignCartResponse();
    }

    public CheckInAndAssignCart createCheckInAndAssignCart() {
        return new CheckInAndAssignCart();
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

    public SetInvocationAddress createSetInvocationAddress() {
        return new SetInvocationAddress();
    }

    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    public SetEndpointAddressResponse createSetEndpointAddressResponse() {
        return new SetEndpointAddressResponse();
    }

    public Product createProduct() {
        return new Product();
    }

    public ShoppingListEntry createShoppingListEntry() {
        return new ShoppingListEntry();
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "check_in_and_assign_cartResponse")
    public JAXBElement<CheckInAndAssignCartResponse> createCheckInAndAssignCartResponse(CheckInAndAssignCartResponse value) {
        return new JAXBElement<CheckInAndAssignCartResponse>(_CheckInAndAssignCartResponse_QNAME, CheckInAndAssignCartResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "register")
    public JAXBElement<Register> createRegister(Register value) {
        return new JAXBElement<Register>(_Register_QNAME, Register.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "check_in_and_assign_cart")
    public JAXBElement<CheckInAndAssignCart> createCheckInAndAssignCart(CheckInAndAssignCart value) {
        return new JAXBElement<CheckInAndAssignCart>(_CheckInAndAssignCart_QNAME, CheckInAndAssignCart.class, null, value);
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

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "scenarioSetupResponse")
    public JAXBElement<ScenarioSetupResponse> createScenarioSetupResponse(ScenarioSetupResponse value) {
        return new JAXBElement<ScenarioSetupResponse>(_ScenarioSetupResponse_QNAME, ScenarioSetupResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setInvocationAddress")
    public JAXBElement<SetInvocationAddress> createSetInvocationAddress(SetInvocationAddress value) {
        return new JAXBElement<SetInvocationAddress>(_SetInvocationAddress_QNAME, SetInvocationAddress.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "registerResponse")
    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<RegisterResponse>(_RegisterResponse_QNAME, RegisterResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setEndpointAddressResponse")
    public JAXBElement<SetEndpointAddressResponse> createSetEndpointAddressResponse(SetEndpointAddressResponse value) {
        return new JAXBElement<SetEndpointAddressResponse>(_SetEndpointAddressResponse_QNAME, SetEndpointAddressResponse.class, null, value);
    }

}
