package com.epicode.social.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


import com.epicode.social.model.UserApp;


@Configuration
public class UserConfiguration {

	@Bean("user")
	@Scope("prototype")
	public UserApp user() {
		return new UserApp();
	}
	
	

}
