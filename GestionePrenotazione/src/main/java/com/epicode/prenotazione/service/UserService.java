package com.epicode.prenotazione.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.prenotazione.model.User;
import com.epicode.prenotazione.repositories.UserRepository;
import com.epicode.prenotazione.runner.BookingRunner;


@Service
public class UserService {
	Logger log = LoggerFactory.getLogger(BookingRunner.class);
	
	@Autowired @Qualifier("client") private ObjectProvider<User> clientProvider;
	@Autowired UserRepository use;
	
	public User createUser(String userName,String fullName,String email) {
		return clientProvider.getObject().builder()
				.userName(userName)
				.fullName(fullName)
				.email(email).build();
		
	}
	
	public void saveUser(User u) {
		use.save(u);
		log.info(u.getFullName()+ " saved in the database");
		
	}
	 
	public User userFind(Long id) {
		return use.findById(id).get();
	}



}
