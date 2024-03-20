package com.micronot.udemy.controller;

import jakarta.inject.Singleton;

@Singleton
public class HelloWorldService implements MyService {
	
//	String helloFromService() {
//	return "Hello from Service";
//}
	

	@Override
	public String helloFromService() {
		// TODO Auto-generated method stub
		return "Hello from Service";
	}
	


	
}
