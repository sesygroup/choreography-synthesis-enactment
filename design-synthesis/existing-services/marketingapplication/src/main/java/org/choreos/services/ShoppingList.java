
package org.choreos.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shoppingList", propOrder = {
    "entry"
})
public class ShoppingList {

    @XmlElement(nillable = true)
    protected List<ShoppingListEntry> entry;

    public List<ShoppingListEntry> getEntry() {
        if (entry == null) {
            entry = new ArrayList<ShoppingListEntry>();
        }
        return this.entry;
    }

}
