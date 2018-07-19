
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "set_estimate", propOrder = {
    "est"
})
public class SetEstimate {

    protected Estimate est;

  
    public Estimate getEst() {
        return est;
    }

   
    public void setEst(Estimate value) {
        this.est = value;
    }

}
