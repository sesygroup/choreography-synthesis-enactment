package org.choreos.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _ShopAssistAppUnsubscribe_QNAME = new QName("http://services.choreos.org/", "shopAssistAppUnsubscribe");
    private final static QName _ScenarioException_QNAME = new QName("http://services.choreos.org/", "ScenarioException");
    private final static QName _ScenarioSetup_QNAME = new QName("http://services.choreos.org/", "scenarioSetup");
    private final static QName _RemindResponse_QNAME = new QName("http://services.choreos.org/", "remindResponse");
    private final static QName _SetEndpointAddress_QNAME = new QName("http://services.choreos.org/", "setEndpointAddress");
    private final static QName _CommunicateIncentiveResponse_QNAME = new QName("http://services.choreos.org/", "communicate_incentiveResponse");
    private final static QName _CommunicateIncentive_QNAME = new QName("http://services.choreos.org/", "communicate_incentive");
    private final static QName _PrivateOffer_QNAME = new QName("http://services.choreos.org/", "private_offer");
    private final static QName _Remind_QNAME = new QName("http://services.choreos.org/", "remind");
    private final static QName _CommunicateQuestionnaireResponse_QNAME = new QName("http://services.choreos.org/", "communicate_questionnaireResponse");
    private final static QName _CommunicateQuestionnaire_QNAME = new QName("http://services.choreos.org/", "communicate_questionnaire");
    private final static QName _SetInvocationAddressResponse_QNAME = new QName("http://services.choreos.org/", "setInvocationAddressResponse");
    private final static QName _RecordBoughtItemsResponse_QNAME = new QName("http://services.choreos.org/", "record_bought_itemsResponse");
    private final static QName _ShopAssistAppSubscribe_QNAME = new QName("http://services.choreos.org/", "shopAssistAppSubscribe");
    private final static QName _ShopAssistAppUnsubscribeResponse_QNAME = new QName("http://services.choreos.org/", "shopAssistAppUnsubscribeResponse");
    private final static QName _RecordBoughtItems_QNAME = new QName("http://services.choreos.org/", "record_bought_items");
    private final static QName _ScenarioSetupResponse_QNAME = new QName("http://services.choreos.org/", "scenarioSetupResponse");
    private final static QName _SetInvocationAddress_QNAME = new QName("http://services.choreos.org/", "setInvocationAddress");
    private final static QName _PrivateOfferResponse_QNAME = new QName("http://services.choreos.org/", "private_offerResponse");
    private final static QName _SetEndpointAddressResponse_QNAME = new QName("http://services.choreos.org/", "setEndpointAddressResponse");
    private final static QName _ShopAssistAppSubscribeResponse_QNAME = new QName("http://services.choreos.org/", "shopAssistAppSubscribeResponse");

    public ObjectFactory() {
    }

    public Questionnaire createQuestionnaire() {
        return new Questionnaire();
    }

    public Questionnaire.Qa createQuestionnaireQa() {
        return new Questionnaire.Qa();
    }

    public ShopAssistAppUnsubscribe createShopAssistAppUnsubscribe() {
        return new ShopAssistAppUnsubscribe();
    }

    public ScenarioException createScenarioException() {
        return new ScenarioException();
    }

    public ScenarioSetup createScenarioSetup() {
        return new ScenarioSetup();
    }

    public RemindResponse createRemindResponse() {
        return new RemindResponse();
    }

    public SetEndpointAddress createSetEndpointAddress() {
        return new SetEndpointAddress();
    }

    public CommunicateIncentiveResponse createCommunicateIncentiveResponse() {
        return new CommunicateIncentiveResponse();
    }

    public CommunicateIncentive createCommunicateIncentive() {
        return new CommunicateIncentive();
    }

    public PrivateOffer createPrivateOffer() {
        return new PrivateOffer();
    }

    public Remind createRemind() {
        return new Remind();
    }

    public CommunicateQuestionnaireResponse createCommunicateQuestionnaireResponse() {
        return new CommunicateQuestionnaireResponse();
    }

    public CommunicateQuestionnaire createCommunicateQuestionnaire() {
        return new CommunicateQuestionnaire();
    }

    public SetInvocationAddressResponse createSetInvocationAddressResponse() {
        return new SetInvocationAddressResponse();
    }

    public ShopAssistAppUnsubscribeResponse createShopAssistAppUnsubscribeResponse() {
        return new ShopAssistAppUnsubscribeResponse();
    }

    public ShopAssistAppSubscribe createShopAssistAppSubscribe() {
        return new ShopAssistAppSubscribe();
    }

    public RecordBoughtItemsResponse createRecordBoughtItemsResponse() {
        return new RecordBoughtItemsResponse();
    }

    public ScenarioSetupResponse createScenarioSetupResponse() {
        return new ScenarioSetupResponse();
    }

    public RecordBoughtItems createRecordBoughtItems() {
        return new RecordBoughtItems();
    }

    public SetInvocationAddress createSetInvocationAddress() {
        return new SetInvocationAddress();
    }

    public PrivateOfferResponse createPrivateOfferResponse() {
        return new PrivateOfferResponse();
    }

    public SetEndpointAddressResponse createSetEndpointAddressResponse() {
        return new SetEndpointAddressResponse();
    }

    public ShopAssistAppSubscribeResponse createShopAssistAppSubscribeResponse() {
        return new ShopAssistAppSubscribeResponse();
    }

    public Reminder createReminder() {
        return new Reminder();
    }

    public Specialoffer createSpecialoffer() {
        return new Specialoffer();
    }

    public Offer createOffer() {
        return new Offer();
    }

    public Product createProduct() {
        return new Product();
    }

    public Questionnaire.Qa.Entry createQuestionnaireQaEntry() {
        return new Questionnaire.Qa.Entry();
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "shopAssistAppUnsubscribe")
    public JAXBElement<ShopAssistAppUnsubscribe> createShopAssistAppUnsubscribe(ShopAssistAppUnsubscribe value) {
        return new JAXBElement<ShopAssistAppUnsubscribe>(_ShopAssistAppUnsubscribe_QNAME, ShopAssistAppUnsubscribe.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "ScenarioException")
    public JAXBElement<ScenarioException> createScenarioException(ScenarioException value) {
        return new JAXBElement<ScenarioException>(_ScenarioException_QNAME, ScenarioException.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "scenarioSetup")
    public JAXBElement<ScenarioSetup> createScenarioSetup(ScenarioSetup value) {
        return new JAXBElement<ScenarioSetup>(_ScenarioSetup_QNAME, ScenarioSetup.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "remindResponse")
    public JAXBElement<RemindResponse> createRemindResponse(RemindResponse value) {
        return new JAXBElement<RemindResponse>(_RemindResponse_QNAME, RemindResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setEndpointAddress")
    public JAXBElement<SetEndpointAddress> createSetEndpointAddress(SetEndpointAddress value) {
        return new JAXBElement<SetEndpointAddress>(_SetEndpointAddress_QNAME, SetEndpointAddress.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "communicate_incentiveResponse")
    public JAXBElement<CommunicateIncentiveResponse> createCommunicateIncentiveResponse(CommunicateIncentiveResponse value) {
        return new JAXBElement<CommunicateIncentiveResponse>(_CommunicateIncentiveResponse_QNAME, CommunicateIncentiveResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "communicate_incentive")
    public JAXBElement<CommunicateIncentive> createCommunicateIncentive(CommunicateIncentive value) {
        return new JAXBElement<CommunicateIncentive>(_CommunicateIncentive_QNAME, CommunicateIncentive.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "private_offer")
    public JAXBElement<PrivateOffer> createPrivateOffer(PrivateOffer value) {
        return new JAXBElement<PrivateOffer>(_PrivateOffer_QNAME, PrivateOffer.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "remind")
    public JAXBElement<Remind> createRemind(Remind value) {
        return new JAXBElement<Remind>(_Remind_QNAME, Remind.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "communicate_questionnaireResponse")
    public JAXBElement<CommunicateQuestionnaireResponse> createCommunicateQuestionnaireResponse(CommunicateQuestionnaireResponse value) {
        return new JAXBElement<CommunicateQuestionnaireResponse>(_CommunicateQuestionnaireResponse_QNAME, CommunicateQuestionnaireResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "communicate_questionnaire")
    public JAXBElement<CommunicateQuestionnaire> createCommunicateQuestionnaire(CommunicateQuestionnaire value) {
        return new JAXBElement<CommunicateQuestionnaire>(_CommunicateQuestionnaire_QNAME, CommunicateQuestionnaire.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setInvocationAddressResponse")
    public JAXBElement<SetInvocationAddressResponse> createSetInvocationAddressResponse(SetInvocationAddressResponse value) {
        return new JAXBElement<SetInvocationAddressResponse>(_SetInvocationAddressResponse_QNAME, SetInvocationAddressResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "record_bought_itemsResponse")
    public JAXBElement<RecordBoughtItemsResponse> createRecordBoughtItemsResponse(RecordBoughtItemsResponse value) {
        return new JAXBElement<RecordBoughtItemsResponse>(_RecordBoughtItemsResponse_QNAME, RecordBoughtItemsResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "shopAssistAppSubscribe")
    public JAXBElement<ShopAssistAppSubscribe> createShopAssistAppSubscribe(ShopAssistAppSubscribe value) {
        return new JAXBElement<ShopAssistAppSubscribe>(_ShopAssistAppSubscribe_QNAME, ShopAssistAppSubscribe.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "shopAssistAppUnsubscribeResponse")
    public JAXBElement<ShopAssistAppUnsubscribeResponse> createShopAssistAppUnsubscribeResponse(ShopAssistAppUnsubscribeResponse value) {
        return new JAXBElement<ShopAssistAppUnsubscribeResponse>(_ShopAssistAppUnsubscribeResponse_QNAME, ShopAssistAppUnsubscribeResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "record_bought_items")
    public JAXBElement<RecordBoughtItems> createRecordBoughtItems(RecordBoughtItems value) {
        return new JAXBElement<RecordBoughtItems>(_RecordBoughtItems_QNAME, RecordBoughtItems.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "scenarioSetupResponse")
    public JAXBElement<ScenarioSetupResponse> createScenarioSetupResponse(ScenarioSetupResponse value) {
        return new JAXBElement<ScenarioSetupResponse>(_ScenarioSetupResponse_QNAME, ScenarioSetupResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setInvocationAddress")
    public JAXBElement<SetInvocationAddress> createSetInvocationAddress(SetInvocationAddress value) {
        return new JAXBElement<SetInvocationAddress>(_SetInvocationAddress_QNAME, SetInvocationAddress.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "private_offerResponse")
    public JAXBElement<PrivateOfferResponse> createPrivateOfferResponse(PrivateOfferResponse value) {
        return new JAXBElement<PrivateOfferResponse>(_PrivateOfferResponse_QNAME, PrivateOfferResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "setEndpointAddressResponse")
    public JAXBElement<SetEndpointAddressResponse> createSetEndpointAddressResponse(SetEndpointAddressResponse value) {
        return new JAXBElement<SetEndpointAddressResponse>(_SetEndpointAddressResponse_QNAME, SetEndpointAddressResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "shopAssistAppSubscribeResponse")
    public JAXBElement<ShopAssistAppSubscribeResponse> createShopAssistAppSubscribeResponse(ShopAssistAppSubscribeResponse value) {
        return new JAXBElement<ShopAssistAppSubscribeResponse>(_ShopAssistAppSubscribeResponse_QNAME, ShopAssistAppSubscribeResponse.class, null, value);
    }

}
