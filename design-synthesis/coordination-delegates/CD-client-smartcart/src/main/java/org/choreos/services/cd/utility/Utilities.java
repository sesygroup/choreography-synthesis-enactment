package org.choreos.services.cd.utility;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.soap.Node;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMException;

import eu.chorevolution.modelingnotations.coord.COORDModel;
import eu.chorevolution.modelingnotations.coord.NotifyElement;
import eu.chorevolution.modelingnotations.coord.State;
import eu.chorevolution.modelingnotations.coord.Tuple;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.priorities.CoordinationDelegatePriorityList;

public class Utilities {
	
    private static Logger logger = LoggerFactory.getLogger(Utilities.class);
	
	public static String getRoleSetInvocationAddressMessage(SOAPMessage message){
		
		String role = null;
		try {
			role = message.getSOAPBody().getElementsByTagName("arg0").item(0).getTextContent();
		} catch (DOMException | SOAPException e) {
			logger.debug(e.getStackTrace().toString());
		}
		return role;
	}
	
	public static String getNameSetInvocationAddressMessage(SOAPMessage message){
		
		String name = null;
		try {
			name = message.getSOAPBody().getElementsByTagName("arg1").item(0).getTextContent();
		} catch (DOMException | SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	public static List<String> getEndpointsSetInvocationAddressMessage(SOAPMessage message){
		
		List<String> endpoints = null;
		try {
			if(message.getSOAPBody().getElementsByTagName("arg2") != null){
				endpoints = new ArrayList<String>();
				for (int i = 0; i < message.getSOAPBody().getElementsByTagName("arg2").getLength(); i++) {
					Node node=(Node) message.getSOAPBody().getElementsByTagName("arg2").item(i);
					endpoints.add(node.getTextContent());
				}
			}
		} catch (DOMException | SOAPException e) {
			logger.debug(e.getStackTrace().toString());
		}
		return endpoints;
	}

    public static SOAPMessage createSetInvocationAddressMessageResponse(SOAPMessage message) {

        String body ="<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"><SOAP-ENV:Header/>"
        		+ "<S:Body><ns:setInvocationAddressResponse xmlns:ns=\"http://services.choreos.org/\"></ns:setInvocationAddressResponse></S:Body></S:Envelope>";
	    try {
			message.getSOAPPart().setContent((Source) new StreamSource(new StringReader(body)));
		} catch (SOAPException e) {
			logger.debug(e.getStackTrace().toString());
		}
        return message;
    }	
    
    public static CoordinationDelegatePriorityList createCoordinationDelegatePriorityListFromProperties(Map<String,String> priorities){

		CoordinationDelegatePriorityList coordinationDelegatePriorityList = new CoordinationDelegatePriorityList();
    	for (Entry<String, String> prioritiesItem : priorities.entrySet()) {
    		coordinationDelegatePriorityList.addCoordinationDelegateProrityElement(prioritiesItem.getKey(),Integer.parseInt(prioritiesItem.getValue()));
		}
    	return coordinationDelegatePriorityList;
    }
    
    public static int getNumberCoordinationMessagesOperation(COORDModel coord,String operation){
		 	
    	int numMessages = 0;     	
    	Tuple tuple = getTupleFromOperation(coord, operation);
		numMessages = getNumberCoordinationMessagesTuple(tuple);
		List<Tuple> tuples=findTuplesFromSourceState(coord, tuple.getTargetState());
		for (Tuple tuple2 : tuples) {
			numMessages = getNumberCoordinationMessagesFromTuple(coord, numMessages, tuple2);
		}		
    	return numMessages;
    }

    public static Tuple getTupleFromOperation(COORDModel coord,String operation){
    	
	   	for (Tuple tuple : coord.getTuples()) {
			if(tuple.getAllowedOperation()!=null && tuple.getAllowedOperation().getName().equals(operation)){
				return tuple;
			}
	   	}
	   	return null;
    }
    
    public static List<Tuple> findTuplesFromSourceState(COORDModel coord,State state){
    	
    	List<Tuple> tuples = new ArrayList<Tuple>();
    	for (Tuple tuple : coord.getTuples()){
    		if(tuple.getSourceState().getName().equals(state.getName())){
    			tuples.add(tuple);
    		}			
		}
    	return tuples;
    }
    	
    public static int getNumberCoordinationMessagesFromTuple(COORDModel coord,int numMessages,Tuple tuple){
    	
    	List<Tuple> tuples;
    	numMessages += getNumberCoordinationMessagesTuple(tuple);
		tuples = findTuplesFromSourceState(coord, tuple.getTargetState());
		for (Tuple tuple2 : tuples) {
			numMessages = getNumberCoordinationMessagesFromTuple(coord,numMessages,tuple2);
		}
		return numMessages;
    }
    
    public static int getNumberCoordinationMessagesTuple(Tuple tuple){
    	
    	int numMessage = 0;
    	if(tuple.getCondition().equals("true") && tuple.getAllowedComponentInTargetState()!=null){
    		numMessage+=tuple.getAllowedComponentInTargetState().size();
    	}
    	if(tuple.getCondition().equals("true") && tuple.getNotify()!=null){
    		for (NotifyElement notifyElement : tuple.getNotify().getElements()) {
           		numMessage+=notifyElement.getParticipants().size();
			}
    	}
    	return numMessage;
    }
}
