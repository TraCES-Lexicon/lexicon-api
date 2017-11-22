package de.uni_hamburg.traces.lexicon.api;

import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
@XmlRootElement
public class ApiResponseMessage {

	int code;
	String type;
	String message;

	/**
	 * // TODO Add description
	 * 
	 */
	public ApiResponseMessage() {
	}

	/**
	 * // TODO Add description
	 * 
	 * @param status
	 * @param message
	 */
	public ApiResponseMessage(Status status, String message) {
		this.code = status.getStatusCode();
		setType(status.getReasonPhrase());
		this.message = message;
	}

	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public int getCode() {
		return code;
	}

	/**
	 * // TODO Add description
	 * 
	 * @param code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * // TODO Add description
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * // TODO Add description
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
