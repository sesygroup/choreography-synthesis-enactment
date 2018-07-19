
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product", propOrder = {
    "name",
    "brand",
    "barcode"
})
public class Product {

    protected String name;
    protected String brand;
    protected String barcode;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String value) {
        this.brand = value;
    }


    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String value) {
        this.barcode = value;
    }

}
