package de.uni_hamburg.traces.lexicon.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import io.swagger.util.Json;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
@Provider
@Produces({ MediaType.APPLICATION_JSON })
public class JacksonJsonProvider extends JacksonJaxbJsonProvider {
	private static ObjectMapper commonMapper = Json.mapper();

	/**
	 * // TODO Add description
	 * 
	 */
	public JacksonJsonProvider() {
		super.setMapper(commonMapper);
	}
}