package de.uni_hamburg.traces.lexicon.api;

import de.uni_hamburg.traces.lexicon.api.ResultsApiService;
import de.uni_hamburg.traces.lexicon.api.factories.ResultsApiServiceFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import de.uni_hamburg.traces.lexicon.model.Result;

import de.uni_hamburg.traces.lexicon.api.NotFoundException;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
@Path("/results")
@Api

public class ResultsApi {
	private final ResultsApiService delegate;

	/**
	 * // TODO Add description
	 * 
	 * @param servletContext
	 */
	public ResultsApi(@Context ServletConfig servletContext) {
		ResultsApiService delegate = null;

		if (servletContext != null) {
			String implClass = servletContext.getInitParameter("ResultsApi.implementation");
			if (implClass != null && !"".equals(implClass.trim())) {
				try {
					delegate = (ResultsApiService) Class.forName(implClass).newInstance();
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}

		if (delegate == null) {
			delegate = ResultsApiServiceFactory.getResultsApi();
		}

		this.delegate = delegate;
	}

	/**
	 * // TODO Add description
	 * 
	 * @param uuid
	 * @param securityContext
	 * @return
	 * @throws NotFoundException
	 */
	@GET
	@Path("/{uuid}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@io.swagger.annotations.ApiOperation(value = "Returns a result", notes = "Provides access to the finished result objects", response = Result.class, tags = {})
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = Result.class),

			@io.swagger.annotations.ApiResponse(code = 400, message = "Illegal result UUID", response = Void.class),

			@io.swagger.annotations.ApiResponse(code = 404, message = "Result with UUID cannot be found.", response = Void.class),

			@io.swagger.annotations.ApiResponse(code = 410, message = "Result is not available anymore.", response = Void.class) })
	public Response resultsUuidGet(@ApiParam(value = "", required = true) @PathParam("uuid") String uuid,
			@Context SecurityContext securityContext) throws NotFoundException {
		return delegate.resultsUuidGet(uuid, securityContext);
	}
}
