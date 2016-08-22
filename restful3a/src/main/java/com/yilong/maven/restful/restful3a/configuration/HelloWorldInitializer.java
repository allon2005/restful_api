package com.yilong.maven.restful.restful3a.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class HelloWorldInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return  new Class[]{HelloWorldConfiguration.class}; //this is create the application context and dispatchservlet from the config class
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null; //no servlet container used. So, return null
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};  //if use this, the URI will be: localhost:8080/restful3aDemo/hello/rr
		//return new String[]{"/rest/*"}; //if use this, the URI will be: localhost:8080/restful3aDemo/rest/hello/rr
	}

}
