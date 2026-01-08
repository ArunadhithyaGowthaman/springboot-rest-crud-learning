package com.learning.fundamentals.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.learning.fundamentals.model.User;
import com.learning.fundamentals.service.UserService;

@RestController
@RequestMapping("students/api/")
public class Controller {
	
	private final UserService service;
	
	//We inject the required dependency for this class using constructor injection.
	public Controller(UserService service) {
		this.service=service;
	}
	
	//This controller saves a new user in database and returns a proper httpstatus code by using responseentity.
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		if(user.getName()==null&&user.getName().isBlank()) {
			throw new IllegalArgumentException("Name must be mandatory.");
		}
		return new ResponseEntity<>(service.saveUsers(user),HttpStatus.CREATED);
	}
	
	//This request is used to fetch all users from the database and returns a proper httpstatus code by using responseEntity.
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(service.getAllUser());
	}
	
	//This request is used to fetch a particular user from the database and returns a proper httpstatus code by using responseEntity.
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		return ResponseEntity.ok(service.getUserById(id));
	}
	
	//This request is used to update a user with new value alredy exist in the db and returns a proper httpstatus code by using responseEntity.
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable Long id,@RequestBody User user){
		return ResponseEntity.ok(service.updateUserById(id, user));
	}
	
	//This request is used to delete a particular user in the database and returns a proper httpstatus code by using responseentity.
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
		return ResponseEntity.noContent().build();
	}
	
	
	

}
