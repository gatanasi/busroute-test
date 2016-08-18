package com.goeuro.busroute.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a route of a bus
 *
 */
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + busId;
		result = prime * result + ((stations == null) ? 0 : stations.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusRoute other = (BusRoute) obj;
		if (busId != other.busId)
			return false;
		if (stations == null) {
			if (other.stations != null)
				return false;
		} else if (!stations.equals(other.stations))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BusRoute [busId=" + busId + ", stations=" + stations + "]";
	}

}
