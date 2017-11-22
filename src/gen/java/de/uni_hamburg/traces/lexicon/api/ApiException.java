package de.uni_hamburg.traces.lexicon.api;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class ApiException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private int code;

	/**
	 * // TODO Add description
	 * 
	 * @param code
	 * @param msg
	 */
	public ApiException(int code, String msg) {
		super(msg);
		this.code = code;
	}
}
