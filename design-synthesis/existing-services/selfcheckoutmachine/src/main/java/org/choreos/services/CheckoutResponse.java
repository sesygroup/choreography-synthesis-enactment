package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkoutResponse", propOrder = {
    "_return"
})
public class CheckoutResponse {

    @XmlElement(name = "return")
    protected boolean _return;

    public boolean isReturn() {
        return _return;
    }

    public void setReturn(boolean value) {
        this._return = value;
    }

}
