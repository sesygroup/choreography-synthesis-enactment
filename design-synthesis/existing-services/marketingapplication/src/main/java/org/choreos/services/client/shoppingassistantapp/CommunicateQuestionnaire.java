
package org.choreos.services.client.shoppingassistantapp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per communicate_questionnaire complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="communicate_questionnaire">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="q" type="{http://services.choreos.org/}questionnaire" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "communicate_questionnaire", propOrder = {
    "sessionId",
    "q"
})
public class CommunicateQuestionnaire {

    protected String sessionId;
    protected Questionnaire q;

    /**
     * Recupera il valore della proprietà sessionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Imposta il valore della proprietà sessionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

    /**
     * Recupera il valore della proprietà q.
     * 
     * @return
     *     possible object is
     *     {@link Questionnaire }
     *     
     */
    public Questionnaire getQ() {
        return q;
    }

    /**
     * Imposta il valore della proprietà q.
     * 
     * @param value
     *     allowed object is
     *     {@link Questionnaire }
     *     
     */
    public void setQ(Questionnaire value) {
        this.q = value;
    }

}
