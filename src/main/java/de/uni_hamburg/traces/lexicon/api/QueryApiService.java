package de.uni_hamburg.traces.lexicon.api;

import de.uni_hamburg.traces.lexicon.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


public abstract class QueryApiService {
    public abstract Response queryGet(String string,Boolean translit,SecurityContext securityContext) throws NotFoundException;
}
