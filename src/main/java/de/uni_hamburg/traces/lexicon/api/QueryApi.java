package de.uni_hamburg.traces.lexicon.api;

import de.uni_hamburg.traces.lexicon.api.QueryApiService;
import de.uni_hamburg.traces.lexicon.api.factories.QueryApiServiceFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import de.uni_hamburg.traces.lexicon.api.NotFoundException;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
@Path("/query")
@Api
public class QueryApi {
	private final QueryApiService delegate;

	/**
	 * // TODO Add description
	 * 
	 * @param servletContext
	 */
	public QueryApi(@Context ServletConfig servletContext) {
		QueryApiService delegate = null;

		if (servletContext != null) {
			String implClass = servletContext.getInitParameter("QueryApi.implementation");
			if (implClass != null && !"".equals(implClass.trim())) {
				try {
					delegate = (QueryApiService) Class.forName(implClass).newInstance();
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}

		if (delegate == null) {
			delegate = QueryApiServiceFactory.getQueryApi();
		}

		this.delegate = delegate;
	}

	/**
	 * // TODO Add description
	 * 
	 * @param string
	 * @param translit
	 * @param securityContext
	 * @param request
	 * @param uriInfo
	 * @return
	 * @throws NotFoundException
	 */
	@GET
	@io.swagger.annotations.ApiOperation(value = "queries the API", notes = "Query the API to return an accumulated result", response = Void.class, tags = {})
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 202, message = "Accepted query", response = Void.class),
			@io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Void.class) })
	public Response queryGet(@ApiParam(value = "The query string", required = true) @QueryParam("string") String string,
			@ApiParam(value = "Whether the query string is a transliteration (true) or a Fidal string (false, default)", defaultValue = "false") @DefaultValue("false") @QueryParam("translit") Boolean translit,
			@Context SecurityContext securityContext, @Context HttpServletRequest request, @Context UriInfo uriInfo) throws NotFoundException {
		return delegate.queryGet(request, string, translit, securityContext, uriInfo);
	}
}