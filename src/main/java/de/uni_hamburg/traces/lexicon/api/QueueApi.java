/**
 * 
 */
package de.uni_hamburg.traces.lexicon.api;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import de.uni_hamburg.traces.lexicon.api.factories.QueueApiServiceFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
@Path("/queue")
@Api
public class QueueApi {
	private final QueueApiService delegate;

	/**
	 * // TODO Add description
	 * 
	 * @param servletContext
	 */
	public QueueApi(@Context ServletConfig servletContext) {
		QueueApiService delegate = null;

		if (servletContext != null) {
			String implClass = servletContext.getInitParameter("QueueApi.implementation");
			if (implClass != null && !"".equals(implClass.trim())) {
				try {
					delegate = (QueueApiService) Class.forName(implClass).newInstance();
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}

		if (delegate == null) {
			delegate = QueueApiServiceFactory.getQueueApi();
		}

		this.delegate = delegate;
	}

	/**
	 * // TODO Add description
	 * 
	 * @param uuid
	 * @param securityContext
	 * @param request
	 * @param uriInfo
	 * @return
	 * @throws NotFoundException
	 */
	@GET
	@Path("/{uuid}")
	@io.swagger.annotations.ApiOperation(value = "Returns queued query items", notes = "Provides access to the queue of query items", response = Void.class, tags = {})
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 204, message = "No content. Query is still processing.", response = Void.class),

			@io.swagger.annotations.ApiResponse(code = 303, message = "Query finished, see result URI.", response = Void.class),

			@io.swagger.annotations.ApiResponse(code = 404, message = "Query with this UUID not found in queue.", response = Void.class),

			@io.swagger.annotations.ApiResponse(code = 410, message = "Query is not queued anymore.", response = Void.class),
			
			@io.swagger.annotations.ApiResponse(code = 404, message = "Invalid queue UUID.", response = Void.class) })
	public Response queueUuidGet(@ApiParam(value = "", required = true) @PathParam("uuid") String uuid,
			@Context SecurityContext securityContext, @Context HttpServletRequest request, @Context UriInfo uriInfo) throws NotFoundException {
		return delegate.queueUuidGet(request, uuid, securityContext, uriInfo);
	}
}