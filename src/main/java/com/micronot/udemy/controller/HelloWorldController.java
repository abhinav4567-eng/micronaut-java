package com.micronot.udemy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.context.annotation.Property;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/hello")
public class HelloWorldController {      
	
	private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);
	
//	@Inject
//	private HelloWorldService service;  //Field based Injection
//	
	
//	private final HelloWorldService service;          //Constructor based Injection
//	
//	public HelloWorldController(HelloWorldService service) {
//		this.service = service;
//		
//	}
	
	private final MyService service;                 //Interface based Injection
	private final String helloFromConfig;
	private final HelloWorldTranslationConfig translationConfig;
	
	public HelloWorldController(MyService service,
			                      @Property(name = "hello.world.message") String helloFromConfig,
			                      HelloWorldTranslationConfig translationConfig) {
		this.service = service;
		this.helloFromConfig = helloFromConfig;
		this.translationConfig = translationConfig;
	}
	
	@Get(produces = MediaType.TEXT_PLAIN)
	public String helloWorld() {
		
		LOG.debug("Called the hello World API");
		return service.helloFromService();	
		
	}
	
	@Get(uri = "/config", produces = MediaType.TEXT_PLAIN)
	public String helloConfig() {
		LOG.debug("Return Hello from Config Message: {}", helloFromConfig);
		return helloFromConfig;
	}
	
	@Get(uri = "/translation", produces = MediaType.APPLICATION_JSON)
	public HelloWorldTranslationConfig helloTranslation() {
		return translationConfig;
	}
	
	

}
