 /*
 * Copyright 2015 The CHOReVOLUTION project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.chorevolution.synthesisprocessor.coordinationprotocol.channel.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per additionalMessageUpdate complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="additionalMessageUpdate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="choreographyID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coordinatedServiceEndpointName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coordinationDelegateFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coordinationDelegateTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="request" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "additionalMessageUpdate", propOrder = {
    "choreographyID",
    "coordinatedServiceEndpointName",
    "coordinationDelegateFrom",
    "coordinationDelegateTo",
    "request",
    "state"
})
public class AdditionalMessageUpdate {

    protected String choreographyID;
    protected String coordinatedServiceEndpointName;
    protected String coordinationDelegateFrom;
    protected String coordinationDelegateTo;
    protected String request;
    protected String state;

    /**
     * Recupera il valore della proprietà choreographyID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChoreographyID() {
        return choreographyID;
    }

    /**
     * Imposta il valore della proprietà choreographyID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChoreographyID(String value) {
        this.choreographyID = value;
    }

    /**
     * Recupera il valore della proprietà coordinatedServiceEndpointName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordinatedServiceEndpointName() {
        return coordinatedServiceEndpointName;
    }

    /**
     * Imposta il valore della proprietà coordinatedServiceEndpointName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordinatedServiceEndpointName(String value) {
        this.coordinatedServiceEndpointName = value;
    }

    /**
     * Recupera il valore della proprietà coordinationDelegateFrom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordinationDelegateFrom() {
        return coordinationDelegateFrom;
    }

    /**
     * Imposta il valore della proprietà coordinationDelegateFrom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordinationDelegateFrom(String value) {
        this.coordinationDelegateFrom = value;
    }

    /**
     * Recupera il valore della proprietà coordinationDelegateTo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordinationDelegateTo() {
        return coordinationDelegateTo;
    }

    /**
     * Imposta il valore della proprietà coordinationDelegateTo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordinationDelegateTo(String value) {
        this.coordinationDelegateTo = value;
    }

    /**
     * Recupera il valore della proprietà request.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequest() {
        return request;
    }

    /**
     * Imposta il valore della proprietà request.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequest(String value) {
        this.request = value;
    }

    /**
     * Recupera il valore della proprietà state.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Imposta il valore della proprietà state.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

}
