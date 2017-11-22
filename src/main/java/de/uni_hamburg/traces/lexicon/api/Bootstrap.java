package de.uni_hamburg.traces.lexicon.api;

import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.*;

import io.swagger.models.auth.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class Bootstrap extends HttpServlet {
  @Override
  public void init(ServletConfig config) throws ServletException {
    Info info = new Info()
      .title("Swagger Server")
      .description("An API that allows users to return accumulated results from different resources from their queries. ## **NOTE** SNAPSHOT, Do not implement! ## **NOTE** Will be superseded by https://swaggerhub.com/apis/sdruskat/traces-lexicon-api/1.0.0-SNAPSHOT ")
      .termsOfService("")
      .contact(new Contact()
        .email(""))
      .license(new License()
        .name("License: tba")
        .url(""));

    ServletContext context = config.getServletContext();
    Swagger swagger = new Swagger().info(info);

    new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);
  }
}
