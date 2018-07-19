
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subscribe_to_supply_authorization", propOrder = {
    "callbackAddress"
})
public class SubscribeToSupplyAuthorization {

    protected String callbackAddress;

    public String getCallbackAddress() {
        return callbackAddress;
    }


    public void setCallbackAddress(String value) {
        this.callbackAddress = value;
    }

}
