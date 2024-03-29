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
package org.apache.syncope.core.persistence.api.dao;

import java.util.List;
import org.apache.syncope.core.persistence.api.entity.ChoreographyInstance;

public interface ChoreographyInstanceDAO extends DAO<ChoreographyInstance> {

    List<ChoreographyInstance> findAll();

    List<ChoreographyInstance> findByChoreographyId(String choreographyId);

    ChoreographyInstance findById(String id);

    ChoreographyInstance findByChoreographyInstanceId(String choreographyId, String choreographyInstanceId);
    
    void save(ChoreographyInstance choreographyInstance);

    void delete(ChoreographyInstance choreographyInstance);

}
