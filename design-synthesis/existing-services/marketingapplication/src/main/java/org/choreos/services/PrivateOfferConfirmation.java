
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "privateOfferConfirmation", propOrder = {
    "sessionId",
    "offer",
    "confirmed"
})
public class PrivateOfferConfirmation {

    protected String sessionId;
    protected Offer offer;
    protected boolean confirmed;

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

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean value) {
        this.confirmed = value;
    }

}
