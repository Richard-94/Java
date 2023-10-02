package com.epicode.social.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.epicode.social.model.UserApp;
import com.epicode.social.repository.UserRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	@Autowired @Qualifier ("user") private ObjectProvider<UserApp> userProvider;
	@Autowired UserRepository userRepo;
	
	
	public UserApp createWorker(String task) {
		UserApp us = userProvider.getObject();
			us.setTask(task);
			
		return us;
		
	}
	
	public UserApp saveUser(UserApp wo) {
//		if(userRepo.existsByUsername(wo.getUsername())) {
//			throw new EntityExistsException("Username already exists!!!");
//		}
//		if(userRepo.existsByLinkGit(wo.getLinkGit())) {
//			throw new EntityExistsException("Worker Username already exists!!!");
//		}
		
		return userRepo.save(wo);
		
	}
	
	public UserApp userFind(Long id) {
		if(!userRepo.existsById(id)) {
			throw new EntityNotFoundException("Worker doesn't exists!!!");
		}
		return userRepo.findById(id).get();
	}
	
	public ResponseEntity<String> workerDel(Long id) {
	    if (!userRepo.existsById(id)) {
	        throw new EntityNotFoundException("User not exists!!!");
	    }
	    
	    userRepo.deleteById(id);
	    return new ResponseEntity<>("Worker deleted", HttpStatus.OK);
	}
	
	public List<UserApp> getAllUser(){
		List<UserApp> u = (List<UserApp>) userRepo.findAll();
		return u;
	}
	


}
