package org.choreos.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pay", propOrder = {
    "sessionId",
    "comId",
    "shoppingBag"
})
public class Pay {

    protected String sessionId;
    protected String comId;
    protected List<ShoppingListEntry> shoppingBag;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String value) {
        this.sessionId = value;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String value) {
        this.comId = value;
    }

    public List<ShoppingListEntry> getShoppingBag() {
        if (shoppingBag == null) {
            shoppingBag = new ArrayList<ShoppingListEntry>();
        }
        return this.shoppingBag;
    }

}
