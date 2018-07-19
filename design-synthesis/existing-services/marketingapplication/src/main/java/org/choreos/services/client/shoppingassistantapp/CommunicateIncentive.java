
package org.choreos.services.client.shoppingassistantapp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per communicate_incentive complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="communicate_incentive">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inc" type="{http://services.choreos.org/}specialoffer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "communicate_incentive", propOrder = {
    "sessionId",
    "inc"
})
public class CommunicateIncentive {

    protected String sessionId;
    protected Specialoffer inc;

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
     * Recupera il valore della proprietà inc.
     * 
     * @return
     *     possible object is
     *     {@link Specialoffer }
     *     
     */
    public Specialoffer getInc() {
        return inc;
    }

    /**
     * Imposta il valore della proprietà inc.
     * 
     * @param value
     *     allowed object is
     *     {@link Specialoffer }
     *     
     */
    public void setInc(Specialoffer value) {
        this.inc = value;
    }

}
