package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "communicate_incentive", propOrder = {
    "sessionId",
    "inc"
})
public class CommunicateIncentive {

    protected String sessionId;
    protected Specialoffer inc;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String value) {
        this.sessionId = value;
    }

    public Specialoffer getInc() {
        return inc;
    }

    public void setInc(Specialoffer value) {
        this.inc = value;
    }

}
