package com.salmuz.rest.webservices.restfulwebservices.Todo;


import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//	RESTFUL ALLL METHODS POST AND GET 
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoResource {

	// @Service and @Autowired work together. 
	@Autowired
	private TodoHardcodedService todoService;
	
	// Get All  
	@GetMapping(path = "/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return todoService.findAll();
	}
	
	// Get one   
		@GetMapping(path = "/users/{username}/todos/{id}")
		public Todo getTodo(@PathVariable String username, @PathVariable long id){
			return todoService.findById(id);
		}
	//Delete one of the list 
	// ResponseEntity helps us to build specific requests 
	//with specific state assigned.
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id ) {
		Todo todo = todoService.deletebyId(id);
		// successful  deleting 
		if(todo != null ) {
			return ResponseEntity.noContent().build();
		}
		// unsuccessful deleting 
		return ResponseEntity.notFound().build();
	}
	
	//Update method 
	@PutMapping(path="/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo ) {
		System.out.println("retrieve front data: " + todo.getDescription()); 
		System.out.println("Here update method"); 
		Todo todoUpdated = todoService.save(todo); 
		System.out.println("Data: " + todoUpdated.getDescription()); 
		System.out.println("Data: " + todo.getDescription()); 
		
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	
	//we want to do for a created resource is the location of the created resource.
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Void> updateTodo(@PathVariable String username, @RequestBody Todo todo ) {
		Todo createdTodo = todoService.save(todo); 
		//LOCATION 
		//get current resource url	
       //{id}
		// create a specific URI with new id 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();  
		return ResponseEntity.created(uri).build();
	}
}
