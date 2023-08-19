package com.epicode.dispositivi.security.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;



@ControllerAdvice
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> manageEntityNotFoundException(EntityNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<String> manageEntityExistsException(EntityExistsException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
	}
	
	 @ExceptionHandler(InvalidTypeException.class)
	    public ResponseEntity<String> manageInvalidTypeException(InvalidTypeException e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	 
	 @ExceptionHandler(NotNullException.class)
	 public ResponseEntity<String> handleNotNullException(NotNullException e) {
	     return ResponseEntity.badRequest().body(e.getMessage());
	 }

}
