package com.epicode.prenotazione.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.prenotazione.constants.Type;
import com.epicode.prenotazione.model.Location;
import com.epicode.prenotazione.model.Prenotation;
import com.epicode.prenotazione.model.User;
import com.epicode.prenotazione.repositories.UserRepository;
import com.epicode.prenotazione.runner.BookingRunner;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;


@Service
public class UserService {
	Logger log = LoggerFactory.getLogger(User.class);
	
	@Autowired @Qualifier("client") private ObjectProvider<User> clientProvider;
	@Autowired UserRepository use;
	
	public User createUser(String userName,String fullName,String email) {
		return clientProvider.getObject().builder()
				.userName(userName)
				.fullName(fullName)
				.email(email).build();
		
	}
	
	public User saveUser(User u) {
		if(use.existsByEmail(u.getEmail())) {
			throw new EntityExistsException("User email exists!!!");
		}
		return use.save(u);
		
	}
	 
	public User userFind(Long id) {
		if(!use.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
		}
		return use.findById(id).get();
	}
	
	public String userdel(Long id) {
		if(!use.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
		}
		 use.deleteById(id);
		 return "contact deleted";
	}
	
	
	public User updateUser(Long id, User u) {
		if(!use.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
		}
		if(id != u.getId()) {
			throw new EntityNotFoundException("Id and UserID do not match!");
		}
		
		return use.save(u);
	}
	
	
	public List<User> getAllUsers(){
		List<User> u = (List<User>) use.findAll();
		return u;
	}
	


	



}
