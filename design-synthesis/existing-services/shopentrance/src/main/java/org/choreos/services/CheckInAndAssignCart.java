package org.choreos.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "check_in_and_assign_cart", propOrder = {
    "sessionId",
    "shoopingList"
})
public class CheckInAndAssignCart {

    @XmlElement(name = "sessionId")
    protected String sessionId;
    protected List<ShoppingListEntry> shoopingList;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String value) {
        this.sessionId = value;
    }

    public List<ShoppingListEntry> getShoopingList() {
        if (shoopingList == null) {
            shoopingList = new ArrayList<ShoppingListEntry>();
        }
        return this.shoopingList;
    }

}
