package de.uni_hamburg.traces.lexicon.api.factories;

import de.uni_hamburg.traces.lexicon.api.QueryApiService;
import de.uni_hamburg.traces.lexicon.api.impl.QueryApiServiceImpl;

@javax.annotation.Generated(value = "class io.wagger.api.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-21T15:37:30.051+01:00")
public class QueryApiServiceFactory {
    private final static QueryApiService service = new QueryApiServiceImpl();

    public static QueryApiService getQueryApi() {
        return service;
    }
}
