package com.goeuro.busroute;

import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goeuro.busroute.resource.GoEuroBus;

/**
 * Main class.
 *
 */
public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	// Base URI the Grizzly HTTP server will listen on
	public static final String BASE_URI = "http://localhost:8088/rest/provider";

	/**
	 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
	 * application.
	 * 
	 * @return Grizzly HTTP server.
	 */
	public static HttpServer startServer() {
		// create a resource config that scans for JAX-RS resources and
		// providers in com.goeuro.busroute package
		ResourceConfig rc = new ResourceConfig().packages("com.goeuro.busroute", "com.fasterxml.jackson.jaxrs.json");

		// create and start a new instance of grizzly http server
		// exposing the Jersey application at BASE_URI
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
	}

	public static void main(String[] args) {
		if (args != null) {
			startService(args[0]);
		} else {
			System.out.println("Missing arguments");
		}
	}

	public static void startService(String dataFilePath) {
		GoEuroBus.createWithBusRoutesPath(dataFilePath);
		startServer();
		logger.info(String.format("Jersey app started with WADL available at " + "%sapplication.wadl\n", BASE_URI));
	}

}
