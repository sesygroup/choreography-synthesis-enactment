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

package org.apache.syncope.core.rest.cxf.service;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Resource;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.AccessDeniedException;
import org.apache.syncope.common.lib.patch.AnyObjectPatch;
import org.apache.syncope.common.lib.search.SpecialAttr;
import org.apache.syncope.common.lib.to.AnyObjectTO;
import org.apache.syncope.common.lib.to.PagedResult;
import org.apache.syncope.common.lib.to.UserTO;
import org.apache.syncope.common.lib.types.AnyEntitlement;
import org.apache.syncope.common.rest.api.beans.AnyQuery;
import org.apache.syncope.common.rest.api.service.AnyObjectService;
import org.apache.syncope.core.logic.AbstractAnyLogic;
import org.apache.syncope.core.logic.AnyObjectLogic;
import org.apache.syncope.core.logic.RoleLogic;
import org.apache.syncope.core.provisioning.api.data.UserDataBinder;
import org.apache.syncope.core.spring.security.AuthContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnyObjectServiceImpl extends AbstractAnyService<AnyObjectTO, AnyObjectPatch> implements AnyObjectService {

    @Autowired
    private AnyObjectLogic logic;

    @Override
    protected AbstractAnyLogic<AnyObjectTO, AnyObjectPatch> getAnyLogic() {
        return logic;
    }

    @Override
    protected AnyObjectPatch newPatch(final String key) {
        AnyObjectPatch patch = new AnyObjectPatch();
        patch.setKey(key);
        return patch;
    }

    @Override
    public PagedResult<AnyObjectTO> search(final AnyQuery anyQuery) {
        if (StringUtils.isBlank(anyQuery.getFiql())
                || -1 == anyQuery.getFiql().indexOf(SpecialAttr.TYPE.toString())) {

            throw new BadRequestException(SpecialAttr.TYPE.toString() + " is required in the FIQL string");
        }

        return super.search(anyQuery);
    }

    // ---------------------------
    // CHOREVOLUTION: overriding to check for service provider entitlements (CRV-188)
    // ---------------------------
    @Resource(name = "adminUser")
    private String adminUser;

    @Autowired
    private RoleLogic roleLogic;

    @Autowired
    protected UserDataBinder binder;

    private static final String SERVICE_PROVIDER_ROLE = "Service provider";

    @Override
    public Response update(final AnyObjectPatch anyPatch) {
        checkForSPEntitlements(anyPatch.getKey());
        return super.update(anyPatch);
    }

    @Override
    public Response update(final AnyObjectTO anyTO) {
        checkForSPEntitlements(anyTO.getKey());
        return super.update(anyTO);
    }

    private void checkForSPEntitlements(final String key) {
        if (adminUser.equals(AuthContextUtils.getUsername())) {
            return;
        }

        final AnyObjectTO anyObjectTO = logic.read(key);

        final UserTO requestor = binder.getUserTO(AuthContextUtils.getUsername());
        final Set<String> roles = new HashSet<>(requestor.getRoles());
        roles.addAll(requestor.getDynRoles());
        roles.remove(SERVICE_PROVIDER_ROLE);

        final Set<String> entitlements = new HashSet<>();

        for (String role : roles) {
            entitlements.addAll(roleLogic.read(role).getEntitlements());
        }

        if (!entitlements.contains(AnyEntitlement.READ.getFor(anyObjectTO.getType()))
                && !anyObjectTO.getCreator().equals(requestor.getUsername())) {
            throw new AccessDeniedException("Access denied");
        }
    }
    // ---------------------------
}
