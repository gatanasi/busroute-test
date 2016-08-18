package com.goeuro.busroute;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.goeuro.busroute.resource.GoEuroBus;

public class BusRouteServiceTest {

	private HttpServer server;
	private WebTarget target;

	@Before
	public void setUp() throws Exception {
		GoEuroBus.createWithBusRoutesPath("src/main/resources/routesDataFileExample.txt");

		server = Main.startServer();

		Client c = ClientBuilder.newClient();

		target = c.target(Main.BASE_URI);
	}

	@After
	public void tearDown() throws Exception {
		server.shutdown();
	}

	@Test
	public void testGetCorrectDirectRoute() {
		String responseMsg = target.path("goeurobus/direct/1/2").request().get(String.class);
		assertEquals("{\"dep_sid\":1,\"arr_sid\":2,\"direct_bus_route\":true}", responseMsg);
	}

	@Test
	public void testGetDirectRoute() {
		String responseMsg = target.path("goeurobus/direct/10/3").request().get(String.class);
		assertEquals("{\"dep_sid\":10,\"arr_sid\":3,\"direct_bus_route\":false}", responseMsg);
	}
}
