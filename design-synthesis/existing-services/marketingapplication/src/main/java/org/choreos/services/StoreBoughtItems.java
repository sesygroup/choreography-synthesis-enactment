
package org.choreos.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "storeBoughtItems", propOrder = {
    "sessionId",
    "items"
})
public class StoreBoughtItems {

    protected String sessionId;
    protected List<Product> items;

    public String getSessionId() {
        return sessionId;
    }


    public void setSessionId(String value) {
        this.sessionId = value;
    }


    public List<Product> getItems() {
        if (items == null) {
            items = new ArrayList<Product>();
        }
        return this.items;
    }

}
