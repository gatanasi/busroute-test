package com.goeuro.busroute.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the JSON response for the RestFul micro service
 *
 */
public class DirectBusRoute {

	@JsonProperty(value = "dep_sid")
	private int depId;

	@JsonProperty(value = "arr_sid")
	private int arrId;

	@JsonProperty(value = "direct_bus_route")
	private boolean directBusRoute = false;

	public DirectBusRoute(int depId, int arrId, boolean directBusRoute) {
		super();
		this.depId = depId;
		this.arrId = arrId;
		this.directBusRoute = directBusRoute;
	}

	@Override
	public String toString() {
		return "DirectBusRoute [depId=" + depId + ", arrId=" + arrId + ", directBusRoute=" + directBusRoute + "]";
	}

}
