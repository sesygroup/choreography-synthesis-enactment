
package org.choreos.services.enactchoreography.client.shoppingassistantapp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per remind complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="remind">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rem" type="{http://services.choreos.org/}reminder" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "remind", propOrder = {
    "sessionId",
    "rem"
})
public class Remind {

    protected String sessionId;
    protected Reminder rem;

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
     * Recupera il valore della proprietà rem.
     * 
     * @return
     *     possible object is
     *     {@link Reminder }
     *     
     */
    public Reminder getRem() {
        return rem;
    }

    /**
     * Imposta il valore della proprietà rem.
     * 
     * @param value
     *     allowed object is
     *     {@link Reminder }
     *     
     */
    public void setRem(Reminder value) {
        this.rem = value;
    }

}
