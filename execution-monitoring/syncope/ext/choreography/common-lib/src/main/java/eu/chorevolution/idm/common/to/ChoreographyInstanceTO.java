/*
 * Copyright 2016 The CHOReVOLUTION project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.chorevolution.idm.common.to;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.syncope.common.lib.AbstractBaseBean;

@XmlRootElement(name = "choreography_instance")
@XmlType
public class ChoreographyInstanceTO extends AbstractBaseBean {

    private static final long serialVersionUID = 4829635452545920453L;

    private String id;

    private String choreographyInstanceId;

    private String instanceDescription;

    private String choreographyId;

    private String choreographyName;

    private Long executionTime;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getChoreographyInstanceId() {
        return choreographyInstanceId;
    }

    public void setChoreographyInstanceId(final String choreographyInstanceId) {
        this.choreographyInstanceId = choreographyInstanceId;
    }

    public String getInstanceDescription() {
        return instanceDescription;
    }

    public void setInstanceDescription(final String instanceDescription) {
        this.instanceDescription = instanceDescription;
    }

    public String getChoreographyId() {
        return choreographyId;
    }

    public void setChoreographyId(final String choreographyId) {
        this.choreographyId = choreographyId;
    }

    public String getChoreographyName() {
        return choreographyName;
    }

    public void setChoreographyName(final String choreographyName) {
        this.choreographyName = choreographyName;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(final Long executionTime) {
        this.executionTime = executionTime;
    }

}
