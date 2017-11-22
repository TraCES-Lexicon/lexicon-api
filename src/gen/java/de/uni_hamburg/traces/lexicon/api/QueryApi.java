package de.uni_hamburg.traces.lexicon.api;

import io.swagger.annotations.ApiParam;
import de.uni_hamburg.traces.lexicon.api.NotFoundException;
import de.uni_hamburg.traces.lexicon.api.QueryApiService;
import de.uni_hamburg.traces.lexicon.api.factories.QueryApiServiceFactory;
import de.uni_hamburg.traces.lexicon.model.*;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
@Path("/query")
@io.swagger.annotations.Api(produces="application/json, application/xml")

public class QueryApi  {
   private final QueryApiService delegate = QueryApiServiceFactory.getQueryApi();

    /**
     * // TODO Add description
     * 
     * @param string
     * @param translit
     * @param securityContext
     * @return
     * @throws NotFoundException
     */
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @io.swagger.annotations.ApiOperation(value = "queries the API", notes = "Query the API to return an accumulated result", response = Result.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Result.class), @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Result.class) })
    public Response queryGet(@ApiParam(value = "The query string",required=true) @QueryParam("string") String string,
    		@ApiParam(value = "Whether the query string is a transliteration (true) or a Fidäl string (false, default)", defaultValue="false") @DefaultValue("false") @QueryParam("translit") Boolean translit,
    		@Context SecurityContext securityContext) 
    				throws NotFoundException {
        return delegate.queryGet(string,translit,securityContext);
    }
}
