
package org.choreos.services.enactchoreography.client.marketingapplication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per supplyAgreement complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="supplyAgreement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="prod" type="{http://services.choreos.org/}product" minOccurs="0"/>
 *         &lt;element name="qty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="when" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="authorized" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "supplyAgreement", propOrder = {
    "prod",
    "qty",
    "when",
    "price",
    "authorized"
})
public class SupplyAgreement {

    protected Product prod;
    protected Integer qty;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar when;
    protected double price;
    protected boolean authorized;

    /**
     * Recupera il valore della proprietà prod.
     * 
     * @return
     *     possible object is
     *     {@link Product }
     *     
     */
    public Product getProd() {
        return prod;
    }

    /**
     * Imposta il valore della proprietà prod.
     * 
     * @param value
     *     allowed object is
     *     {@link Product }
     *     
     */
    public void setProd(Product value) {
        this.prod = value;
    }

    /**
     * Recupera il valore della proprietà qty.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQty() {
        return qty;
    }

    /**
     * Imposta il valore della proprietà qty.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQty(Integer value) {
        this.qty = value;
    }

    /**
     * Recupera il valore della proprietà when.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWhen() {
        return when;
    }

    /**
     * Imposta il valore della proprietà when.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWhen(XMLGregorianCalendar value) {
        this.when = value;
    }

    /**
     * Recupera il valore della proprietà price.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Imposta il valore della proprietà price.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * Recupera il valore della proprietà authorized.
     * 
     */
    public boolean isAuthorized() {
        return authorized;
    }

    /**
     * Imposta il valore della proprietà authorized.
     * 
     */
    public void setAuthorized(boolean value) {
        this.authorized = value;
    }

}
