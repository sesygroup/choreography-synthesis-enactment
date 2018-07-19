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
package org.apache.syncope.core.persistence.jpa.dao;

import eu.chorevolution.idm.common.types.ArtifactType;
import eu.chorevolution.idm.common.types.EventType;
import java.util.List;
import javax.persistence.TypedQuery;
import org.apache.syncope.core.persistence.api.dao.EventDAO;
import org.apache.syncope.core.persistence.api.entity.Event;
import org.apache.syncope.core.persistence.jpa.entity.JPAEvent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JPAEventDAO extends AbstractDAO<Event> implements EventDAO {

    private static final String CLIENT_ARTIFACT_NAME = "Client";

    @Transactional(readOnly = true)
    @Override
    public List<Event> findAll() {
        TypedQuery<Event> query = entityManager().createQuery(
                "SELECT e FROM " + JPAEvent.class.getSimpleName() + " e ",
                Event.class);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    /*
     * Function currently not used to implement business logic of monitor
     */
    public List<Event> findClientInstanceEvents(final String choreographyInstancePK) {
        TypedQuery<Event> query = entityManager().createQuery(
                "SELECT e FROM " + JPAEvent.class.getSimpleName()
                + " e WHERE e.choreographyInstance.id = :choreographyInstancePK"
                + " AND e.artifactName = :artifactName",
                Event.class);
        query.setParameter("choreographyInstancePK", choreographyInstancePK);
        query.setParameter("artifactName", CLIENT_ARTIFACT_NAME);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    /*
     * Function currently not used to implement business logic of monitor
     */
    public List<Event> findByArtifactName(final String choreographyInstancePK, final String artifactName) {
        TypedQuery<Event> query = entityManager().createQuery(
                "SELECT e FROM " + JPAEvent.class.getSimpleName()
                + " e WHERE e.choreographyInstance.id = :choreographyInstancePK"
                + " AND e.artifactName = :artifactName",
                Event.class);
        query.setParameter("choreographyInstancePK", choreographyInstancePK);
        query.setParameter("artifactName", artifactName);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Event> findByOperation(
            final String choreographyInstancePK,
            final String operationName) {
        TypedQuery<Event> query = entityManager().createQuery(
                "SELECT e FROM " + JPAEvent.class.getSimpleName()
                + " e WHERE e.choreographyInstance.id = :choreographyInstancePK"
                + " AND e.operationName = :operationName",
                Event.class);
        query.setParameter("choreographyInstancePK", choreographyInstancePK);
        query.setParameter("operationName", operationName);
        return query.getResultList();
    }

    @Override
    public List<Event> findByEventType(
           final String choreographyInstancePK,
           final String operationName,
           final EventType eventType) {
        TypedQuery<Event> query = entityManager().createQuery(
                "SELECT e FROM " + JPAEvent.class.getSimpleName()
                + " e WHERE e.choreographyInstance.id = :choreographyInstancePK"
                + " AND e.operationName = :operationName"
                + " AND e.eventType = :eventType",
                Event.class);
        query.setParameter("choreographyInstancePK", choreographyInstancePK);
        query.setParameter("operationName", operationName);
        query.setParameter("eventType", eventType);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> findArtifactsByType(final String choreographyInstancePK, final ArtifactType artifactType) {
        TypedQuery<String> query = entityManager().createQuery(
                "SELECT e.artifactName FROM " + JPAEvent.class.getSimpleName()
                + " e WHERE e.choreographyInstance.id = :choreographyInstancePK AND e.artifactType = :artifactType"
                + " GROUP BY e.artifactName",
                String.class);
        query.setParameter("choreographyInstancePK", choreographyInstancePK);
        query.setParameter("artifactType", artifactType);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> findOperationsByArtifact(final String choreographyInstancePK, final String artifactName) {
        TypedQuery<String> query = entityManager().createQuery(
                "SELECT e.operationName FROM " + JPAEvent.class.getSimpleName()
                + " e WHERE e.choreographyInstance.id = :choreographyInstancePK AND e.artifactName = :artifactName"
                + " GROUP BY e.operationName",
                String.class);
        query.setParameter("choreographyInstancePK", choreographyInstancePK);
        query.setParameter("artifactName", artifactName);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> findOperationsByInstance(final String choreographyInstancePK) {
        TypedQuery<String> query = entityManager().createQuery(
                "SELECT e.operationName FROM " + JPAEvent.class.getSimpleName()
                + " e WHERE e.choreographyInstance.id = :choreographyInstancePK"
                + " GROUP BY e.operationName",
                String.class);
        query.setParameter("choreographyInstancePK", choreographyInstancePK);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> findCdsByChoreography(final String choreographyId) {
        TypedQuery<String> query = entityManager().createQuery(
                "SELECT e.artifactName FROM " + JPAEvent.class.getSimpleName()
                + " e WHERE e.choreographyInstance.choreographyId = :choreographyId"
                + " AND e.artifactType = :artifactType"
                + " GROUP BY e.artifactName",
                String.class);
        query.setParameter("choreographyId", choreographyId);
        query.setParameter("artifactType", ArtifactType.CD);
        return query.getResultList();
    }

    @Override
    public List<String> findServicesByChoreography(final String choreographyId) {
        TypedQuery<String> query = entityManager().createQuery(
                "SELECT e.artifactName FROM " + JPAEvent.class.getSimpleName()
                + " e WHERE e.choreographyInstance.choreographyId = :choreographyId"
                + " AND e.artifactType = :artifactType"
                + " GROUP BY e.artifactName",
                String.class);
        query.setParameter("choreographyId", choreographyId);
        query.setParameter("artifactType", ArtifactType.SERVICE);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> findChoreographyOperationsByArtifact(final String choreographyId, final String artifactName) {
        TypedQuery<String> query = entityManager().createQuery(
                "SELECT e.operationName FROM " + JPAEvent.class.getSimpleName()
                + " e WHERE e.choreographyInstance.choreographyId = :choreographyId"
                + " AND e.artifactName = :artifactName"
                + " GROUP BY e.operationName",
                String.class);
        query.setParameter("choreographyId", choreographyId);
        query.setParameter("artifactName", artifactName);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Long getLastEventTimestamp(String choreographyInstancePK) {
        TypedQuery<Long> query = entityManager().createQuery(
                "SELECT max(e.eventTimestamp) FROM " + JPAEvent.class.getSimpleName()
                + " e WHERE e.choreographyInstance.id = :choreographyInstancePK",
                Long.class);
        query.setParameter("choreographyInstancePK", choreographyInstancePK);
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public void save(final Event event) {
        entityManager().persist(event);
    }

    @Transactional
    @Override
    public void delete(final Event event) {
        entityManager().remove(event);
    }

    @Override
    public List<Event> findArtifactEventByType(String choreographyInstancePK, String artifactName, String operationName,
            EventType eventType) {
        TypedQuery<Event> query = entityManager().createQuery(
                "SELECT e FROM " + JPAEvent.class.getSimpleName()
                + " e WHERE e.choreographyInstance.id = :choreographyInstancePK"
                + " AND e.artifactName = :artifactName"
                + " AND e.operationName= :operationName"
                + " AND e.eventType = :eventType"
                + " ORDER BY e.eventTimestamp",
                Event.class);
        query.setParameter("choreographyInstancePK", choreographyInstancePK);
        query.setParameter("artifactName", artifactName);
        query.setParameter("operationName", operationName);
        query.setParameter("eventType", eventType);
        return query.getResultList();
    }

    @Override
    public List<Event> findArtifactOperation(String choreographyInstancePK, String artifactName, String operationName,
            long lowerTimestamp, long upperTimestamp) {
        TypedQuery<Event> query = entityManager().createQuery(
                "SELECT e FROM " + JPAEvent.class.getSimpleName()
                + " e WHERE e.choreographyInstance.id = :choreographyInstancePK"
                + " AND e.artifactName = :artifactName"
                + " AND e.operationName = :operationName"
                + " AND e.eventTimestamp > :lowerTimestamp"
                + " AND e.eventTimestamp < :upperTimestamp",
                Event.class);
        query.setParameter("choreographyInstancePK", choreographyInstancePK);
        query.setParameter("artifactName", artifactName);
        query.setParameter("operationName", operationName);
        query.setParameter("lowerTimestamp", lowerTimestamp);
        query.setParameter("upperTimestamp", upperTimestamp);
        return query.getResultList();
    }

}
