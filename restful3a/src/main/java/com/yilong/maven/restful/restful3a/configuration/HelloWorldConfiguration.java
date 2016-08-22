package com.yilong.maven.restful.restful3a.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration //this class can be used as bean definition. Inside this class, we can have @Bean on method to define beans

@EnableWebMvc
/*When you're using Java code (as opposed to XML) to configure your Spring application, @EnableWebMvc is used to enable Spring MVC.
 * @EnableWebMvc is equivalent to <mvc:annotation-driven /> in XML. It enables support for @Controller-annotated classes 
 * that use @RequestMapping to map incoming requests to a certain method. 
 */

@ComponentScan(basePackages="com.yilong.maven.restful.restful3a")
/*Configures component scanning
 * Provides support parallel with Spring XML's <context:component-scan> element. 
 */
public class HelloWorldConfiguration {

}

/*
 * Why we create an empty class with those annotations? 
 * Just serve for initializtion????
 * 
 * answer:
 * Here this class is mainly providing the component-scanning and annotation support.Note that we don’t have any view-resolvers configured 
 * as we don't need one in Rest case.
 */


