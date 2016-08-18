package com.goeuro.busroute;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyResourceTest {

	private HttpServer server;
	private WebTarget target;

	@Before
	public void setUp() throws Exception {
		server = Main.startServer();

		Client c = ClientBuilder.newClient();

		target = c.target(Main.BASE_URI);
	}

	@After
	public void tearDown() throws Exception {
		server.shutdown();
	}

	@Test
	public void testGetDirectRoute() {
		String responseMsg = target.path("goeurobus/direct/10/3").request().get(String.class);
		System.out.println(responseMsg);
		// assertEquals("Got it!", responseMsg);
	}

}
