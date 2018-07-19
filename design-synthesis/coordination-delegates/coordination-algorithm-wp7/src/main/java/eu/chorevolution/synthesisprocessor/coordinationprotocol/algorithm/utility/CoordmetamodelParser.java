/*******************************************************************************
 *
 * Copyright 2015 The CHOReVOLUTION project
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *        http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *  
 *******************************************************************************/
package eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.utility;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.chorevolution.modelingnotations.coord.COORDModel;
import eu.chorevolution.modelingnotations.coord.impl.CoordPackageImpl;

public class CoordmetamodelParser {

	private static Logger logger = LoggerFactory.getLogger(CoordmetamodelParser.class);
	
	static {
		CoordPackageImpl.init();
	}

	public static COORDModel parse(String modelFileName) {
		URI fileURI = URI.createFileURI(modelFileName);
		Resource resource = new XMIResourceFactoryImpl().createResource(fileURI);

		try {
			resource.load(null);
			COORDModel coord = (COORDModel) resource.getContents().get(0);
			return coord;
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
		return null;
	}

}
