package com.learning.fundamentals.exceptionhandling;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


//This class catches the exception thrown by the service layer and returns a proper httpstatus code for the exception.
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleinvalidinputs(IllegalArgumentException ex){
		return ResponseEntity.badRequest().build();
	}
}
