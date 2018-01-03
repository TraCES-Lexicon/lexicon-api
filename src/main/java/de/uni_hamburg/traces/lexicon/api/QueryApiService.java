package de.uni_hamburg.traces.lexicon.api;

import de.uni_hamburg.traces.lexicon.api.NotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public abstract class QueryApiService extends LexiconApiService {
	
	/**
	 * // TODO Add description
	 * 
	 * @param request
	 * @param string
	 * @param translit
	 * @param securityContext
	 * @param uriInfo
	 * @return
	 * @throws NotFoundException
	 */
	public abstract Response queryGet(@Context HttpServletRequest request, @NotNull String string, Boolean translit,
			@Context SecurityContext securityContext, @Context UriInfo uriInfo) throws NotFoundException;
}
