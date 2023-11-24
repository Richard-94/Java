package com.tesifacile.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.tesifacile.project.model.ChatBox;
import com.tesifacile.project.model.Thesis;
import com.tesifacile.project.model.RicieveMessage;

@Configuration
@EnableScheduling
public class TesiConfiguration {
	@Bean("message")
	@Scope("prototype")
	public RicieveMessage ricieveMessage() {
		return new RicieveMessage();
	}
	
	@Bean("chat")
	@Scope("prototype")
	public ChatBox chatBox() {
		return new ChatBox();
	}
	
	@Bean("thesis")
	@Scope("prototype")
	public Thesis  Thesis() {
		return new Thesis ();
	}
}
