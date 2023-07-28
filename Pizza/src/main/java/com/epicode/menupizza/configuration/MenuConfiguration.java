package com.epicode.menupizza.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.menupizza.model.MenuPizzas;

@Configuration
public class MenuConfiguration {
	@Bean("menuPizza")
	@Scope("singleton")
	public MenuPizzas showPizzas() {
		return new MenuPizzas();
	}

}
