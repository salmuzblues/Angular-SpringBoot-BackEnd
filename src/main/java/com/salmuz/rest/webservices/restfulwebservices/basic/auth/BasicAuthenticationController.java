package com.salmuz.rest.webservices.restfulwebservices.basic.auth;



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
public class BasicAuthenticationController {

	public BasicAuthenticationController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(path = "/basicauth")
	public AuthenticationBean helloWorldBean() {
	     //throw new RuntimeException("Some Error has happend!");
		return new AuthenticationBean("You are authenticated");
	}
	
	
}
