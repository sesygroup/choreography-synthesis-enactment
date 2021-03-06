package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "add_product", propOrder = {
    "sessionId",
    "cartId",
    "product",
    "qty"
})
public class AddProduct {

    protected String sessionId;
    protected String cartId;
    protected Product product;
    protected Integer qty;

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

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer value) {
        this.qty = value;
    }

}
