package com.mf.fuel.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc//detects the existence of Jackson and JAXB 2 on the classpath and automatically creates and registers default JSON and XML converters.
@ComponentScan(basePackages = "com.mf")
public class FUWebConfig {

}
