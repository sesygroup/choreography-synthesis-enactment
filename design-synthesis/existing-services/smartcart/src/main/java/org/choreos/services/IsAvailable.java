package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "isAvailable", propOrder = {
    "cartId"
})
public class IsAvailable {

    protected String cartId;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String value) {
        this.cartId = value;
    }

}
