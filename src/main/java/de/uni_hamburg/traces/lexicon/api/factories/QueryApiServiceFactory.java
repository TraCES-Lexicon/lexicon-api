package de.uni_hamburg.traces.lexicon.api.factories;

import de.uni_hamburg.traces.lexicon.api.QueryApiService;
import de.uni_hamburg.traces.lexicon.api.impl.QueryApiServiceImpl;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class QueryApiServiceFactory {
    private final static QueryApiService service = new QueryApiServiceImpl();

    /**
     * // TODO Add description
     * 
     * @return
     */
    public static QueryApiService getQueryApi() {
        return service;
    }
}
