package de.uni_hamburg.traces.lexicon.api;

import io.swagger.jaxrs.config.SwaggerContextService; 
import io.swagger.models.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class Bootstrap extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		Info info = new Info()
				.title("TraCES Ge'ez Lexicon API")
				.description("An API that allows users to return accumulated results from different resources from their queries. ## **NOTE** SNAPSHOT, Do not implement! ## **NOTE** Will be superseded by https://swaggerhub.com/apis/sdruskat/traces-lexicon-api/1.0.0-SNAPSHOT ")
				.contact(new Contact().name("Stephan Druskat").url("http://sdruskat.net"))
				.license(new License().name("License: tba"));

		Swagger swagger = new Swagger().info(info);

		new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);
	}
	
	@Override
	public void destroy() {
		System.out.println("DESTROY!");
	}
}
