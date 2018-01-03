package de.uni_hamburg.traces.lexicon.api.factories;

import de.uni_hamburg.traces.lexicon.api.ResultsApiService;
import de.uni_hamburg.traces.lexicon.api.impl.ResultsApiServiceImpl;


public class ResultsApiServiceFactory {
    private final static ResultsApiService service = new ResultsApiServiceImpl();

	public static ResultsApiService getResultsApi() {
		return service;
	}
}
