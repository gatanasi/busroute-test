package com.goeuro.busroute.model;

import java.util.ArrayList;
import java.util.List;

public class BusRoute {

	private int busId;

	private List<Integer> stations;

	public BusRoute(String routeDefinition) {
		super();

		String[] routeArray = routeDefinition.split("[\\s+]");
		if (routeArray.length < 3) {
			throw new IllegalArgumentException("Bad route specification: " + routeDefinition);
		} else {
			try {
				this.busId = Integer.parseInt(routeArray[0]);

				stations = new ArrayList<Integer>();

				for (int i = 1; i < routeArray.length; i++) {
					stations.add(Integer.parseInt(routeArray[i]));
				}
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(
						"Bad graph specification: " + routeDefinition + ": contains an invalid integer");
			}
		}
	}

	public int getBusId() {
		return busId;
	}

	public List<Integer> getStations() {
		return stations;
	}
}
