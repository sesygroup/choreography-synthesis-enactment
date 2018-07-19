/*
 * Copyright 2015 The CHOReVOLUTION project
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

import eu.chorevolution.idm.common.to.ChoreographyInstanceTO;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import eu.chorevolution.idm.common.to.EventDataTO;
import java.util.List;

/**
 * REST collector services.
 */
@Path("collector")
public interface CollectorService extends JAXRSService {

    /**
     * This method collects events from choreography execution
     *
     * @param data
     */
    @Path("logevent")
    @POST
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    void logEvent(@NotNull EventDataTO data);

    /**
     * This method collects a list of events coming from choreography execution
     *
     * @param data
     */
    @Path("eventList")
    @POST
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    void eventList(@NotNull List<EventDataTO> data);

    @Path("instance")
    @POST
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    void addInstance(@NotNull ChoreographyInstanceTO choreographyInstanceTO);
}
