package com.epicode.api.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.api.model.Contacts;



@Configuration
public class ContactsConfiguration {
	
	@Bean("contacts")
	@Scope("prototype")
	public Contacts info() {
		return new Contacts();
	}
	

}
