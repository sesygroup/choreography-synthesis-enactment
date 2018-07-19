package org.choreos.services.monitor.model;

import eu.chorevolution.idm.common.types.ArtifactType;
import eu.chorevolution.idm.common.types.EventType;

public class EventData {

	private String choreographyName;
	private long choreographyInstanceId;
	private String artifactName;
	private ArtifactType artifactType;
	private String artifactRole;
	private String sourceState;
	private String targetState;
	private String operation;
	private String targetArtifactName;
	private EventType eventType;
	private long eventTimestamp;

	public String getChoreographyName() {
		return choreographyName;
	}
	public void setChoreographyName(String choreographyName) {
		this.choreographyName = choreographyName;
	}
	public long getChoreographyInstanceId() {
		return choreographyInstanceId;
	}
	public void setChoreographyInstanceId(long choreographyInstanceId) {
		this.choreographyInstanceId = choreographyInstanceId;
	}
	public String getArtifactName() {
		return artifactName;
	}
	public void setArtifactName(String artifactName) {
		this.artifactName = artifactName;
	}
	public ArtifactType getArtifactType() {
		return artifactType;
	}
	public void setArtifactType(ArtifactType artifactType) {
		this.artifactType = artifactType;
	}
	public String getArtifactRole() {
		return artifactRole;
	}
	public void setArtifactRole(String artifactRole) {
		this.artifactRole = artifactRole;
	}
	public String getSourceState() {
		return sourceState;
	}
	public void setSourceState(String sourceState) {
		this.sourceState = sourceState;
	}
	public String getTargetState() {
		return targetState;
	}
	public void setTargetState(String targetState) {
		this.targetState = targetState;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getTargetArtifactName() {
		return targetArtifactName;
	}
	public void setTargetArtifactName(String targetArtifactName) {
		this.targetArtifactName = targetArtifactName;
	}
	public EventType getEventType() {
		return eventType;
	}
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
	public long getEventTimestamp() {
		return eventTimestamp;
	}
	public void setEventTimestamp(long eventTimestamp) {
		this.eventTimestamp = eventTimestamp;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EventData) {
			EventData event = (EventData) obj;
			return this.artifactName.equals(event.getArtifactName()) && this.eventTimestamp==event.getEventTimestamp();
		} else {
			return false;
		}
	}

}
