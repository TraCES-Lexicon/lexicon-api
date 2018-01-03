package de.uni_hamburg.traces.lexicon.api;

import de.uni_hamburg.traces.lexicon.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.servlet.http.HttpServletRequest;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public abstract class QueueApiService extends LexiconApiService {
	
    /**
     * // TODO Add description
     * 
     * @param request
     * @param uuid
     * @param securityContext
     * @param uriInfo
     * @return
     * @throws NotFoundException
     */
    public abstract Response queueUuidGet(HttpServletRequest request, String uuid, SecurityContext securityContext, UriInfo uriInfo) throws NotFoundException;
}
