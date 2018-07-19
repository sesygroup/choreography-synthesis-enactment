
package org.choreos.services;

import javax.xml.ws.WebFault;



@WebFault(name = "ScenarioException", targetNamespace = "http://services.choreos.org/")
public class ScenarioException_Exception
    extends Exception
{

   
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
