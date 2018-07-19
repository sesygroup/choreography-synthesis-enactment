
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "changeQtyNotify", propOrder = {
    "sessionId",
    "product",
    "qty"
})
public class ChangeQtyNotify {

    protected String sessionId;
    protected Product product;
    protected Integer qty;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String value) {
        this.sessionId = value;
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
