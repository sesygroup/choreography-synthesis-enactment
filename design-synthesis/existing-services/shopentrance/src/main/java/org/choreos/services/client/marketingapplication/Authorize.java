
package org.choreos.services.client.marketingapplication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per authorize complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="authorize">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sa" type="{http://services.choreos.org/}supplyAgreement" minOccurs="0"/>
 *         &lt;element name="authorized" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "authorize", propOrder = {
    "sa",
    "authorized",
    "callbackAddress"
})
public class Authorize {

    protected SupplyAgreement sa;
    protected boolean authorized;
    protected String callbackAddress;

    /**
     * Recupera il valore della proprietà sa.
     * 
     * @return
     *     possible object is
     *     {@link SupplyAgreement }
     *     
     */
    public SupplyAgreement getSa() {
        return sa;
    }

    /**
     * Imposta il valore della proprietà sa.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyAgreement }
     *     
     */
    public void setSa(SupplyAgreement value) {
        this.sa = value;
    }

    /**
     * Recupera il valore della proprietà authorized.
     * 
     */
    public boolean isAuthorized() {
        return authorized;
    }

    /**
     * Imposta il valore della proprietà authorized.
     * 
     */
    public void setAuthorized(boolean value) {
        this.authorized = value;
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
