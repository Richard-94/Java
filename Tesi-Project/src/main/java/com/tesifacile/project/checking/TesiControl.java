package com.tesifacile.project.checking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesifacile.project.exception.NotNullException;
import com.tesifacile.project.model.RicieveMessage;
import com.tesifacile.project.repository.TesiRepository;

;

@Service
public class TesiControl {
	 @Autowired TesiRepository tesiRepository;
	
	 
	 public Object controlNotNull(RicieveMessage ricieve) {

		    if (ricieve.getName() == null || ricieve.getName() == "") {
		        throw new NotNullException("Inserire un nome");
		    }
		    
		    if (ricieve.getMessage() == null || ricieve.getMessage() == "") {
		        throw new NotNullException("Inserire il messaggio");
		    }
			return ricieve;

	 }
	 
	 public RicieveMessage controlNameExistance(RicieveMessage name) {
		    RicieveMessage userName = tesiRepository.findByName(name.getName());
		    if (userName != null && userName.getName().equals(name.getName())) {
		        throw new NotNullException("Hai gia inserito un messaggio");
		    }
		    return name;
		}

	 
	 
//	 public RegisterDto registerAndCheck(RegisterDto registerDto) {
//		 // add check for username exists in database
//	        if(userRepository.existsByUsername(registerDto.getUsername())){
//	            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Username already exists!.");
//	        }
//
//	        // add check for email exists in database
//	        if(userRepository.existsByEmail(registerDto.getEmail())){
//	            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Email  already exists!.");
//	        }
//	        if(userRepository.existsByTelephone(registerDto.getTelephone())){
//	            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Telephone  already exists!.");
//	        }
//
//
//	        // add check for secretCode exists in database
//	        if(userRepository.existsBySecretCode(registerDto.getSecretCode())){
//	            throw new MyAPIException(HttpStatus.BAD_REQUEST, "SecretCode is already exists!.");
//	        }
//
//	        if(userRepository.existsByTelephone(registerDto.getTelephone())) {
//	        	 throw new MyAPIException(HttpStatus.BAD_REQUEST, "Telephone number  already exists!.");
//	        }
//
//	        if(registerDto.getName()==null) {
//	        	throw new NotNullException("Name cannot be empty");
//	        }
//
//
//	        if(registerDto.getAddress()==null) {
//	        	throw new NotNullException("Address field cannot be empty");
//	        }
//
//	        if(registerDto.getEmail()==null) {
//	        	throw new NotNullException("Email cannot be empty");
//	        }
//
//	        if(registerDto.getPassword()==null) {
//	        	throw new NotNullException("Password cannot be empty");
//	        }
//
//	        if(registerDto.getTelephone()==null) {
//	        	throw new NotNullException("Telephone cannot be empty");
//	        }
//
//	        if(registerDto.getUsername()==null) {
//	        	throw new NotNullException("Username cannot be empty");
//	        }
//	        return registerDto;
//	 }


}


