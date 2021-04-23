package com.CRUD.customers.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebbAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
	    appContext.register(WebMvcConfig.class);
	    //Create a servlet
	    Dynamic dispather_servlet = servletContext.addServlet("springDispather",new DispatcherServlet(appContext)); 
	    dispather_servlet.setLoadOnStartup(1);
	    dispather_servlet.addMapping("/");
	}

}
