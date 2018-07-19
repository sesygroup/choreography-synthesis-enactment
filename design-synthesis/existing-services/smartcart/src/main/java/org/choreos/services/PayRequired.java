package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payRequired", propOrder = {
    "sessionId",
    "cartId",
    "comId"
})
public class PayRequired {

    protected String sessionId;
    protected String cartId;
    protected String comId;

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

    public String getComId() {
        return comId;
    }

    public void setComId(String value) {
        this.comId = value;
    }

}
