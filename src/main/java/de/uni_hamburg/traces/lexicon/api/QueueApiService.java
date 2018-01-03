package de.uni_hamburg.traces.lexicon.api;

import de.uni_hamburg.traces.lexicon.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.servlet.http.HttpServletRequest;

public abstract class QueueApiService extends LexiconApiService {
    public abstract Response queueUuidGet(HttpServletRequest request, String uuid, SecurityContext securityContext) throws NotFoundException;
}
