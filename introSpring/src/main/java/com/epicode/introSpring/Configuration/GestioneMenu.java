package com.epicode.introSpring.Configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epicode.introSpring.classes.Menu;


public class GestioneMenu {
	
	AnnotationConfigApplicationContext appContext;
	Menu menu;
	
	
	public GestioneMenu() {
	appContext = new AnnotationConfigApplicationContext(ConfigurationMenu.class);
	menu = (Menu) appContext.getBean("menu");
		
	}
	
	public void stampaMenu() {
		System.out.println("***** Menu *****");
		System.out.println("Pizzas");
		
		menu.getMenuPizza().forEach(p->System.out.println(p.toString()));
		
		System.out.println("Toppings");
		menu.getTop().forEach(t->System.out.println(t.toString()));
	}

}
