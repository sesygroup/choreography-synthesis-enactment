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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.chorevolution.synthesisprocessor.coordinationprotocol.channel.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Notify_QNAME = new QName("http://eu.chorevolution.synthesisprocessor.coordinationprotocol.channel.client/", "notify");
    private final static QName _Update_QNAME = new QName("http://eu.chorevolution.synthesisprocessor.coordinationprotocol.channel.client/", "update");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.chorevolution.synthesisprocessor.coordinationprotocol.channel.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Update }
     * 
     */
    public Update createUpdate() {
        return new Update();
    }

    /**
     * Create an instance of {@link Notify }
     * 
     */
    public Notify createNotify() {
        return new Notify();
    }

    /**
     * Create an instance of {@link AdditionalMessageNotify }
     * 
     */
    public AdditionalMessageNotify createAdditionalMessageNotify() {
        return new AdditionalMessageNotify();
    }

    /**
     * Create an instance of {@link AdditionalMessageUpdate }
     * 
     */
    public AdditionalMessageUpdate createAdditionalMessageUpdate() {
        return new AdditionalMessageUpdate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Notify }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eu.chorevolution.synthesisprocessor.coordinationprotocol.channel.client/", name = "notify")
    public JAXBElement<Notify> createNotify(Notify value) {
        return new JAXBElement<Notify>(_Notify_QNAME, Notify.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Update }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eu.chorevolution.synthesisprocessor.coordinationprotocol.channel.client/", name = "update")
    public JAXBElement<Update> createUpdate(Update value) {
        return new JAXBElement<Update>(_Update_QNAME, Update.class, null, value);
    }

}
