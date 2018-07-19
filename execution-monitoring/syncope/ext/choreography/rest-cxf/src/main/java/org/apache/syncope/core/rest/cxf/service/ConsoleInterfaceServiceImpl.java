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
package org.apache.syncope.core.rest.cxf.service;

import eu.chorevolution.idm.common.to.AVGCoordinationDelegateTO;
import eu.chorevolution.idm.common.to.AVGOperationDataTO;
import eu.chorevolution.idm.common.to.AVGServiceTO;
import eu.chorevolution.idm.common.to.ChoreographyInstanceTO;
import eu.chorevolution.idm.common.to.ChoreographyTO;
import eu.chorevolution.idm.common.to.CoordinationDelegateTO;
import eu.chorevolution.idm.common.to.OperationDataTO;
import eu.chorevolution.idm.common.to.ServiceTO;
import eu.chorevolution.idm.common.types.ArtifactType;
import java.util.List;
import org.apache.syncope.common.rest.api.service.ConsoleInterfaceService;
import org.apache.syncope.core.logic.MonitorLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsoleInterfaceServiceImpl extends AbstractServiceImpl implements ConsoleInterfaceService {

    @Autowired
    private MonitorLogic logic;

    @Override
    public List<ChoreographyTO> choreographyList() {
        return logic.choreographyList();
    }

    @Override
    public List<ChoreographyInstanceTO> instanceList(final String choreographyPK) {
        return logic.instanceList(choreographyPK);
    }

    @Override
    public List<CoordinationDelegateTO> cdList(final String instancePK) {
        return logic.cdList(instancePK);
    }

    @Override
    public List<OperationDataTO> operationList(
            final String instancePK,
            final String artifactName) {
        return logic.operationList(instancePK, ArtifactType.CD, artifactName);
    }

    @Override
    public List<OperationDataTO> operationList(final String choreographyInstancePK) {
        return logic.operationList(choreographyInstancePK);
    }

    @Override
    public List<ServiceTO> serviceList(final String choreographyInstancePK) {
        return logic.serviceList(choreographyInstancePK);
    }

    @Override
    public List<AVGServiceTO> averageServiceList(final String choreographyId) {
        return logic.averageServiceList(choreographyId);
    }

    @Override
    public ChoreographyTO getChoreography(final String choreographyId) {
        return logic.getChoreography(choreographyId);
    }

    @Override
    public ChoreographyInstanceTO getChoreographyInstance(final String choreographyInstancePK) {
        return logic.getChoreographyInstance(choreographyInstancePK);
    }

    @Override
    public CoordinationDelegateTO getCd(final String choreographyInstancePK, final String cdName) {
        return logic.getCd(choreographyInstancePK, cdName);
    }

    @Override
    public ServiceTO getService(final String choreographyInstancePK, final String serviceName) {
        return logic.getService(choreographyInstancePK, serviceName);
    }

    @Override
    public Double getAverageInstanceExecutionTime(final String choreographyId) {
        return logic.getAverageInstanceExecutionTime(choreographyId);
    }

    @Override
    public List<AVGCoordinationDelegateTO> averageCdList(final String choreographyId) {
        return logic.averageCdList(choreographyId);
    }

    @Override
    public List<AVGOperationDataTO> averageOperationList(final String choreographyId, final String cdName) {
        return logic.averageOperationList(choreographyId, cdName);
    }

    @Override
    public void deleteInstance(final String choreographyInstancePK) {
        logic.deleteInstance(choreographyInstancePK);
    }
}
