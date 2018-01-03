package de.uni_hamburg.traces.lexicon.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public abstract class ResultsApiService extends LexiconApiService {
	
	/**
	 * // TODO Add description
	 * 
	 * @param uuid
	 * @param securityContext
	 * @return
	 * @throws NotFoundException
	 */
	public abstract Response resultsUuidGet(String uuid, SecurityContext securityContext) throws NotFoundException;
}
