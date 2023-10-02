package com.epicode.social.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.social.model.UserApp;
import com.epicode.social.repository.UserRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	@Autowired @Qualifier ("user") private ObjectProvider<UserApp> userProvider;
	@Autowired UserRepository userRepo;
	
	
	public UserApp createWorker(String linkGit,String image,String username) {
		UserApp us = userProvider.getObject();
			us.setLinkGit(linkGit);
			us.setImage(image);
			us.setUsername(username);
		return us;
		
	}
	
	public UserApp saveUser(UserApp wo) {
		if(userRepo.existsByUsername(wo.getUsername())) {
			throw new EntityExistsException("Username already exists!!!");
		}
		if(userRepo.existsByLinkGit(wo.getLinkGit())) {
			throw new EntityExistsException("Worker Username already exists!!!");
		}
		
		return userRepo.save(wo);
		
	}
	
	public UserApp userFind(Long id) {
		if(!userRepo.existsById(id)) {
			throw new EntityNotFoundException("Worker doesn't exists!!!");
		}
		return userRepo.findById(id).get();
	}
	
	
	
	public List<UserApp> getAllUser(){
		List<UserApp> u = (List<UserApp>) userRepo.findAll();
		return u;
	}
	


}
