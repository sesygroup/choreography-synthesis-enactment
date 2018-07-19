
package org.choreos.services;

import javax.xml.ws.WebFault;

@WebFault(name = "ScenarioException", targetNamespace = "http://services.choreos.org/")
public class ScenarioException_Exception extends Exception{

	private static final long serialVersionUID = 95233660897719927L;

	private ScenarioException faultInfo;

    public ScenarioException_Exception(String message, ScenarioException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    public ScenarioException_Exception(String message, ScenarioException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    public ScenarioException getFaultInfo() {
        return faultInfo;
    }

}
