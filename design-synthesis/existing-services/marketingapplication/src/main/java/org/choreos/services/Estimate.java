
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "estimate", propOrder = {
    "product",
    "qty",
    "from",
    "to"
})
public class Estimate {

    protected Product product;
    protected Integer qty;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar from;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar to;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product value) {
        this.product = value;
    }


    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer value) {
        this.qty = value;
    }


    public XMLGregorianCalendar getFrom() {
        return from;
    }


    public void setFrom(XMLGregorianCalendar value) {
        this.from = value;
    }

    public XMLGregorianCalendar getTo() {
        return to;
    }

    public void setTo(XMLGregorianCalendar value) {
        this.to = value;
    }

}
