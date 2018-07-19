
package org.choreos.services.cd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per set_estimate complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="set_estimate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="est" type="{http://services.choreos.org/}estimate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "set_estimate", propOrder = {
    "est"
})
public class SetEstimate {

    protected Estimate est;

    /**
     * Recupera il valore della proprietà est.
     * 
     * @return
     *     possible object is
     *     {@link Estimate }
     *     
     */
    public Estimate getEst() {
        return est;
    }

    /**
     * Imposta il valore della proprietà est.
     * 
     * @param value
     *     allowed object is
     *     {@link Estimate }
     *     
     */
    public void setEst(Estimate value) {
        this.est = value;
    }

}
