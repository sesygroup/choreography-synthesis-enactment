package org.choreos.services.monitor;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import java.util.HashSet;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.choreos.services.monitor.MonitorLogger;
import org.choreos.services.monitor.model.EventData;
import org.choreos.services.monitor.utility.PropertyConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.chorevolution.idm.common.types.ArtifactType;
import eu.chorevolution.idm.common.types.EventType;

public class MonitorLoggerImpl implements MonitorLogger {

	private static Logger logger = LoggerFactory.getLogger(MonitorLoggerImpl.class);

	private static Set<EventData> events;
	
	static {
		events = new HashSet<EventData>();
	}

	@Override
	public void sendEventData(String choreographyName, long choreographyInstanceId, String artifactName, ArtifactType artifactType, String artifactRole, String sourceState, String targetState, String operation, String targetArtifactName, EventType eventType, long eventTimestamp) {
		if (PropertyConfiguration.get("monitor").equals("true")) {
			EventData eventData = new EventData();
			eventData.setChoreographyName(choreographyName);
			eventData.setChoreographyInstanceId(choreographyInstanceId);
			eventData.setArtifactName(artifactName);
			eventData.setArtifactType(artifactType);
			eventData.setArtifactRole(artifactRole);
			eventData.setSourceState(sourceState);
			eventData.setTargetState(targetState);
			eventData.setOperation(operation);
			eventData.setTargetArtifactName(targetArtifactName);
			eventData.setEventType(eventType);
			eventData.setEventTimestamp(eventTimestamp);
			events.add(eventData);
		}
		logger.info("------- Choreography: " + choreographyName + " InstanceId: " + choreographyInstanceId + "--- " + artifactType + ": " + artifactName + " logged " + eventType + " event for the operation: " + operation + " at timestamp " + eventTimestamp + " -------");
	}

	public void sendInstanceData(String choreographyName, Long choreographyInstanceId, String instanceDescription) {
		if (PropertyConfiguration.get("monitor").equals("true")) {
			StringEntity input;
			try {
				HttpClient client = HttpClientBuilder.create().build();
				HttpPost postRequest = new HttpPost("http://" + PropertyConfiguration.get("monitor_host") + ":" + PropertyConfiguration.get("monitor_port") + "/syncope/rest/collector/instance");
				input = new StringEntity("{\"choreographyInstanceId\":" + choreographyInstanceId + "," + "\"instanceDescription\":\"" + instanceDescription + "\"," + "\"choreographyName\":\""+choreographyName+"\"}");
				input.setContentType("application/json");
				postRequest.setEntity(input);
				client.execute(postRequest);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.info("------- Choreography: " + choreographyName + " choreographyInstanceId: " + choreographyInstanceId + " -------");
		}
	}

	@Override
	public void sendToMonitor() {
		if (PropertyConfiguration.get("monitor").equals("true")) {
			if (!events.isEmpty()) {
				HttpClient client = HttpClientBuilder.create().build();
				String jsonList = "[";
				for (EventData event : events) {
					jsonList += "{\"choreographyName\":\"" + event.getChoreographyName()+ "\","
							+ "\"choreographyInstanceId\":\"" + event.getChoreographyInstanceId() + "\","
							+ "\"artifactName\":\"" + event.getArtifactName() + "\","
							+ "\"artifactType\":\"" + event.getArtifactType() + "\","
							+ "\"artifactRole\":\"" + event.getArtifactRole() + "\","
							+ "\"sourceState\":\"" + event.getSourceState() + "\","
							+ "\"targetState\":\"" + event.getTargetState() + "\","
							+ "\"targetArtifactName\":\"" + event.getTargetArtifactName() + "\","
							+ "\"operation\":\"" + event.getOperation() + "\","
							+ "\"eventType\":\"" + event.getEventType() + "\","
							+ "\"eventTimestamp\":" + event.getEventTimestamp() + "},";
				}
				jsonList = jsonList.substring(0, jsonList.length()-1) + "]";
				HttpPost postRequest = new HttpPost("http://" + PropertyConfiguration.get("monitor_host") + ":" + PropertyConfiguration.get("monitor_port") + "/syncope/rest/collector/eventList");
				try {
					StringEntity input = new StringEntity(jsonList);
					input.setContentType("application/json");
					postRequest.setEntity(input);
					client.execute(postRequest);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				logger.info("------- Sent to monitor " + events.size() + " event logs -------");
				events = new HashSet<EventData>();
			}
		}
	}
}
