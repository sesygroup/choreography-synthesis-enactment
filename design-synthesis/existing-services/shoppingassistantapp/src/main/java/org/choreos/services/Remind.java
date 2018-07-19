package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "remind", propOrder = {
    "sessionId",
    "rem"
})
public class Remind {

    protected String sessionId;
    protected Reminder rem;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String value) {
        this.sessionId = value;
    }

    public Reminder getRem() {
        return rem;
    }

    public void setRem(Reminder value) {
        this.rem = value;
    }

}
