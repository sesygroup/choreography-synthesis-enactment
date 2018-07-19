
package org.choreos.services.client.smartcart;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.choreos.services.client.smartcart package. 
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

    private final static QName _ScenarioException_QNAME = new QName("http://services.choreos.org/", "ScenarioException");
    private final static QName _ChangeQtyResponse_QNAME = new QName("http://services.choreos.org/", "change_qtyResponse");
    private final static QName _ScenarioSetup_QNAME = new QName("http://services.choreos.org/", "scenarioSetup");
    private final static QName _RemoveProduct_QNAME = new QName("http://services.choreos.org/", "remove_product");
    private final static QName _ChangeQty_QNAME = new QName("http://services.choreos.org/", "change_qty");
    private final static QName _SetEndpointAddress_QNAME = new QName("http://services.choreos.org/", "setEndpointAddress");
    private final static QName _PayRequired_QNAME = new QName("http://services.choreos.org/", "payRequired");
    private final static QName _PayRequiredResponse_QNAME = new QName("http://services.choreos.org/", "payRequiredResponse");
    private final static QName _IsAvailable_QNAME = new QName("http://services.choreos.org/", "isAvailable");
    private final static QName _IsAvailableResponse_QNAME = new QName("http://services.choreos.org/", "isAvailableResponse");
    private final static QName _AddProductResponse_QNAME = new QName("http://services.choreos.org/", "add_productResponse");
    private final static QName _RemoveProductResponse_QNAME = new QName("http://services.choreos.org/", "remove_productResponse");
    private final static QName _SetInvocationAddressResponse_QNAME = new QName("http://services.choreos.org/", "setInvocationAddressResponse");
    private final static QName _UnsubscribeUserFrom_QNAME = new QName("http://services.choreos.org/", "unsubscribeUserFrom");
    private final static QName _AddProduct_QNAME = new QName("http://services.choreos.org/", "add_product");
    private final static QName _SubscribeUserToCart_QNAME = new QName("http://services.choreos.org/", "subscribeUserToCart");
    private final static QName _SubscribeUserToCartResponse_QNAME = new QName("http://services.choreos.org/", "subscribeUserToCartResponse");
    private final static QName _ScenarioSetupResponse_QNAME = new QName("http://services.choreos.org/", "scenarioSetupResponse");
    private final static QName _SetInvocationAddress_QNAME = new QName("http://services.choreos.org/", "setInvocationAddress");
    private final static QName _SetEndpointAddressResponse_QNAME = new QName("http://services.choreos.org/", "setEndpointAddressResponse");
    private final static QName _UnsubscribeUserFromResponse_QNAME = new QName("http://services.choreos.org/", "unsubscribeUserFromResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.choreos.services.client.smartcart
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ScenarioException }
     * 
     */
    public ScenarioException createScenarioException() {
        return new ScenarioException();
    }

    /**
     * Create an instance of {@link ChangeQtyResponse }
     * 
     */
    public ChangeQtyResponse createChangeQtyResponse() {
        return new ChangeQtyResponse();
    }

    /**
     * Create an instance of {@link ScenarioSetup }
     * 
     */
    public ScenarioSetup createScenarioSetup() {
        return new ScenarioSetup();
    }

    /**
     * Create an instance of {@link RemoveProduct }
     * 
     */
    public RemoveProduct createRemoveProduct() {
        return new RemoveProduct();
    }

    /**
     * Create an instance of {@link ChangeQty }
     * 
     */
    public ChangeQty createChangeQty() {
        return new ChangeQty();
    }

    /**
     * Create an instance of {@link SetEndpointAddress }
     * 
     */
    public SetEndpointAddress createSetEndpointAddress() {
        return new SetEndpointAddress();
    }

    /**
     * Create an instance of {@link PayRequired }
     * 
     */
    public PayRequired createPayRequired() {
        return new PayRequired();
    }

    /**
     * Create an instance of {@link PayRequiredResponse }
     * 
     */
    public PayRequiredResponse createPayRequiredResponse() {
        return new PayRequiredResponse();
    }

    /**
     * Create an instance of {@link IsAvailable }
     * 
     */
    public IsAvailable createIsAvailable() {
        return new IsAvailable();
    }

    /**
     * Create an instance of {@link IsAvailableResponse }
     * 
     */
    public IsAvailableResponse createIsAvailableResponse() {
        return new IsAvailableResponse();
    }

    /**
     * Create an instance of {@link AddProductResponse }
     * 
     */
    public AddProductResponse createAddProductResponse() {
        return new AddProductResponse();
    }

    /**
     * Create an instance of {@link RemoveProductResponse }
     * 
     */
    public RemoveProductResponse createRemoveProductResponse() {
        return new RemoveProductResponse();
    }

    /**
     * Create an instance of {@link UnsubscribeUserFrom }
     * 
     */
    public UnsubscribeUserFrom createUnsubscribeUserFrom() {
        return new UnsubscribeUserFrom();
    }

    /**
     * Create an instance of {@link SetInvocationAddressResponse }
     * 
     */
    public SetInvocationAddressResponse createSetInvocationAddressResponse() {
        return new SetInvocationAddressResponse();
    }

    /**
     * Create an instance of {@link SubscribeUserToCartResponse }
     * 
     */
    public SubscribeUserToCartResponse createSubscribeUserToCartResponse() {
        return new SubscribeUserToCartResponse();
    }

    /**
     * Create an instance of {@link SubscribeUserToCart }
     * 
     */
    public SubscribeUserToCart createSubscribeUserToCart() {
        return new SubscribeUserToCart();
    }

    /**
     * Create an instance of {@link AddProduct }
     * 
     */
    public AddProduct createAddProduct() {
        return new AddProduct();
    }

    /**
     * Create an instance of {@link ScenarioSetupResponse }
     * 
     */
    public ScenarioSetupResponse createScenarioSetupResponse() {
        return new ScenarioSetupResponse();
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
     * Create an instance of {@link UnsubscribeUserFromResponse }
     * 
     */
    public UnsubscribeUserFromResponse createUnsubscribeUserFromResponse() {
        return new UnsubscribeUserFromResponse();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeQtyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "change_qtyResponse")
    public JAXBElement<ChangeQtyResponse> createChangeQtyResponse(ChangeQtyResponse value) {
        return new JAXBElement<ChangeQtyResponse>(_ChangeQtyResponse_QNAME, ChangeQtyResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "remove_product")
    public JAXBElement<RemoveProduct> createRemoveProduct(RemoveProduct value) {
        return new JAXBElement<RemoveProduct>(_RemoveProduct_QNAME, RemoveProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeQty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "change_qty")
    public JAXBElement<ChangeQty> createChangeQty(ChangeQty value) {
        return new JAXBElement<ChangeQty>(_ChangeQty_QNAME, ChangeQty.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PayRequired }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "payRequired")
    public JAXBElement<PayRequired> createPayRequired(PayRequired value) {
        return new JAXBElement<PayRequired>(_PayRequired_QNAME, PayRequired.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayRequiredResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "payRequiredResponse")
    public JAXBElement<PayRequiredResponse> createPayRequiredResponse(PayRequiredResponse value) {
        return new JAXBElement<PayRequiredResponse>(_PayRequiredResponse_QNAME, PayRequiredResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsAvailable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "isAvailable")
    public JAXBElement<IsAvailable> createIsAvailable(IsAvailable value) {
        return new JAXBElement<IsAvailable>(_IsAvailable_QNAME, IsAvailable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsAvailableResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "isAvailableResponse")
    public JAXBElement<IsAvailableResponse> createIsAvailableResponse(IsAvailableResponse value) {
        return new JAXBElement<IsAvailableResponse>(_IsAvailableResponse_QNAME, IsAvailableResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "add_productResponse")
    public JAXBElement<AddProductResponse> createAddProductResponse(AddProductResponse value) {
        return new JAXBElement<AddProductResponse>(_AddProductResponse_QNAME, AddProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "remove_productResponse")
    public JAXBElement<RemoveProductResponse> createRemoveProductResponse(RemoveProductResponse value) {
        return new JAXBElement<RemoveProductResponse>(_RemoveProductResponse_QNAME, RemoveProductResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UnsubscribeUserFrom }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "unsubscribeUserFrom")
    public JAXBElement<UnsubscribeUserFrom> createUnsubscribeUserFrom(UnsubscribeUserFrom value) {
        return new JAXBElement<UnsubscribeUserFrom>(_UnsubscribeUserFrom_QNAME, UnsubscribeUserFrom.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "add_product")
    public JAXBElement<AddProduct> createAddProduct(AddProduct value) {
        return new JAXBElement<AddProduct>(_AddProduct_QNAME, AddProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscribeUserToCart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "subscribeUserToCart")
    public JAXBElement<SubscribeUserToCart> createSubscribeUserToCart(SubscribeUserToCart value) {
        return new JAXBElement<SubscribeUserToCart>(_SubscribeUserToCart_QNAME, SubscribeUserToCart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscribeUserToCartResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "subscribeUserToCartResponse")
    public JAXBElement<SubscribeUserToCartResponse> createSubscribeUserToCartResponse(SubscribeUserToCartResponse value) {
        return new JAXBElement<SubscribeUserToCartResponse>(_SubscribeUserToCartResponse_QNAME, SubscribeUserToCartResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UnsubscribeUserFromResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "unsubscribeUserFromResponse")
    public JAXBElement<UnsubscribeUserFromResponse> createUnsubscribeUserFromResponse(UnsubscribeUserFromResponse value) {
        return new JAXBElement<UnsubscribeUserFromResponse>(_UnsubscribeUserFromResponse_QNAME, UnsubscribeUserFromResponse.class, null, value);
    }

}
