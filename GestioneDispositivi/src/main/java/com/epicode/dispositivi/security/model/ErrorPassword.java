package com.epicode.dispositivi.security.model;

public class ErrorPassword {
	private final String message;
	
	  public ErrorPassword(String message) {
	        
	        this.message = "Password Sbagliata";
	    }
	  
	  public String getMessage() {
	        return message;
	    }


}
