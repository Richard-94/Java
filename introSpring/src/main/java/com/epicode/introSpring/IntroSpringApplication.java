package com.epicode.introSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epicode.introSpring.Configuration.GestioneMenu;

@SpringBootApplication
public class IntroSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringApplication.class, args);
		
		GestioneMenu m = new GestioneMenu();
		m.stampaMenu();
	}

}
