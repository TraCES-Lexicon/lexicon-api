package de.uni_hamburg.traces.lexicon.api.factories;

import de.uni_hamburg.traces.lexicon.api.QueueApiService;
import de.uni_hamburg.traces.lexicon.api.impl.QueueApiServiceImpl;


public class QueueApiServiceFactory {
    private final static QueueApiService service = new QueueApiServiceImpl();

    public static QueueApiService getQueueApi() {
        return service;
    }
}
