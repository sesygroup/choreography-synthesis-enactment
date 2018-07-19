package org.choreos.services.enactchoreography;

import java.io.File;

import org.choreos.services.enactchoreography.configuration.Configuration;
import org.choreos.services.enactchoreography.configuration.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexander Perucci
 */
public class EndChoreography {
	private static Logger logger = LoggerFactory.getLogger(EndChoreography.class);
	public static final String USE_CDs_COMPONENT = "use_cds_component";
	public static final String IMAGES_PATH = "." + File.separatorChar + "src" + File.separatorChar + "main" + File.separatorChar + "resources" + File.separatorChar + "images"+File.separatorChar;

	public static void main(String[] args) throws Exception {

		Environment environment = new Environment(Configuration.get("use_cds_component").equals("true") ? true : false);
		try {
			environment.callScenarioSetupForEndChoreography();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error detected: [Message] > ", e.getMessage() + " [Cause] > " + e.getCause());
		}
		
	}
}
