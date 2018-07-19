
package org.choreos.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
    "name",
    "email",
    "shoppingList"
})
public class User {

    protected String name;
    protected String email;
    @XmlElement(nillable = true)
    protected List<ShoppingListEntry> shoppingList;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String value) {
        this.email = value;
    }

    public List<ShoppingListEntry> getShoppingList() {
        if (shoppingList == null) {
            shoppingList = new ArrayList<ShoppingListEntry>();
        }
        return this.shoppingList;
    }

}
