
package org.choreos.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


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

    public ObjectFactory() {
    }

    public RequestPublicOffer createRequestPublicOffer() {
        return new RequestPublicOffer();
    }

    public ScenarioException createScenarioException() {
        return new ScenarioException();
    }

    public RequestPrivateOfferResponse createRequestPrivateOfferResponse() {
        return new RequestPrivateOfferResponse();
    }

    public ScenarioSetup createScenarioSetup() {
        return new ScenarioSetup();
    }

    public PutEstimationReqResponse createPutEstimationReqResponse() {
        return new PutEstimationReqResponse();
    }

    public SetEndpointAddress createSetEndpointAddress() {
        return new SetEndpointAddress();
    }

    public RequestPublicOfferResponse createRequestPublicOfferResponse() {
        return new RequestPublicOfferResponse();
    }

    public SetInvocationAddressResponse createSetInvocationAddressResponse() {
        return new SetInvocationAddressResponse();
    }

    public RequestPrivateOffer createRequestPrivateOffer() {
        return new RequestPrivateOffer();
    }

    public ScenarioSetupResponse createScenarioSetupResponse() {
        return new ScenarioSetupResponse();
    }

    public SetInvocationAddress createSetInvocationAddress() {
        return new SetInvocationAddress();
    }

    public SetEndpointAddressResponse createSetEndpointAddressResponse() {
        return new SetEndpointAddressResponse();
    }

    public PutEstimationReq createPutEstimationReq() {
        return new PutEstimationReq();
    }

    public Product createProduct() {
        return new Product();
    }

    public EstimationNeedAlert createEstimationNeedAlert() {
        return new EstimationNeedAlert();
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "requestPublicOffer")
    public JAXBElement<RequestPublicOffer> createRequestPublicOffer(RequestPublicOffer value) {
        return new JAXBElement<RequestPublicOffer>(_RequestPublicOffer_QNAME, RequestPublicOffer.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "scenarioSetup")
    public JAXBElement<ScenarioSetup> createScenarioSetup(ScenarioSetup value) {
        return new JAXBElement<ScenarioSetup>(_ScenarioSetup_QNAME, ScenarioSetup.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "requestPrivateOfferResponse")
    public JAXBElement<RequestPrivateOfferResponse> createRequestPrivateOfferResponse(RequestPrivateOfferResponse value) {
        return new JAXBElement<RequestPrivateOfferResponse>(_RequestPrivateOfferResponse_QNAME, RequestPrivateOfferResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "ScenarioException")
    public JAXBElement<ScenarioException> createScenarioException(ScenarioException value) {
        return new JAXBElement<ScenarioException>(_ScenarioException_QNAME, ScenarioException.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setInvocationAddressResponse")
    public JAXBElement<SetInvocationAddressResponse> createSetInvocationAddressResponse(SetInvocationAddressResponse value) {
        return new JAXBElement<SetInvocationAddressResponse>(_SetInvocationAddressResponse_QNAME, SetInvocationAddressResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "putEstimationReqResponse")
    public JAXBElement<PutEstimationReqResponse> createPutEstimationReqResponse(PutEstimationReqResponse value) {
        return new JAXBElement<PutEstimationReqResponse>(_PutEstimationReqResponse_QNAME, PutEstimationReqResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "requestPrivateOffer")
    public JAXBElement<RequestPrivateOffer> createRequestPrivateOffer(RequestPrivateOffer value) {
        return new JAXBElement<RequestPrivateOffer>(_RequestPrivateOffer_QNAME, RequestPrivateOffer.class, null, value);
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

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setEndpointAddressResponse")
    public JAXBElement<SetEndpointAddressResponse> createSetEndpointAddressResponse(SetEndpointAddressResponse value) {
        return new JAXBElement<SetEndpointAddressResponse>(_SetEndpointAddressResponse_QNAME, SetEndpointAddressResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "putEstimationReq")
    public JAXBElement<PutEstimationReq> createPutEstimationReq(PutEstimationReq value) {
        return new JAXBElement<PutEstimationReq>(_PutEstimationReq_QNAME, PutEstimationReq.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "requestPublicOfferResponse")
    public JAXBElement<RequestPublicOfferResponse> createRequestPublicOfferResponse(RequestPublicOfferResponse value) {
        return new JAXBElement<RequestPublicOfferResponse>(_RequestPublicOfferResponse_QNAME, RequestPublicOfferResponse.class, null, value);
    }

}
