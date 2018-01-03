package de.uni_hamburg.traces.lexicon.api;

import de.uni_hamburg.traces.lexicon.api.*;
import de.uni_hamburg.traces.lexicon.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;


import java.util.List;
import de.uni_hamburg.traces.lexicon.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.*;

public abstract class QueueApiService extends LexiconApiService {
    public abstract Response queueUuidGet(HttpServletRequest request, String uuid, SecurityContext securityContext) throws NotFoundException;
}
