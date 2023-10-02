package com.work.project.security.checking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.work.project.security.exception.MyAPIException;
import com.work.project.security.exception.NotNullException;

import com.work.project.security.model.Events;
import com.work.project.security.model.SportsEvents;
import com.work.project.security.payload.RegisterDto;

import com.work.project.security.repository.UserRepository;
;

@Service
public class EventsControl {
	 @Autowired UserRepository userRepository;
	 public Object controlNotNull(Events event) {
		    if (event.getAddress() == null) {
		        throw new NotNullException("Address field cannot be empty.");
		    }
		    if (event.getDate() == null) {
		        throw new NotNullException("Date field cannot be null.");
		    }
		    if (event.getDescription() == null) {
		        throw new NotNullException("Date field cannot be null.");
		    }
		    if (event.getDisabilities() == null) {
		        throw new NotNullException("Disabilities field cannot be null.");
		    }
		    if (event.getInfo_event() == null) {
		        throw new NotNullException("You must insert an information about the event.");
		    }
		    if (event.getImageMetadataList() == null) {
		        throw new NotNullException("Insert at least one image.");
		    }
		    if (event.getImageMetadataList().size() > 5) {
		        throw new NotNullException("You can insert only up to 5 images");
		    }
		    if (event.getLocation() == null) {
		        throw new NotNullException("Please insert a Location");
		    }
		    if (event.getOrganizer() == null) {
		        throw new NotNullException("Please specify the name or thee entity of the organizer");
		    }
		    if (event.getParticipants() == null) {
		        throw new NotNullException("Please specify the maximum number of participants else specify that participants for this event are unlimited");
		    }
		    if (event.getPrice() == null) {
		        throw new NotNullException("Please specify the price else specify that it's free");
		    }
		    if (event.getSponsorsList().isEmpty()) {
		       return ("No sponsors for this event");
		    }
		    if (event.getTime() == null) {
			    return ("Please insert a time for the event");
			}
		    if (event.getTitle().isEmpty()) {
			       return ("A Title must be provided for this event");
			}
		    if (event.getTitle().isEmpty()) {
			       return ("A Title must be provided for this event");
			}
		    if (event.getSponsorsList().size()>5) {
			       return ("You can insert up to 5 sponsors");
			}
	
		    if (event instanceof Events) {
		    	SportsEvents sports = (SportsEvents) event;
		        if (sports.getType_of_sports()== null) {
		            throw new NotNullException("Please specify a type of sports");
		        }
		        
		    }
			return event;

	 }
	 
	 public RegisterDto registerAndCheck(RegisterDto registerDto) {
		 // add check for username exists in database
	        if(userRepository.existsByUsername(registerDto.getUsername())){
	            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Username already exists!.");
	        }

	        // add check for email exists in database
	        if(userRepository.existsByEmail(registerDto.getEmail())){
	            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Email  already exists!.");
	        }
	        
	        // add check for secretCode exists in database
//	        if(userRepository.existsBySecretCode(registerDto.getSecretCode())){
//	            throw new MyAPIException(HttpStatus.BAD_REQUEST, "SecretCode is already exists!.");
//	        }
//	        
//	        if(userRepository.existsByTelephone(registerDto.getTelephone())) {
//	        	 throw new MyAPIException(HttpStatus.BAD_REQUEST, "Telephone number  already exists!.");
//	        }
	        return registerDto;
	 }
	 
}


