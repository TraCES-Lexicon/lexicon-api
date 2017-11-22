package de.uni_hamburg.traces.lexicon.api;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import java.util.List;
import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import de.uni_hamburg.traces.lexicon.api.NotFoundException;
import de.uni_hamburg.traces.lexicon.api.QueryApiService;
import de.uni_hamburg.traces.lexicon.api.factories.QueryApiServiceFactory;
import de.uni_hamburg.traces.lexicon.model.*;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/query")


@io.swagger.annotations.Api(description = "the query API")
@javax.annotation.Generated(value = "class io.wagger.api.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-21T15:37:30.051+01:00")
public class QueryApi  {
   private final QueryApiService delegate = QueryApiServiceFactory.getQueryApi();

    @GET
    
    
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "queries the API", notes = "Query the API to return an accumulated result", response = Result.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Result.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Result.class) })
    public Response queryGet(@ApiParam(value = "The query string",required=true) @QueryParam("string") String string
,@ApiParam(value = "Whether the query string is a transliteration (true) or a Fidäl string (false, default)", defaultValue="true") @DefaultValue("true") @QueryParam("translit") Boolean translit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.queryGet(string,translit,securityContext);
    }
}
