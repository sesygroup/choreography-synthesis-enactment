package org.choreos.services.cd.utility;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyConfiguration {
	
     private static Logger logger = LoggerFactory.getLogger(PropertyConfiguration.class);
     private static String PROPERTIES_FILE = "configuration.properties";
	 private static PropertyConfiguration instance = null;
	 private Map<String,Object> props = new HashMap<String,Object>();
	 
	 private PropertyConfiguration(){
		 
		 try {
	         Properties properties = new Properties();
	         properties.load(PropertyConfiguration.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
	         for(String key : properties.stringPropertyNames()) {
	        	if(key.equals("cds_priorities")){
	        		Map<String,String> priorities = new HashMap<String,String>();
	        		List<String> prioritiesItems = Arrays.asList(properties.getProperty("cds_priorities").split(","));
	        		for (String prioritiesItem : prioritiesItems) {
	        			List<String> item = Arrays.asList(prioritiesItem.split(":"));
	        			priorities.put(item.get(0),item.get(1));
					}
	        		props.put("cds_priorities",priorities);
	        	}
	        	else{
		            props.put(key, properties.getProperty(key));      		
	        	}
	         }
	     }catch (IOException e) {
	    	 logger.info(e.getMessage());
	     }
	 }
	 
	 public static synchronized PropertyConfiguration getInstance(){
	      
		 if (instance == null)
	           instance = new PropertyConfiguration();
	     return instance;
	 }

	 public String getStringValue(String key){
	 
		 return (String) props.get(key);
	 }
	 
	 public Map<String,String> getMapValue(String key){
		 
		 return (Map<String, String>) props.get(key);
	 }
	 
	 

}
