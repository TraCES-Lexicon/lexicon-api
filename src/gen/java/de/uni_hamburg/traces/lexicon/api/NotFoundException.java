package de.uni_hamburg.traces.lexicon.api;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class NotFoundException extends ApiException {
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
	public NotFoundException(int code, String msg) {
		super(code, msg);
		this.code = code;
	}
}
