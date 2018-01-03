package de.uni_hamburg.traces.lexicon.api.impl;

import de.uni_hamburg.traces.lexicon.api.*;
import de.uni_hamburg.traces.lexicon.api.internal.QueryJob;

import java.net.URI;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 */
public class QueryApiServiceImpl extends QueryApiService {

	@GET
	@Path("query")
	@Override
	public Response queryGet(@Context HttpServletRequest request, @QueryParam("string") String queryString, @QueryParam("translit") Boolean translit,
			SecurityContext securityContext, @Context UriInfo uriInfo) throws NotFoundException {
		QueryJob job = new QueryJob();
		UUID uuid = UUID.randomUUID();
		job.setUuid(uuid.toString());
		job.setStatus(QueryJob.Status.WAITING);
		job.setQueryString(queryString);
		job.setTranslit(translit);
		try {
			queryWorker.getQueryQueue().put(job);
			// 202 ACCEPTED
			URI uri = uriInfo.getBaseUriBuilder().path("queue/" + uuid).build();
			return Response.status(Response.Status.ACCEPTED)
					.header("Location", uri).build();
		}
		catch (InterruptedException ex) {
			return Response.serverError()
					.entity("Could not add job to " + "import queue. There might be more information in the server "
							+ "log files. Contact the administrator if necessary.")
					.build();
		}
	}
	
}
