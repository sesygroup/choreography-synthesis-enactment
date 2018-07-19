
package org.choreos.services.client.marketingapplication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per make_proposal complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="make_proposal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sesssionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proposal" type="{http://services.choreos.org/}supplyAgreement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "make_proposal", propOrder = {
    "sesssionId",
    "proposal"
})
public class MakeProposal {

    protected String sesssionId;
    protected SupplyAgreement proposal;

    /**
     * Recupera il valore della proprietà sesssionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSesssionId() {
        return sesssionId;
    }

    /**
     * Imposta il valore della proprietà sesssionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSesssionId(String value) {
        this.sesssionId = value;
    }

    /**
     * Recupera il valore della proprietà proposal.
     * 
     * @return
     *     possible object is
     *     {@link SupplyAgreement }
     *     
     */
    public SupplyAgreement getProposal() {
        return proposal;
    }

    /**
     * Imposta il valore della proprietà proposal.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyAgreement }
     *     
     */
    public void setProposal(SupplyAgreement value) {
        this.proposal = value;
    }

}
