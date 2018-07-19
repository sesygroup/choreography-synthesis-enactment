
package org.choreos.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "make_proposal", propOrder = {
    "sesssionId",
    "proposal"
})
public class MakeProposal {

    protected String sesssionId;
    protected SupplyAgreement proposal;


    public String getSesssionId() {
        return sesssionId;
    }

    public void setSesssionId(String value) {
        this.sesssionId = value;
    }


    public SupplyAgreement getProposal() {
        return proposal;
    }

    public void setProposal(SupplyAgreement value) {
        this.proposal = value;
    }

}
