
package org.choreos.services.client.marketingapplication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per offer complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="offer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="item" type="{http://services.choreos.org/}product" minOccurs="0"/>
 *         &lt;element name="discount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "offer", propOrder = {
    "item",
    "discount"
})
public class Offer {

    protected Product item;
    protected int discount;

    /**
     * Recupera il valore della proprietà item.
     * 
     * @return
     *     possible object is
     *     {@link Product }
     *     
     */
    public Product getItem() {
        return item;
    }

    /**
     * Imposta il valore della proprietà item.
     * 
     * @param value
     *     allowed object is
     *     {@link Product }
     *     
     */
    public void setItem(Product value) {
        this.item = value;
    }

    /**
     * Recupera il valore della proprietà discount.
     * 
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * Imposta il valore della proprietà discount.
     * 
     */
    public void setDiscount(int value) {
        this.discount = value;
    }

}
