
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sMSMessage", propOrder = {"text", "from", "date"})
public class SMSMessage {

    protected String text;
    protected String from;

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;

    public String getText() {
        return text;
    }

    
    public void setText(String value) {
        this.text = value;
    }

    
    public String getFrom() {
        return from;
    }

    
    public void setFrom(String value) {
        this.from = value;
    }

    
    public XMLGregorianCalendar getDate() {
        return date;
    }

    
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

}
