
package org.choreos.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setInvocationAddress", propOrder = {"arg0", "arg1", "arg2"})
public class SetInvocationAddress {

    protected String arg0;
    protected String arg1;
    protected List<String> arg2;

    
    public String getArg0() {
        return arg0;
    }
    
    public void setArg0(String value) {
        this.arg0 = value;
    }
    
    public String getArg1() {
        return arg1;
    }

    public void setArg1(String value) {
        this.arg1 = value;
    }

    public List<String> getArg2() {
        if (arg2 == null) {
            arg2 = new ArrayList<String>();
        }
        return this.arg2;
    }

}
