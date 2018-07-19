
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


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

    public SupplyAgreement getSa() {
        return sa;
    }

    public void setSa(SupplyAgreement value) {
        this.sa = value;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean value) {
        this.authorized = value;
    }

    public String getCallbackAddress() {
        return callbackAddress;
    }

    public void setCallbackAddress(String value) {
        this.callbackAddress = value;
    }

}
