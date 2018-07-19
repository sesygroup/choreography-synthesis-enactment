
package org.choreos.services.cd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.choreos.services.cd package. 
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

    private final static QName _RequestPublicOffer_QNAME = new QName("http://services.choreos.org/", "requestPublicOffer");
    private final static QName _ScenarioSetup_QNAME = new QName("http://services.choreos.org/", "scenarioSetup");
    private final static QName _RequestPrivateOfferResponse_QNAME = new QName("http://services.choreos.org/", "requestPrivateOfferResponse");
    private final static QName _ScenarioException_QNAME = new QName("http://services.choreos.org/", "ScenarioException");
    private final static QName _SetInvocationAddressResponse_QNAME = new QName("http://services.choreos.org/", "setInvocationAddressResponse");
    private final static QName _PutEstimationReqResponse_QNAME = new QName("http://services.choreos.org/", "putEstimationReqResponse");
    private final static QName _RequestPrivateOffer_QNAME = new QName("http://services.choreos.org/", "requestPrivateOffer");
    private final static QName _SetEndpointAddress_QNAME = new QName("http://services.choreos.org/", "setEndpointAddress");
    private final static QName _ScenarioSetupResponse_QNAME = new QName("http://services.choreos.org/", "scenarioSetupResponse");
    private final static QName _SetInvocationAddress_QNAME = new QName("http://services.choreos.org/", "setInvocationAddress");
    private final static QName _SetEndpointAddressResponse_QNAME = new QName("http://services.choreos.org/", "setEndpointAddressResponse");
    private final static QName _PutEstimationReq_QNAME = new QName("http://services.choreos.org/", "putEstimationReq");
    private final static QName _RequestPublicOfferResponse_QNAME = new QName("http://services.choreos.org/", "requestPublicOfferResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.choreos.services.cd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequestPublicOffer }
     * 
     */
    public RequestPublicOffer createRequestPublicOffer() {
        return new RequestPublicOffer();
    }

    /**
     * Create an instance of {@link ScenarioException }
     * 
     */
    public ScenarioException createScenarioException() {
        return new ScenarioException();
    }

    /**
     * Create an instance of {@link RequestPrivateOfferResponse }
     * 
     */
    public RequestPrivateOfferResponse createRequestPrivateOfferResponse() {
        return new RequestPrivateOfferResponse();
    }

    /**
     * Create an instance of {@link ScenarioSetup }
     * 
     */
    public ScenarioSetup createScenarioSetup() {
        return new ScenarioSetup();
    }

    /**
     * Create an instance of {@link PutEstimationReqResponse }
     * 
     */
    public PutEstimationReqResponse createPutEstimationReqResponse() {
        return new PutEstimationReqResponse();
    }

    /**
     * Create an instance of {@link SetEndpointAddress }
     * 
     */
    public SetEndpointAddress createSetEndpointAddress() {
        return new SetEndpointAddress();
    }

    /**
     * Create an instance of {@link RequestPublicOfferResponse }
     * 
     */
    public RequestPublicOfferResponse createRequestPublicOfferResponse() {
        return new RequestPublicOfferResponse();
    }

    /**
     * Create an instance of {@link SetInvocationAddressResponse }
     * 
     */
    public SetInvocationAddressResponse createSetInvocationAddressResponse() {
        return new SetInvocationAddressResponse();
    }

    /**
     * Create an instance of {@link RequestPrivateOffer }
     * 
     */
    public RequestPrivateOffer createRequestPrivateOffer() {
        return new RequestPrivateOffer();
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
     * Create an instance of {@link PutEstimationReq }
     * 
     */
    public PutEstimationReq createPutEstimationReq() {
        return new PutEstimationReq();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link EstimationNeedAlert }
     * 
     */
    public EstimationNeedAlert createEstimationNeedAlert() {
        return new EstimationNeedAlert();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestPublicOffer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "requestPublicOffer")
    public JAXBElement<RequestPublicOffer> createRequestPublicOffer(RequestPublicOffer value) {
        return new JAXBElement<RequestPublicOffer>(_RequestPublicOffer_QNAME, RequestPublicOffer.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestPrivateOfferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "requestPrivateOfferResponse")
    public JAXBElement<RequestPrivateOfferResponse> createRequestPrivateOfferResponse(RequestPrivateOfferResponse value) {
        return new JAXBElement<RequestPrivateOfferResponse>(_RequestPrivateOfferResponse_QNAME, RequestPrivateOfferResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SetInvocationAddressResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setInvocationAddressResponse")
    public JAXBElement<SetInvocationAddressResponse> createSetInvocationAddressResponse(SetInvocationAddressResponse value) {
        return new JAXBElement<SetInvocationAddressResponse>(_SetInvocationAddressResponse_QNAME, SetInvocationAddressResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutEstimationReqResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "putEstimationReqResponse")
    public JAXBElement<PutEstimationReqResponse> createPutEstimationReqResponse(PutEstimationReqResponse value) {
        return new JAXBElement<PutEstimationReqResponse>(_PutEstimationReqResponse_QNAME, PutEstimationReqResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestPrivateOffer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "requestPrivateOffer")
    public JAXBElement<RequestPrivateOffer> createRequestPrivateOffer(RequestPrivateOffer value) {
        return new JAXBElement<RequestPrivateOffer>(_RequestPrivateOffer_QNAME, RequestPrivateOffer.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PutEstimationReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "putEstimationReq")
    public JAXBElement<PutEstimationReq> createPutEstimationReq(PutEstimationReq value) {
        return new JAXBElement<PutEstimationReq>(_PutEstimationReq_QNAME, PutEstimationReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestPublicOfferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "requestPublicOfferResponse")
    public JAXBElement<RequestPublicOfferResponse> createRequestPublicOfferResponse(RequestPublicOfferResponse value) {
        return new JAXBElement<RequestPublicOfferResponse>(_RequestPublicOfferResponse_QNAME, RequestPublicOfferResponse.class, null, value);
    }

}
