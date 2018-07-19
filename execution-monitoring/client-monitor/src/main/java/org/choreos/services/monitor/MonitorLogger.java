package org.choreos.services.monitor;

import eu.chorevolution.idm.common.types.ArtifactType;
import eu.chorevolution.idm.common.types.EventType;
//import eu.chorevolution.idm.common.types.ImageType;

public interface MonitorLogger {

	public void sendEventData(String choreographyName, long choreographyInstanceId, String artifactName, ArtifactType artifactType, String artifactRole, String sourceState, String targetState, String operation, String targetArtifactName, EventType eventType, long eventTimestamp);
	
	//public void sendChoreographyData(String choreographyName, String choreographyDescription, byte[] diagram, byte[] messageTypes, byte[] image, ImageType imageType);

	public void sendInstanceData(String coreographyName, Long choreographyInstanceId, String instanceDescription);

	public void sendToMonitor();
}
