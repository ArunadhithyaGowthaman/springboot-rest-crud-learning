package com.learning.fundamentals.exceptionhandling;


//This is the custom exception to handle if the required user is not exist in the database.
public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(Long id) {
		super("User not found with this id"+id);
	}

}
