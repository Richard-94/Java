package com.epicode.web.service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.web.model.User;
import com.epicode.web.repositories.UserDaoRepository;
import com.github.javafaker.Faker;

import java.util.List;




@Service
public class UserService {
	Logger log = LoggerFactory.getLogger(UserService.class);
	@Autowired @Qualifier("client") private ObjectProvider<User> clientProvider;
	@Autowired UserDaoRepository use;
	
	
	public User createUser() {
	    Faker faker = new Faker(new Locale("it-IT"));

	    User c = clientProvider.getObject().builder()
	            
	            .fullName(faker.name().fullName())
	            .email(faker.internet().emailAddress())
	            .age(faker.number().numberBetween(18, 60))
	            .city(faker.address().city())
	            .build();
	    use.save(c);

	    return c;
	}



	
	public void saveUser(User u) {
		use.save(u);
		log.info(u.getFullName()+ " saved in the database");
		
	}
	
	public Optional<User> getUser(Long id) {
	    return use.findById(id);
	}

	
	 
	public List<User> getAll() {
		return (List<User>) use.findAll();
	}
	
}
