
package org.choreos.services.client.selfcheckoutmachine;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per pay complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="pay">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shoppingBag" type="{http://services.choreos.org/}shoppingListEntry" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pay", propOrder = {
    "sessionId",
    "comId",
    "shoppingBag"
})
public class Pay {

    protected String sessionId;
    protected String comId;
    protected List<ShoppingListEntry> shoppingBag;

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
     * Recupera il valore della proprietà comId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComId() {
        return comId;
    }

    /**
     * Imposta il valore della proprietà comId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComId(String value) {
        this.comId = value;
    }

    /**
     * Gets the value of the shoppingBag property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shoppingBag property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShoppingBag().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShoppingListEntry }
     * 
     * 
     */
    public List<ShoppingListEntry> getShoppingBag() {
        if (shoppingBag == null) {
            shoppingBag = new ArrayList<ShoppingListEntry>();
        }
        return this.shoppingBag;
    }

}
