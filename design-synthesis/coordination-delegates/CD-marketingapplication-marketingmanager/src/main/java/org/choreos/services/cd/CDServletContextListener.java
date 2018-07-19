package org.choreos.services.cd;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.choreos.services.cd.utility.PropertyConfiguration;
import org.choreos.services.cd.utility.Utilities;
import eu.chorevolution.modelingnotations.coord.COORDModel;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.CoordinationDelegateData;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.CoordinationDelegateFactory;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.impl.CoordinationChannelManagerImpl;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.utility.CoordmetamodelParser;

public class CDServletContextListener implements ServletContextListener{

	private static final String COORD_PATH = CDServletContextListener.class.getClassLoader().getResource(PropertyConfiguration.getInstance().getStringValue("coord_name")).getPath();
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		COORDModel coord = CoordmetamodelParser.parse(COORD_PATH);
    	CoordinationDelegateData coordinationDelegateData = new CoordinationDelegateData();
    	coordinationDelegateData.setInitialState(coord.getInitialState());
    	CoordinationChannelManagerImpl coordinationChannelManager = new CoordinationChannelManagerImpl();
    	coordinationDelegateData.setCoordinationChannelManager(coordinationChannelManager); 	
    	coordinationDelegateData.setCoordModel(coord); 
    	coordinationDelegateData.setCdPriorities(Utilities.createCoordinationDelegatePriorityListFromProperties(PropertyConfiguration.getInstance().getMapValue("cds_priorities")));
     	CoordinationDelegateFactory.addCoordinationDelegateData(PropertyConfiguration.getInstance().getStringValue("cd_name"), coordinationDelegateData);
	}

}
