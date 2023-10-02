package com.work.project.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.work.project.security.model.ImageMetadata;
import com.work.project.security.model.SportsEvents;



@Configuration
public class EventsConfiguration {
	@Bean("sports")
	@Scope("prototype")
	public SportsEvents sports() {
		return new SportsEvents();
	}
	
	@Bean("images")
	@Scope("prototype")
	public ImageMetadata images() {
		return new ImageMetadata();
	}
	
}
