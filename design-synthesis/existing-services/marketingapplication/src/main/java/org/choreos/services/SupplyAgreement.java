
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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

    public Product getProd() {
        return prod;
    }

    public void setProd(Product value) {
        this.prod = value;
    }


    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer value) {
        this.qty = value;
    }

    public XMLGregorianCalendar getWhen() {
        return when;
    }

    public void setWhen(XMLGregorianCalendar value) {
        this.when = value;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double value) {
        this.price = value;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean value) {
        this.authorized = value;
    }

}
