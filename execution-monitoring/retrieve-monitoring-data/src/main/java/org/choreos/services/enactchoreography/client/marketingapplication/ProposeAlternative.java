
package org.choreos.services.enactchoreography.client.marketingapplication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per proposeAlternative complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="proposeAlternative">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="alternativeproduct" type="{http://services.choreos.org/}product" minOccurs="0"/>
 *         &lt;element name="availability" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="callbackAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "proposeAlternative", propOrder = {
    "sessionId",
    "alternativeproduct",
    "availability",
    "callbackAddress"
})
public class ProposeAlternative {

    protected String sessionId;
    protected Product alternativeproduct;
    protected Integer availability;
    protected String callbackAddress;

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
     * Recupera il valore della proprietà alternativeproduct.
     * 
     * @return
     *     possible object is
     *     {@link Product }
     *     
     */
    public Product getAlternativeproduct() {
        return alternativeproduct;
    }

    /**
     * Imposta il valore della proprietà alternativeproduct.
     * 
     * @param value
     *     allowed object is
     *     {@link Product }
     *     
     */
    public void setAlternativeproduct(Product value) {
        this.alternativeproduct = value;
    }

    /**
     * Recupera il valore della proprietà availability.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAvailability() {
        return availability;
    }

    /**
     * Imposta il valore della proprietà availability.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAvailability(Integer value) {
        this.availability = value;
    }

    /**
     * Recupera il valore della proprietà callbackAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallbackAddress() {
        return callbackAddress;
    }

    /**
     * Imposta il valore della proprietà callbackAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallbackAddress(String value) {
        this.callbackAddress = value;
    }

}
