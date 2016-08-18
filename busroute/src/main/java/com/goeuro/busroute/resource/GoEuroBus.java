package com.goeuro.busroute.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goeuro.busroute.api.DirectBusRoute;
import com.goeuro.busroute.model.BusRoute;

/**
 * Root resource (exposed at "goeurobus" path)
 */
@Path("goeurobus")
public class GoEuroBus {

	private static final Logger logger = LoggerFactory.getLogger(GoEuroBus.class);

	public static final String DATA_FILE_NAME = "/routesDataFileExample.txt";

	private static List<BusRoute> busRoutesList = getBusRoutes();

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "json" media type.
	 *
	 * @return String that will be returned as a JSON object response.
	 */
	@Path("direct/{dep_sid}/{arr_sid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public DirectBusRoute getDirectRoute(@PathParam("dep_sid") int depId, @PathParam("arr_sid") int arrId) {
		DirectBusRoute reqBusRoute = new DirectBusRoute(depId, arrId, true);
		logger.info(reqBusRoute.toString());
		return reqBusRoute;
	}

	private static List<BusRoute> getBusRoutes() {
		InputStream stream = null;
		BufferedReader reader = null;
		List<BusRoute> busRoutes = new ArrayList<BusRoute>();

		try {
			stream = GoEuroBus.class.getResourceAsStream(DATA_FILE_NAME);
			reader = new BufferedReader(new InputStreamReader(stream));
			int numberOfRoutes = Integer.parseInt(reader.readLine());
			for (int i = 0; i < numberOfRoutes; i++) {
				String routeDefinition = reader.readLine();
				busRoutes.add(new BusRoute(routeDefinition));
			}
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
			System.exit(1);
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e) {
				logger.error("Error while closing file");
			}
		}
		return busRoutes;
	}
}
