package com.goeuro.busroute;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BusRouteTest {

	@Test
	public void testBusRoute() {
		String routeDefinition = "0 6 3 4 1 4";
		BusRoute newRoute = new BusRoute(routeDefinition);
		assertEquals(0, newRoute.getBusId());
		assertEquals(new Integer(6), newRoute.getStations().get(0));
		assertEquals(new Integer(3), newRoute.getStations().get(1));
		assertEquals(new Integer(4), newRoute.getStations().get(2));
		assertEquals(new Integer(1), newRoute.getStations().get(3));
		assertEquals(new Integer(4), newRoute.getStations().get(4));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIncompleteBusRoute() {
		String routeDefinition = "1 6";
		new BusRoute(routeDefinition);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWrongBusRoute() {
		String routeDefinition = "2 2 1 4 T";
		new BusRoute(routeDefinition);
	}
}
