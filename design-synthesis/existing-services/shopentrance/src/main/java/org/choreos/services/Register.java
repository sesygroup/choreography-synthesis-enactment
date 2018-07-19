package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "register", propOrder = {
    "cartId"
})
public class Register {

    @XmlElement(name = "cart_id")
    protected String cartId;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String value) {
        this.cartId = value;
    }

}
