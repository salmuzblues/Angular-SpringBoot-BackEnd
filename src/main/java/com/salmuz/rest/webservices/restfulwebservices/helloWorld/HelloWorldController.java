package com.salmuz.rest.webservices.restfulwebservices.helloWorld;

import javax.management.RuntimeErrorException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Controller 
// this RestController which can handle rest requests 
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {

	public HelloWorldController() {
		// TODO Auto-generated constructor stub
	}
	
	// GET 
	//URI - /hello-world
	//Method - "Hello World"
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
	     throw new RuntimeException("Some Error has happend!");
		//return new HelloWorldBean("Hello World-changed");
	}
	
	// create a request which can pass a parameter
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
