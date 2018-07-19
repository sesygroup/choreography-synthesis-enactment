
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "basicCommDeviceSubscribe", propOrder = {"sessionId"})
public class BasicCommDeviceSubscribe {

    protected String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String value) {
        this.sessionId = value;
    }

}
