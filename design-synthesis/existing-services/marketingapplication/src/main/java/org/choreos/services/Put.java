
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "put", propOrder = {
    "stockLevelNotification"
})
public class Put {

    protected StockLevelNotification stockLevelNotification;

    public StockLevelNotification getStockLevelNotification() {
        return stockLevelNotification;
    }

    public void setStockLevelNotification(StockLevelNotification value) {
        this.stockLevelNotification = value;
    }

}
