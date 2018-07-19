
package org.choreos.services.enactchoreography.client.marketingapplication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per unsubscribeto_supply_authorization complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="unsubscribeto_supply_authorization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
@XmlType(name = "unsubscribeto_supply_authorization", propOrder = {
    "callbackAddress"
})
public class UnsubscribetoSupplyAuthorization {

    protected String callbackAddress;

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
