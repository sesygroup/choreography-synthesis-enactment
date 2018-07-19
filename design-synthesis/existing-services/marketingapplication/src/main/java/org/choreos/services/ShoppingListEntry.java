
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shoppingListEntry", propOrder = {
    "item",
    "qty"
})
public class ShoppingListEntry {

    protected Product item;
    protected Integer qty;

    public Product getItem() {
        return item;
    }


    public void setItem(Product value) {
        this.item = value;
    }

    public Integer getQty() {
        return qty;
    }


    public void setQty(Integer value) {
        this.qty = value;
    }

}
