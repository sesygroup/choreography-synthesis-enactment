
package org.choreos.services.enactchoreography.client.marketingapplication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ma_receive_sms complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ma_receive_sms">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="msg" type="{http://services.choreos.org/}sMSMessage" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ma_receive_sms", propOrder = {
    "sessionId",
    "msg"
})
public class MaReceiveSms {

    protected String sessionId;
    protected SMSMessage msg;

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
     * Recupera il valore della proprietà msg.
     * 
     * @return
     *     possible object is
     *     {@link SMSMessage }
     *     
     */
    public SMSMessage getMsg() {
        return msg;
    }

    /**
     * Imposta il valore della proprietà msg.
     * 
     * @param value
     *     allowed object is
     *     {@link SMSMessage }
     *     
     */
    public void setMsg(SMSMessage value) {
        this.msg = value;
    }

}
