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
 * <p>Classe Java per update complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="update">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="additionalMessage" type="{http://eu.chorevolution.synthesisprocessor.coordinationprotocol.channel.client/}additionalMessageUpdate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "update", propOrder = {
    "additionalMessage"
})
public class Update {

    protected AdditionalMessageUpdate additionalMessage;

    /**
     * Recupera il valore della proprietà additionalMessage.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalMessageUpdate }
     *     
     */
    public AdditionalMessageUpdate getAdditionalMessage() {
        return additionalMessage;
    }

    /**
     * Imposta il valore della proprietà additionalMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalMessageUpdate }
     *     
     */
    public void setAdditionalMessage(AdditionalMessageUpdate value) {
        this.additionalMessage = value;
    }

}
