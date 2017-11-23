package de.uni_hamburg.traces.lexicon.api.impl;

import de.uni_hamburg.traces.lexicon.api.*;
import de.uni_hamburg.traces.lexicon.model.*;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 */
public class QueryApiServiceImpl extends QueryApiService {
    @Override
    public Response queryGet(String string, Boolean translit, SecurityContext securityContext) throws NotFoundException {
    	Result result = null;
    	if (string == null) {
    		Status status = Status.BAD_REQUEST;
    		return Response.status(status).entity(new ApiResponseMessage(status, "No query string provided.")).build();
    	}
    	if (translit) {
    		result = new Result().transliteration(string).fidal("Fidal string will be generated by logic in future versions.");
    	}
    	else {
    		result = new Result().fidal(string).transliteration("Transliteration string will be generated by logic in future versions.");
    	}
    	result.query(string);
        return Response.ok(result).build();
    }
}
