package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "remove_product", propOrder = {
    "sessionId",
    "cartId",
    "product"
})
public class RemoveProduct {

    protected String sessionId;
    protected String cartId;
    protected Product product;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product value) {
        this.product = value;
    }

}
