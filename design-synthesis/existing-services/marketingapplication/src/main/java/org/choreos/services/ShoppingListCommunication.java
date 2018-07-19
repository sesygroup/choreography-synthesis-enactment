
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shopping_list_communication", propOrder = {
    "user",
    "shoppinglist",
    "callbackAddress"
})
public class ShoppingListCommunication {

    protected User user;
    protected ShoppingList shoppinglist;
    protected String callbackAddress;

    public User getUser() {
        return user;
    }

    public void setUser(User value) {
        this.user = value;
    }

    public ShoppingList getShoppinglist() {
        return shoppinglist;
    }

    public void setShoppinglist(ShoppingList value) {
        this.shoppinglist = value;
    }

    public String getCallbackAddress() {
        return callbackAddress;
    }

    public void setCallbackAddress(String value) {
        this.callbackAddress = value;
    }

}
