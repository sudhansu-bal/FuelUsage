package com.mf.fuel.spring.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.mf.fuel.spring.config.FUSecurityConfig;
import com.mf.fuel.spring.config.FUWebConfig;

/**
 * For bootstrapping the application.this class will be scanned by Spring on application startup and bootstrapped. 
 * This class has one responsibility: assemble the web application's moving parts, like you would in a web.xml
 * 
 * @author sudhansub
 *
 */
public class FUWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("========================Registering the Security Config=================================");
		return new Class[] { FUSecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Register the web config
		System.out.println("========================Registering the Web Config=================================");
		return new Class[] { FUWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
