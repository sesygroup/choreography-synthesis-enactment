
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bcd_receive_sms", propOrder = {"sessionId", "msg"})
public class BcdReceiveSms {

    protected String sessionId;
    protected SMSMessage msg;

    
    public String getSessionId() {
        return sessionId;
    }
    
    public void setSessionId(String value) {
        this.sessionId = value;
    }

    public SMSMessage getMsg() {
        return msg;
    }

    public void setMsg(SMSMessage value) {
        this.msg = value;
    }

}
