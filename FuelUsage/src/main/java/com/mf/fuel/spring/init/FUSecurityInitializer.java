package com.mf.fuel.spring.init;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Initializes the security context
 * 
 * @author sudhansub
 *
 */
public class FUSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

//This code below is commented as we are using AbstractAnnotationConfigDispatcherServletInitializer to initialize the context.
//Uncommenting this code will create error for duplicate initialization 
//    public FUSecurityInitializer() {
//        super(FUSecurityConfig.class);
//    }
}
