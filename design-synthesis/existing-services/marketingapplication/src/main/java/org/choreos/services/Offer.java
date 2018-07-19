
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "offer", propOrder = {
    "item",
    "discount"
})
public class Offer {

    protected Product item;
    protected int discount;

    public Product getItem() {
        return item;
    }

    public void setItem(Product value) {
        this.item = value;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int value) {
        this.discount = value;
    }

}
