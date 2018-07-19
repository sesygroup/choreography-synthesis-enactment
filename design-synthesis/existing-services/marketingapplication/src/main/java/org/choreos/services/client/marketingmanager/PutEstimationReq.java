
package org.choreos.services.client.marketingmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per putEstimationReq complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="putEstimationReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estimationNeedAlert" type="{http://services.choreos.org/}estimationNeedAlert" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "putEstimationReq", propOrder = {
    "sessionId",
    "estimationNeedAlert"
})
public class PutEstimationReq {

    protected String sessionId;
    protected EstimationNeedAlert estimationNeedAlert;

    /**
     * Recupera il valore della proprietà sessionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Imposta il valore della proprietà sessionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

    /**
     * Recupera il valore della proprietà estimationNeedAlert.
     * 
     * @return
     *     possible object is
     *     {@link EstimationNeedAlert }
     *     
     */
    public EstimationNeedAlert getEstimationNeedAlert() {
        return estimationNeedAlert;
    }

    /**
     * Imposta il valore della proprietà estimationNeedAlert.
     * 
     * @param value
     *     allowed object is
     *     {@link EstimationNeedAlert }
     *     
     */
    public void setEstimationNeedAlert(EstimationNeedAlert value) {
        this.estimationNeedAlert = value;
    }

}
