package me.doflamingo;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebApplication implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
    webApplicationContext.register(WebConfig.class);
    webApplicationContext.setServletContext(servletContext);


    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
    applicationContext.register(AppConfig.class);
    servletContext.addListener(new ContextLoaderListener(applicationContext));


    DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
    ServletRegistration.Dynamic app = servletContext.addServlet("app", dispatcherServlet);
    app.addMapping("/app/*");
  }
}
