
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestPrivateOffer", propOrder = {
    "sessionId",
    "product"
})
public class RequestPrivateOffer {

    protected String sessionId;
    protected Product product;

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

}
