package com.goeuro.busroute;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DirectBusRoute {
	@JsonProperty(value = "dep_sid")
	private int depId;
	private int arrId;
	private boolean directBusRoute = false;

	public DirectBusRoute() {
		super();
	}

	public DirectBusRoute(int depId, int arrId, boolean directBusRoute) {
		super();
		this.depId = depId;
		this.arrId = arrId;
		this.directBusRoute = directBusRoute;
	}

	public static DirectBusRoute existsDirectRoute(int depId, int arrId) {
		DirectBusRoute newRoute = new DirectBusRoute(depId, arrId, true);
		return newRoute;
	}

	@JsonProperty(value = "dep_sid")
	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	@JsonProperty(value = "arr_sid")
	public int getArrId() {
		return arrId;
	}

	public void setArrId(int arrId) {
		this.arrId = arrId;
	}

	@JsonProperty(value = "direct_bus_route")
	public boolean isDirectBusRoute() {
		return directBusRoute;
	}

	public void setDirectBusRoute(boolean directBusRoute) {
		this.directBusRoute = directBusRoute;
	}
}
