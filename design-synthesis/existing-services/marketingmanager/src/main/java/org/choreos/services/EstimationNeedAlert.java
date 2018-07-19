
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "estimationNeedAlert", propOrder = {
    "product"
})
public class EstimationNeedAlert {

    protected Product product;

  
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product value) {
        this.product = value;
    }

}
