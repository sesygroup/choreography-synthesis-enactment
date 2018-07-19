package org.choreos.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "questionnaire", propOrder = {})
public class Questionnaire {

    protected boolean ready;
    @XmlElement(required = true)
    protected Questionnaire.Qa qa;

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean value) {
        this.ready = value;
    }

    public Questionnaire.Qa getQa() {
        return qa;
    }

    public void setQa(Questionnaire.Qa value) {
        this.qa = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "entry"
    })
    public static class Qa {

        protected List<Questionnaire.Qa.Entry> entry;

        public List<Questionnaire.Qa.Entry> getEntry() {
            if (entry == null) {
                entry = new ArrayList<Questionnaire.Qa.Entry>();
            }
            return this.entry;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "key",
            "value"
        })
        public static class Entry {

            protected String key;
            protected String value;

            public String getKey() {
                return key;
            }

            public void setKey(String value) {
                this.key = value;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

        }

    }

}
