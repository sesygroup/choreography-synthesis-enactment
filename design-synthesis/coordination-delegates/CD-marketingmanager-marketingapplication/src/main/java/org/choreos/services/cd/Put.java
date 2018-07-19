
package org.choreos.services.cd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per put complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="put">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stockLevelNotification" type="{http://services.choreos.org/}stockLevelNotification" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "put", propOrder = {
    "stockLevelNotification"
})
public class Put {

    protected StockLevelNotification stockLevelNotification;

    /**
     * Recupera il valore della proprietà stockLevelNotification.
     * 
     * @return
     *     possible object is
     *     {@link StockLevelNotification }
     *     
     */
    public StockLevelNotification getStockLevelNotification() {
        return stockLevelNotification;
    }

    /**
     * Imposta il valore della proprietà stockLevelNotification.
     * 
     * @param value
     *     allowed object is
     *     {@link StockLevelNotification }
     *     
     */
    public void setStockLevelNotification(StockLevelNotification value) {
        this.stockLevelNotification = value;
    }

}
