package com.epicode.prenotazione.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.prenotazione.model.Building;
import com.epicode.prenotazione.model.Location;
import com.epicode.prenotazione.model.Prenotation;
import com.epicode.prenotazione.model.User;

@Configuration
public class PrenotationConfiguration {
	@Bean("place")
	@Scope("prototype")
	public Location locate() {
		return new Location();
	}
	
	@Bean("build")
	@Scope("prototype")
	public Building building() {
		return new Building();
	}
	
	@Bean("client")
	@Scope("prototype")
	public User user() {
		return new User();
	}
	
	@Bean("booking")
	@Scope("prototype")
	public Prenotation prenotation() {
		return new Prenotation();
	}
	
	
}
