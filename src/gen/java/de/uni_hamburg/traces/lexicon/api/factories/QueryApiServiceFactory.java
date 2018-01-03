package de.uni_hamburg.traces.lexicon.api.factories;

import de.uni_hamburg.traces.lexicon.api.QueryApiService;
import de.uni_hamburg.traces.lexicon.api.impl.QueryApiServiceImpl;


public class QueryApiServiceFactory {
    private final static QueryApiService service = new QueryApiServiceImpl();

    public static QueryApiService getQueryApi() {
//    	service.init();
        return service;
    }
}
