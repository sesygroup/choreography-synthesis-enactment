
package org.choreos.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notifyCheckin", propOrder = {
    "sessionId",
    "shoppingList"
})
public class NotifyCheckin {

    protected String sessionId;
    protected List<ShoppingListEntry> shoppingList;

  
    public String getSessionId() {
        return sessionId;
    }

   
    public void setSessionId(String value) {
        this.sessionId = value;
    }

  
    public List<ShoppingListEntry> getShoppingList() {
        if (shoppingList == null) {
            shoppingList = new ArrayList<ShoppingListEntry>();
        }
        return this.shoppingList;
    }

}
