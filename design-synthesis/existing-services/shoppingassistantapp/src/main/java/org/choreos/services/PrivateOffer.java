package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "private_offer", propOrder = {
    "sessionId",
    "offer"
})
public class PrivateOffer {

    protected String sessionId;
    protected Offer offer;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String value) {
        this.sessionId = value;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer value) {
        this.offer = value;
    }

}
