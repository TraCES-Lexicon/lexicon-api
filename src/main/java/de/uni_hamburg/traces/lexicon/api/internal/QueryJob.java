/**
 * 
 */
package de.uni_hamburg.traces.lexicon.api.internal;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class QueryJob {

	/**
	 * Processing status of the job.
	 */
	public enum Status {
		/**
		 * Waits to be started.
		 */
		WAITING,
		/**
		 * Query is running.
		 */
		RUNNING,
		/**
		 * Query finished successfully.
		 */
		SUCCESS,
		/**
		 * Query finished with an error.
		 */
		ERROR
	}

	private String uuid;
	
	private Status status;
	
	private String queryString;
	
	private Boolean translit;

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the uuid
	 */
	public final String getUuid() {
		return uuid;
	}

	/**
	 * @return the status
	 */
	public final Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public final void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the queryString
	 */
	public final String getQueryString() {
		return queryString;
	}

	/**
	 * @param queryString the queryString to set
	 */
	public final void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	/**
	 * @return the translit
	 */
	public final Boolean getTranslit() {
		return translit;
	}

	/**
	 * @param translit the translit to set
	 */
	public final void setTranslit(Boolean translit) {
		this.translit = translit;
	}

}
