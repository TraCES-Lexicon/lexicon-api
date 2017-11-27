package de.uni_hamburg.traces.lexicon.api;

import de.uni_hamburg.traces.lexicon.api.*;
import de.uni_hamburg.traces.lexicon.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import de.uni_hamburg.traces.lexicon.model.Result;

import java.util.List;
import de.uni_hamburg.traces.lexicon.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


public abstract class QueryApiService {
    public abstract Response queryGet(String string,Boolean translit,SecurityContext securityContext) throws NotFoundException;
}
