
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subscribe_to_supply_negotation", propOrder = {
    "sesssionId"
})
public class SubscribeToSupplyNegotation {

    protected String sesssionId;

    /**
     * Gets the value of the sesssionId property.
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
     * Sets the value of the sesssionId property.
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
