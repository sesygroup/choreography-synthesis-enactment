package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "unsubscribeUserFrom", propOrder = {
    "sessionId",
    "cartId"
})
public class UnsubscribeUserFrom {

    protected String sessionId;
    protected String cartId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String value) {
        this.sessionId = value;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String value) {
        this.cartId = value;
    }

}
