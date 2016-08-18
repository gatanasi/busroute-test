package com.goeuro.busroute;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "goeurobus" path)
 */
@Path("goeurobus")
public class GoEuroBus {

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
		DirectBusRoute reqBusRoute = DirectBusRoute.existsDirectRoute(depId, arrId);
		return reqBusRoute;
	}
}
