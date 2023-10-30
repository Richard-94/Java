package com.tesifacile.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.tesifacile.project.model.RicieveMessage;

@Configuration
@EnableScheduling
public class TesiConfiguration {
	@Bean("message")
	@Scope("prototype")
	public RicieveMessage ricieveMessage() {
		return new RicieveMessage();
	}
}
