package com.salmuz.rest.webservices.restfulwebservices.Todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

//this will act like dateBase;
@Service
public class TodoHardcodedService {
	// create an array to store  todos list with the class Todo which has all attributes, 
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int idCounter = 0;
	// here we are storing 
	static {
		todos.add(new Todo(++idCounter,"Alex", "Learn to Dance", new Date(), false ));
		todos.add(new Todo(++idCounter,"Alex", "Learn about Microservices", new Date(), false ));
		todos.add(new Todo(++idCounter,"Alex", "Learn about angular", new Date(), false ));
	}
	// these methods are from the data base for instance mongdb, sql,etc
	// here we are creating those methods.
	// create a method to return all data. 
	public List <Todo> findAll(){
		return todos;
	}
	
	public Todo deletebyId(long id ) {
		Todo todo = findById(id);
		if(todo == null) return null;
		
		if(todos.remove(todo)) // here remove of specific data;
			return todo;
		// if todos is not getting success 
		return null; 
	}

	public Todo findById(long id) {
		// TODO Auto-generated method stub
		
		for(Todo todo: todos) {
			if(todo.getId() == id)
				return todo;
		}
		return null;
	}
	
	// Save 
	public Todo save(Todo todo) {
		// So at a later point, we'll check the id of the todo. the id of todo is -1, this for insert one 
		if(todo.getId() == -1 || todo.getId() == 0) { // this  is when you add a new todo 
			todo.setId(++idCounter);
			todos.add(todo);
		}else { // when I have to update it, first delete and then adding it 
			deletebyId(todo.getId());
			//todo.setTargetDate(new Date());
			todos.add(todo); // here update todo list 
		}
		return todo;
	}
	
}
