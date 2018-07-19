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
package org.apache.syncope.common.rest.api.service;

import eu.chorevolution.idm.common.to.AVGCoordinationDelegateTO;
import eu.chorevolution.idm.common.to.AVGOperationDataTO;
import eu.chorevolution.idm.common.to.AVGServiceTO;
import eu.chorevolution.idm.common.to.ChoreographyInstanceTO;
import eu.chorevolution.idm.common.to.ChoreographyTO;
import eu.chorevolution.idm.common.to.CoordinationDelegateTO;
import eu.chorevolution.idm.common.to.OperationDataTO;
import eu.chorevolution.idm.common.to.ServiceTO;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * REST consoleinterface services.
 */
@Path("consoleinterface")
public interface ConsoleInterfaceService extends JAXRSService {

    /**
     * This is a temporary method.
     * 
     * @return all defined choreographies 
     */
    @Path("choreographies")
    @GET
    List<ChoreographyTO> choreographyList();

    /**
     * This is a temporary method.
     *
     * @param choreographyPK
     * @return all instances of selected choreography
     */
    @Path("{choreographyId}/instances")
    @GET
    List<ChoreographyInstanceTO> instanceList(@PathParam("choreographyId") String choreographyPK);

    /**
     * This is a temporary method.
     *
     * @param choreographyInstancePK
     * @return all CDs of selected choreography instance
     */
    @Path("/{choreographyInstancePK}/cds")
    @GET
    List<CoordinationDelegateTO> cdList(@PathParam("choreographyInstancePK") String choreographyInstancePK);

    @Path("/{choreographyInstancePK}/serviceList")
    @GET
    List<ServiceTO> serviceList(@PathParam("choreographyInstancePK") String choreographyInstancePK);

    /**
     *
     * @param choreographyInstancePK
     * @param cdName
     * @return all operations performed by selected CD
     */
    @Path("/{choreographyInstancePK}/{cdname}/operations")
    @GET
    List<OperationDataTO> operationList(
            @PathParam("choreographyInstancePK") String choreographyInstancePK,
            @PathParam("cdname") String cdName
    );

    /**
     *
     * @param choreographyInstancePK
     * @return all operations performed by selected CD
     */
    @Path("/{choreographyInstancePK}/operations")
    @GET
    List<OperationDataTO> operationList(
            @PathParam("choreographyInstancePK") String choreographyInstancePK
    );

    /**
     *
     * @param choreographyId
     * @return choreography
     */
    @Path("/choreography/{choreographyId}")
    @GET
    ChoreographyTO getChoreography(@PathParam("choreographyId") String choreographyId);

    /**
     *
     * @param choreographyInstancePK
     * @return choreography instance
     */
    @Path("/instance/{choreographyInstancePK}")
    @GET
    ChoreographyInstanceTO getChoreographyInstance(@PathParam("choreographyInstancePK") String choreographyInstancePK);

    /**
     *
     * @param choreographyInstancePK
     * @param cdName
     * @return coordination delegate
     */
    @Path("/cd/{cdName}/{choreographyInstancePK}")
    @GET
    CoordinationDelegateTO getCd(
            @PathParam("choreographyInstancePK") String choreographyInstancePK,
            @PathParam("cdName") String cdName
    );

    @Path("/service/{serviceName}/{choreographyInstancePK}")
    @GET
    ServiceTO getService(
            @PathParam("choreographyInstancePK") String choreographyInstancePK,
            @PathParam("serviceName") String serviceName
    );

    /**
     *
     * @param choreographyId
     * @return average execution time
     */
    @Path("{choreographyId}/instancesAverage")
    @GET
    Double getAverageInstanceExecutionTime(@PathParam("choreographyId") String choreographyId);

    @Path("{choreographyId}/averageCds")
    @GET
    List<AVGCoordinationDelegateTO> averageCdList(@PathParam("choreographyId") String choreographyId);

    @Path("{choreographyId}/averageServices")
    @GET
    List<AVGServiceTO> averageServiceList(@PathParam("choreographyId") String choreographyId);

    @Path("{choreographyId}/{cdName}/averageOperations")
    @GET
    List<AVGOperationDataTO> averageOperationList(
            @PathParam("choreographyId") String choreographyId,
            @PathParam("cdName") String cdName);

    /**
     * Deltes instance
     *
     * @param choreographyInstancePK choreography instance
     */
    @Path("instance/{choreographyInstancePK}")
    @DELETE
    void deleteInstance(@PathParam("choreographyInstancePK") String choreographyInstancePK);
}
