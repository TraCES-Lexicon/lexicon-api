package de.uni_hamburg.traces.lexicon.api;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import de.uni_hamburg.traces.lexicon.api.*;
import de.uni_hamburg.traces.lexicon.model.*;

import java.util.List;
import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.wagger.api.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-21T15:37:30.051+01:00")
public abstract class QueryApiService {
    public abstract Response queryGet(String string,Boolean translit,SecurityContext securityContext) throws NotFoundException;
}
