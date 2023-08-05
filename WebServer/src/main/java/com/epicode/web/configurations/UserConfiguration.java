package com.epicode.web.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.web.model.User;

@Configuration
public class UserConfiguration {
	@Bean("client")
	@Scope("prototype")
	public User user() {
		return new User();
	}

}
