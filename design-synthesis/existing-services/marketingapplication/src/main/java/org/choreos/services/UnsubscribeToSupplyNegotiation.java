
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "unsubscribe_to_supply_negotiation", propOrder = {
    "sesssionId"
})
public class UnsubscribeToSupplyNegotiation {

    protected String sesssionId;

    public String getSesssionId() {
        return sesssionId;
    }

    public void setSesssionId(String value) {
        this.sesssionId = value;
    }

}
