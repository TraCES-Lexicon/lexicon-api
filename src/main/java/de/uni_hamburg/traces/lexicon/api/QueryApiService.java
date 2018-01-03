package de.uni_hamburg.traces.lexicon.api;

import de.uni_hamburg.traces.lexicon.api.NotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

public abstract class QueryApiService extends LexiconApiService {
	public abstract Response queryGet(@Context HttpServletRequest request, @NotNull String string, Boolean translit,
			@Context SecurityContext securityContext, @Context UriInfo uriInfo) throws NotFoundException;
}
