
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "putEstimationReq", propOrder = {
    "sessionId",
    "estimationNeedAlert"
})
public class PutEstimationReq {

    protected String sessionId;
    protected EstimationNeedAlert estimationNeedAlert;

 
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String value) {
        this.sessionId = value;
    }

    public EstimationNeedAlert getEstimationNeedAlert() {
        return estimationNeedAlert;
    }

    public void setEstimationNeedAlert(EstimationNeedAlert value) {
        this.estimationNeedAlert = value;
    }

}
