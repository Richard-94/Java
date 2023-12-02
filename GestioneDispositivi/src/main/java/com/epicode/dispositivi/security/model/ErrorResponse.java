package com.epicode.dispositivi.security.model;

public class ErrorResponse {
	 //private final String error;
	    private final String message;

	    public ErrorResponse(String message) {
	        //this.error = error;
	        this.message = "Username non esiste";
	    }

//	    public String getError() {
//	        return error;
//	    }

	    public String getMessage() {
	        return message;
	    }

}
