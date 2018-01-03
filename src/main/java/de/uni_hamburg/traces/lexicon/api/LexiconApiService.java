/**
 * 
 */
package de.uni_hamburg.traces.lexicon.api;

import de.uni_hamburg.traces.lexicon.api.internal.QueryWorker;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class LexiconApiService {
	
	protected final QueryWorker queryWorker = QueryWorker.getInstance();

	public LexiconApiService() {
//		executor.execute(queryWorker);
		if (!queryWorker.isAlive()) {
			queryWorker.start();
		}
		// FIXME: CHECK WHERE TO STOP THREAD! > Executor
	}

}
