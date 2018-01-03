/**
 * 
 */
package de.uni_hamburg.traces.lexicon.api.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Queues;

import de.uni_hamburg.traces.lexicon.api.internal.QueryJob.Status;
import de.uni_hamburg.traces.lexicon.model.Result;
import de.uni_hamburg.traces.lexicon.model.ResultBuilder;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class QueryWorker extends Thread {
	
	private static QueryWorker instance;
	
	// Disallow instantiation
	private QueryWorker() {}
	
	public static synchronized QueryWorker getInstance () {
	    if (QueryWorker.instance == null) {
	      QueryWorker.instance = new QueryWorker();
	    }
	    return QueryWorker.instance;
	  }

	private final BlockingQueue<QueryJob> queryQueue = Queues.newLinkedBlockingDeque();
	
	// Use Map instead of Cache as we want to perform hard removal of running jobs
	private final Map<String, QueryJob> runningJobs = new HashMap<>();
	
	private final Cache<String, Result> results = CacheBuilder.newBuilder().
		    maximumSize(100).
		    expireAfterWrite(10, TimeUnit.SECONDS). // Not sure if this value makes sense or should be shorter
		    build();

	@Override
	public void run() {
		while (isAlive()) {
			try {
				QueryJob job = queryQueue.take();
				final String uuid = job.getUuid();
				runningJobs.put(uuid, job);
				Result result = buildResult(job);
				Thread.sleep(15000);
				job.setStatus(Status.SUCCESS);
				results.put(uuid, result);
				boolean jobIsRemoved = runningJobs.remove(uuid, job);
				assert jobIsRemoved;
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * // TODO Add description
	 * @param job 
	 * 
	 * @return
	 */
	private Result buildResult(QueryJob job) {
		Result result = null;
		if (job.getTranslit()) {
			// Query string is a transliteration
			result = new ResultBuilder(job.getUuid()).query(job.getQueryString()).fidal("???").transliteration(job.getQueryString()).build();
		}
		else {
			// Query string is Fidäl
			result = new ResultBuilder(job.getUuid()).query(job.getQueryString()).fidal(job.getQueryString()).transliteration("???").build();
		}
		return result;
	}

	/**
	 * @return the queryQueue
	 */
	public final BlockingQueue<QueryJob> getQueryQueue() {
		return queryQueue;
	}

	/**
	 * @return the runningJobs
	 */
	public final Map<String, QueryJob> getRunningJobs() {
		return runningJobs;
	}

	/**
	 * @return the results
	 */
	public final Cache<String, Result> getResults() {
		return results;
	}

}
