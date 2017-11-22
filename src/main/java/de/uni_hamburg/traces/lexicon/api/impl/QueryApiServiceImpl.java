package de.uni_hamburg.traces.lexicon.api.impl;

import java.util.List;
import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import de.uni_hamburg.traces.lexicon.api.*;
import de.uni_hamburg.traces.lexicon.model.*;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.wagger.api.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-21T15:37:30.051+01:00")
public class QueryApiServiceImpl extends QueryApiService {
    @Override
    public Response queryGet(String string, Boolean translit, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "It's magic!")).build();
    }
}
