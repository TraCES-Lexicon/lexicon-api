package de.uni_hamburg.traces.lexicon.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


public abstract class QueryApiService {
    /**
     * // TODO Add description
     * 
     * @param string
     * @param translit
     * @param securityContext
     * @return
     * @throws NotFoundException
     */
    public abstract Response queryGet(String string,Boolean translit,SecurityContext securityContext) throws NotFoundException;
}
