package com.epicode.api.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.api.service.ContactsService;

@Component
public class ContactsRunner implements CommandLineRunner {
	@Autowired ContactsService u;

	@Override
	public void run(String... args) throws Exception {
//		for(int i = 0; i<10;i++) {
//			u.creatContacts();
//		}
		
	}

}
