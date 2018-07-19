
package org.choreos.services.enactchoreography.client.marketingapplication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per shopping_list_communication complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="shopping_list_communication">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user" type="{http://services.choreos.org/}user" minOccurs="0"/>
 *         &lt;element name="shoppinglist" type="{http://services.choreos.org/}shoppingList" minOccurs="0"/>
 *         &lt;element name="callbackAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shopping_list_communication", propOrder = {
    "user",
    "shoppinglist",
    "callbackAddress"
})
public class ShoppingListCommunication {

    protected User user;
    protected ShoppingList shoppinglist;
    protected String callbackAddress;

    /**
     * Recupera il valore della proprietà user.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUser() {
        return user;
    }

    /**
     * Imposta il valore della proprietà user.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUser(User value) {
        this.user = value;
    }

    /**
     * Recupera il valore della proprietà shoppinglist.
     * 
     * @return
     *     possible object is
     *     {@link ShoppingList }
     *     
     */
    public ShoppingList getShoppinglist() {
        return shoppinglist;
    }

    /**
     * Imposta il valore della proprietà shoppinglist.
     * 
     * @param value
     *     allowed object is
     *     {@link ShoppingList }
     *     
     */
    public void setShoppinglist(ShoppingList value) {
        this.shoppinglist = value;
    }

    /**
     * Recupera il valore della proprietà callbackAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallbackAddress() {
        return callbackAddress;
    }

    /**
     * Imposta il valore della proprietà callbackAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallbackAddress(String value) {
        this.callbackAddress = value;
    }

}
