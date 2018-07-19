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
package org.apache.syncope.core.logic.init;

import eu.chorevolution.idm.common.ChorevolutionEntitlement;
import org.apache.syncope.core.persistence.api.SyncopeLoader;
import org.apache.syncope.core.provisioning.api.EntitlementsHolder;
import org.springframework.stereotype.Component;

@Component
public class MonitorLoader implements SyncopeLoader {

    @Override
    public Integer getPriority() {
        return 1100;
    }

    @Override
    public void load() {
        EntitlementsHolder.getInstance().init(ChorevolutionEntitlement.values());
    }
}
