
package org.choreos.services.client.marketingapplication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per unsubscribe_to_supply_negotiation complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="unsubscribe_to_supply_negotiation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sesssionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "unsubscribe_to_supply_negotiation", propOrder = {
    "sesssionId"
})
public class UnsubscribeToSupplyNegotiation {

    protected String sesssionId;

    /**
     * Recupera il valore della proprietà sesssionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSesssionId() {
        return sesssionId;
    }

    /**
     * Imposta il valore della proprietà sesssionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSesssionId(String value) {
        this.sesssionId = value;
    }

}
