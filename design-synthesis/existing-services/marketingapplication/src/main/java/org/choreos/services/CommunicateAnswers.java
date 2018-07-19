
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "communicateAnswers", propOrder = {
    "sessionId",
    "questionnaire"
})
public class CommunicateAnswers {

    protected String sessionId;
    protected Questionnaire questionnaire;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String value) {
        this.sessionId = value;
    }
 
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire value) {
        this.questionnaire = value;
    }

}
