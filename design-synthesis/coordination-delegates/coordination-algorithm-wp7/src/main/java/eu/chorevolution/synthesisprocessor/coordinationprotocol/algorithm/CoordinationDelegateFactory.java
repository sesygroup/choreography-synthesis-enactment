/*
* Copyright 2015 The CHOReVOLUTION project
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

package eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.chorevolution.modelingnotations.coord.COORDModel;
import eu.chorevolution.modelingnotations.coord.CoordFactory;
import eu.chorevolution.modelingnotations.coord.State;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.impl.CoordinationDelegateAlgorithmImpl;
import eu.chorevolution.synthesisprocessor.coordinationprotocol.algorithm.model.CoordinationDelegateID;

public class CoordinationDelegateFactory {

	static final Logger logger = LoggerFactory.getLogger(CoordinationDelegateFactory.class);

	private static Map<CoordinationDelegateID, CoordinationDelegateAlgorithm> CDS = Collections.synchronizedMap(new HashMap<CoordinationDelegateID, CoordinationDelegateAlgorithm>());

	private static Map<String, CoordinationDelegateData> coordsData = Collections.synchronizedMap(new HashMap<String, CoordinationDelegateData>());

	private static Map<String, String> address = Collections.synchronizedMap(new HashMap<String, String>());

	public synchronized static CoordinationDelegateAlgorithm getCoordinationDelegateAlgorithm(CoordinationDelegateID id, String coordinationDelegateFrom) {

		if (!CDS.containsKey(id)) {
			CoordinationDelegateData data = coordsData.get(id.getCoordinatedServiceEndpointName());
			State initialState = CoordFactory.eINSTANCE.createState();
			initialState.setName(data.getInitialState().getName());
			GlobalStateManager globalStateManager = new GlobalStateManager(initialState);
			CoordinationDelegateAlgorithm result = new CoordinationDelegateAlgorithmImpl(id, coordinationDelegateFrom, globalStateManager, data);
			CDS.put(id, result);
		}
		return CDS.get(id);

	}

	public synchronized static void addCoordinationDelegateData(String coordinatedServiceEndpointName, CoordinationDelegateData data) {
		coordsData.put(coordinatedServiceEndpointName, data);
	}

	public synchronized static boolean containsAddress(String name) {
		return address.containsKey(name);
	}

	public synchronized static void removeAddress(String name) {
		address.remove(name);
	}

	public synchronized static void addAddress(String name, String endpoint) {
		address.put(name, endpoint);
	}

	public synchronized static String getAddress(String name) {
		return address.get(name);
	}

	public synchronized static COORDModel getCOORDModel(String cdName) {
		return coordsData.get(cdName).getCoordModel();
	}

	public synchronized static Set<String> getAddressKeys() {
		return address.keySet();
	}
}
