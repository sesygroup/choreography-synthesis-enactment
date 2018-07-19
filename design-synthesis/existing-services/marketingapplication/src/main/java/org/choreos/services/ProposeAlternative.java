
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String value) {
        this.sessionId = value;
    }

    public Product getAlternativeproduct() {
        return alternativeproduct;
    }

    public void setAlternativeproduct(Product value) {
        this.alternativeproduct = value;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer value) {
        this.availability = value;
    }

    public String getCallbackAddress() {
        return callbackAddress;
    }

    public void setCallbackAddress(String value) {
        this.callbackAddress = value;
    }

}
