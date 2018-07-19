
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

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.choreos.services.cd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Questionnaire }
     * 
     */
    public Questionnaire createQuestionnaire() {
        return new Questionnaire();
    }

    /**
     * Create an instance of {@link Questionnaire.Qa }
     * 
     */
    public Questionnaire.Qa createQuestionnaireQa() {
        return new Questionnaire.Qa();
    }

    /**
     * Create an instance of {@link ShopAssistAppUnsubscribe }
     * 
     */
    public ShopAssistAppUnsubscribe createShopAssistAppUnsubscribe() {
        return new ShopAssistAppUnsubscribe();
    }

    /**
     * Create an instance of {@link ScenarioException }
     * 
     */
    public ScenarioException createScenarioException() {
        return new ScenarioException();
    }

    /**
     * Create an instance of {@link ScenarioSetup }
     * 
     */
    public ScenarioSetup createScenarioSetup() {
        return new ScenarioSetup();
    }

    /**
     * Create an instance of {@link RemindResponse }
     * 
     */
    public RemindResponse createRemindResponse() {
        return new RemindResponse();
    }

    /**
     * Create an instance of {@link SetEndpointAddress }
     * 
     */
    public SetEndpointAddress createSetEndpointAddress() {
        return new SetEndpointAddress();
    }

    /**
     * Create an instance of {@link CommunicateIncentiveResponse }
     * 
     */
    public CommunicateIncentiveResponse createCommunicateIncentiveResponse() {
        return new CommunicateIncentiveResponse();
    }

    /**
     * Create an instance of {@link CommunicateIncentive }
     * 
     */
    public CommunicateIncentive createCommunicateIncentive() {
        return new CommunicateIncentive();
    }

    /**
     * Create an instance of {@link PrivateOffer }
     * 
     */
    public PrivateOffer createPrivateOffer() {
        return new PrivateOffer();
    }

    /**
     * Create an instance of {@link Remind }
     * 
     */
    public Remind createRemind() {
        return new Remind();
    }

    /**
     * Create an instance of {@link CommunicateQuestionnaireResponse }
     * 
     */
    public CommunicateQuestionnaireResponse createCommunicateQuestionnaireResponse() {
        return new CommunicateQuestionnaireResponse();
    }

    /**
     * Create an instance of {@link CommunicateQuestionnaire }
     * 
     */
    public CommunicateQuestionnaire createCommunicateQuestionnaire() {
        return new CommunicateQuestionnaire();
    }

    /**
     * Create an instance of {@link SetInvocationAddressResponse }
     * 
     */
    public SetInvocationAddressResponse createSetInvocationAddressResponse() {
        return new SetInvocationAddressResponse();
    }

    /**
     * Create an instance of {@link ShopAssistAppUnsubscribeResponse }
     * 
     */
    public ShopAssistAppUnsubscribeResponse createShopAssistAppUnsubscribeResponse() {
        return new ShopAssistAppUnsubscribeResponse();
    }

    /**
     * Create an instance of {@link ShopAssistAppSubscribe }
     * 
     */
    public ShopAssistAppSubscribe createShopAssistAppSubscribe() {
        return new ShopAssistAppSubscribe();
    }

    /**
     * Create an instance of {@link RecordBoughtItemsResponse }
     * 
     */
    public RecordBoughtItemsResponse createRecordBoughtItemsResponse() {
        return new RecordBoughtItemsResponse();
    }

    /**
     * Create an instance of {@link ScenarioSetupResponse }
     * 
     */
    public ScenarioSetupResponse createScenarioSetupResponse() {
        return new ScenarioSetupResponse();
    }

    /**
     * Create an instance of {@link RecordBoughtItems }
     * 
     */
    public RecordBoughtItems createRecordBoughtItems() {
        return new RecordBoughtItems();
    }

    /**
     * Create an instance of {@link SetInvocationAddress }
     * 
     */
    public SetInvocationAddress createSetInvocationAddress() {
        return new SetInvocationAddress();
    }

    /**
     * Create an instance of {@link PrivateOfferResponse }
     * 
     */
    public PrivateOfferResponse createPrivateOfferResponse() {
        return new PrivateOfferResponse();
    }

    /**
     * Create an instance of {@link SetEndpointAddressResponse }
     * 
     */
    public SetEndpointAddressResponse createSetEndpointAddressResponse() {
        return new SetEndpointAddressResponse();
    }

    /**
     * Create an instance of {@link ShopAssistAppSubscribeResponse }
     * 
     */
    public ShopAssistAppSubscribeResponse createShopAssistAppSubscribeResponse() {
        return new ShopAssistAppSubscribeResponse();
    }

    /**
     * Create an instance of {@link Reminder }
     * 
     */
    public Reminder createReminder() {
        return new Reminder();
    }

    /**
     * Create an instance of {@link Specialoffer }
     * 
     */
    public Specialoffer createSpecialoffer() {
        return new Specialoffer();
    }

    /**
     * Create an instance of {@link Offer }
     * 
     */
    public Offer createOffer() {
        return new Offer();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link Questionnaire.Qa.Entry }
     * 
     */
    public Questionnaire.Qa.Entry createQuestionnaireQaEntry() {
        return new Questionnaire.Qa.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShopAssistAppUnsubscribe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "shopAssistAppUnsubscribe")
    public JAXBElement<ShopAssistAppUnsubscribe> createShopAssistAppUnsubscribe(ShopAssistAppUnsubscribe value) {
        return new JAXBElement<ShopAssistAppUnsubscribe>(_ShopAssistAppUnsubscribe_QNAME, ShopAssistAppUnsubscribe.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RemindResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "remindResponse")
    public JAXBElement<RemindResponse> createRemindResponse(RemindResponse value) {
        return new JAXBElement<RemindResponse>(_RemindResponse_QNAME, RemindResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicateIncentiveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "communicate_incentiveResponse")
    public JAXBElement<CommunicateIncentiveResponse> createCommunicateIncentiveResponse(CommunicateIncentiveResponse value) {
        return new JAXBElement<CommunicateIncentiveResponse>(_CommunicateIncentiveResponse_QNAME, CommunicateIncentiveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicateIncentive }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "communicate_incentive")
    public JAXBElement<CommunicateIncentive> createCommunicateIncentive(CommunicateIncentive value) {
        return new JAXBElement<CommunicateIncentive>(_CommunicateIncentive_QNAME, CommunicateIncentive.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrivateOffer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "private_offer")
    public JAXBElement<PrivateOffer> createPrivateOffer(PrivateOffer value) {
        return new JAXBElement<PrivateOffer>(_PrivateOffer_QNAME, PrivateOffer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Remind }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "remind")
    public JAXBElement<Remind> createRemind(Remind value) {
        return new JAXBElement<Remind>(_Remind_QNAME, Remind.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicateQuestionnaireResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "communicate_questionnaireResponse")
    public JAXBElement<CommunicateQuestionnaireResponse> createCommunicateQuestionnaireResponse(CommunicateQuestionnaireResponse value) {
        return new JAXBElement<CommunicateQuestionnaireResponse>(_CommunicateQuestionnaireResponse_QNAME, CommunicateQuestionnaireResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicateQuestionnaire }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "communicate_questionnaire")
    public JAXBElement<CommunicateQuestionnaire> createCommunicateQuestionnaire(CommunicateQuestionnaire value) {
        return new JAXBElement<CommunicateQuestionnaire>(_CommunicateQuestionnaire_QNAME, CommunicateQuestionnaire.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RecordBoughtItemsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "record_bought_itemsResponse")
    public JAXBElement<RecordBoughtItemsResponse> createRecordBoughtItemsResponse(RecordBoughtItemsResponse value) {
        return new JAXBElement<RecordBoughtItemsResponse>(_RecordBoughtItemsResponse_QNAME, RecordBoughtItemsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShopAssistAppSubscribe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "shopAssistAppSubscribe")
    public JAXBElement<ShopAssistAppSubscribe> createShopAssistAppSubscribe(ShopAssistAppSubscribe value) {
        return new JAXBElement<ShopAssistAppSubscribe>(_ShopAssistAppSubscribe_QNAME, ShopAssistAppSubscribe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShopAssistAppUnsubscribeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "shopAssistAppUnsubscribeResponse")
    public JAXBElement<ShopAssistAppUnsubscribeResponse> createShopAssistAppUnsubscribeResponse(ShopAssistAppUnsubscribeResponse value) {
        return new JAXBElement<ShopAssistAppUnsubscribeResponse>(_ShopAssistAppUnsubscribeResponse_QNAME, ShopAssistAppUnsubscribeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecordBoughtItems }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "record_bought_items")
    public JAXBElement<RecordBoughtItems> createRecordBoughtItems(RecordBoughtItems value) {
        return new JAXBElement<RecordBoughtItems>(_RecordBoughtItems_QNAME, RecordBoughtItems.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PrivateOfferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "private_offerResponse")
    public JAXBElement<PrivateOfferResponse> createPrivateOfferResponse(PrivateOfferResponse value) {
        return new JAXBElement<PrivateOfferResponse>(_PrivateOfferResponse_QNAME, PrivateOfferResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ShopAssistAppSubscribeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.choreos.org/", name = "shopAssistAppSubscribeResponse")
    public JAXBElement<ShopAssistAppSubscribeResponse> createShopAssistAppSubscribeResponse(ShopAssistAppSubscribeResponse value) {
        return new JAXBElement<ShopAssistAppSubscribeResponse>(_ShopAssistAppSubscribeResponse_QNAME, ShopAssistAppSubscribeResponse.class, null, value);
    }

}
