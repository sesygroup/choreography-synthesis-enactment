
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScenarioException", propOrder = {
    "message"
})
public class ScenarioException {

    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

}
