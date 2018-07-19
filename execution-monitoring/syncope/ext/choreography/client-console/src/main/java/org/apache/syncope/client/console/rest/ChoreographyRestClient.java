/*
 * Copyright 2016 The CHOReVOLUTION project
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
package org.apache.syncope.client.console.rest;

import eu.chorevolution.idm.common.to.AVGCoordinationDelegateTO;
import eu.chorevolution.idm.common.to.AVGOperationDataTO;
import eu.chorevolution.idm.common.to.AVGServiceTO;
import eu.chorevolution.idm.common.to.OperationDataTO;
import eu.chorevolution.idm.common.to.ChoreographyInstanceTO;
import eu.chorevolution.idm.common.to.ChoreographyTO;
import eu.chorevolution.idm.common.to.CoordinationDelegateTO;
import eu.chorevolution.idm.common.to.ServiceTO;
import java.util.List;
import org.apache.syncope.common.rest.api.service.ConsoleInterfaceService;

public class ChoreographyRestClient extends BaseRestClient {

    private static final long serialVersionUID = -2018208424159468912L;

    public List<ChoreographyTO> choreographyList() {
        return getService(ConsoleInterfaceService.class).choreographyList();
    }

    public List<ChoreographyInstanceTO> instanceList(final String choreographyId) {
        return getService(ConsoleInterfaceService.class).instanceList(choreographyId);
    }

    public List<CoordinationDelegateTO> cdList(final String instanceId) {
        return getService(ConsoleInterfaceService.class).cdList(instanceId);
    }

    public List<ServiceTO> serviceList(final String instanceId) {
        return getService(ConsoleInterfaceService.class).serviceList(instanceId);
    }

    public List<OperationDataTO> operationList(
            final String choreographyInstancePK,
            final String cdName) {
        return getService(ConsoleInterfaceService.class).operationList(choreographyInstancePK, cdName);
    }

    public List<OperationDataTO> operationList(final String choreographyInstancePK) {
        return getService(ConsoleInterfaceService.class).operationList(choreographyInstancePK);
    }

    public ChoreographyTO getChoreography(final String choreographyId) {
        return getService(ConsoleInterfaceService.class).getChoreography(choreographyId);
    }

    public ChoreographyInstanceTO getChoreographyInstance(final String choreographyInstancePK) {
        return getService(ConsoleInterfaceService.class).getChoreographyInstance(choreographyInstancePK);
    }

    public CoordinationDelegateTO getCD(final String choreographyInstancePK, final String cdName) {
        return getService(ConsoleInterfaceService.class).getCd(choreographyInstancePK, cdName);
    }

    public ServiceTO getService(final String choreographyInstancePK, final String serviceName) {
        return getService(ConsoleInterfaceService.class).getService(choreographyInstancePK, serviceName);
    }

    public Double getAverageInstanceExecutionTime(final String choreographyId) {
        return getService(ConsoleInterfaceService.class).getAverageInstanceExecutionTime(choreographyId);
    }

    public List<AVGCoordinationDelegateTO> averageCdList(final String choreographyId) {
        return getService(ConsoleInterfaceService.class).averageCdList(choreographyId);
    }

    public List<AVGServiceTO> averageServiceList(final String choreographyId) {
        return getService(ConsoleInterfaceService.class).averageServiceList(choreographyId);
    }

    public List<AVGOperationDataTO> averageOperationList(
            final String choreographyId,
            final String cdName) {
        return getService(ConsoleInterfaceService.class).averageOperationList(choreographyId, cdName);
    }

    public void deleteInstance(final String choreographyInstancePK) {
        getService(ConsoleInterfaceService.class).deleteInstance(choreographyInstancePK);
    }
}
