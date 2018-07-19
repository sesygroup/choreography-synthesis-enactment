package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "communicate_questionnaire", propOrder = {
    "sessionId",
    "q"
})
public class CommunicateQuestionnaire {

    protected String sessionId;
    protected Questionnaire q;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String value) {
        this.sessionId = value;
    }

    public Questionnaire getQ() {
        return q;
    }

    public void setQ(Questionnaire value) {
        this.q = value;
    }

}
