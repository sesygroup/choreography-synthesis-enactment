
package org.choreos.services.client.shoppingassistantapp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per reminder complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="reminder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="questionnaire" type="{http://services.choreos.org/}questionnaire" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reminder", propOrder = {
    "questionnaire"
})
public class Reminder {

    protected Questionnaire questionnaire;

    /**
     * Recupera il valore della proprietà questionnaire.
     * 
     * @return
     *     possible object is
     *     {@link Questionnaire }
     *     
     */
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    /**
     * Imposta il valore della proprietà questionnaire.
     * 
     * @param value
     *     allowed object is
     *     {@link Questionnaire }
     *     
     */
    public void setQuestionnaire(Questionnaire value) {
        this.questionnaire = value;
    }

}
