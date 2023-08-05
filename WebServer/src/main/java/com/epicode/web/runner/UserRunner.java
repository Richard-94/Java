package com.epicode.web.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.web.model.User;
import com.epicode.web.service.UserService;

@Component
public class UserRunner implements CommandLineRunner {
	@Autowired UserService s;

	@Override
	public void run(String... args) throws Exception {
		Logger log = LoggerFactory.getLogger(UserRunner.class);
		
		for(int i =0; i<10;i++){
			
			s.createUser();
		}
	}

}
