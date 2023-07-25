package com.epicode.introSpring.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.epicode.introSpring.classes.Ham;
import com.epicode.introSpring.classes.Menu;
import com.epicode.introSpring.classes.Onions;
import com.epicode.introSpring.classes.Pineaple;
import com.epicode.introSpring.classes.PizzaHawaiian;
import com.epicode.introSpring.classes.PizzaMargerita;
import com.epicode.introSpring.classes.Salami;
import com.epicode.introSpring.classes.SalamiPizza;

public class ConfigurationMenu {

	@Bean
	@Scope("singleton")
	public Menu menu() {
		Menu menu = new Menu();
		menu.getMenuPizza().add(pizzaMargherita());
		menu.getMenuPizza().add(pizzaHawaiian());
		menu.getMenuPizza().add(salamiPizzazza());
		menu.getTop().add(onions());
		menu.getTop().add(pineaple());
		menu.getTop().add(ham());
		menu.getTop().add(salami());
		return menu;
		
	}

	@Bean
	@Scope("singleton")
	public PizzaMargerita pizzaMargherita() {
		return new PizzaMargerita();
		
	}
	
	@Bean
	@Scope("singleton")
	public PizzaHawaiian pizzaHawaiian() {
		return new PizzaHawaiian();
		
	}
	
	@Bean
	@Scope("singleton")
	public SalamiPizza salamiPizzazza() {
		return  new SalamiPizza();
		
	}
	
	
	@Bean
	@Scope("singleton")
	public Onions onions() {
		return new Onions();
		
	}
	
	@Bean
	@Scope("singleton")
	public Pineaple pineaple () {
		return new Pineaple();
	}
	
	@Bean
	@Scope("singleton")
	public Ham ham () {
		return new Ham();
	}
	
	@Bean
	@Scope("singleton")
	public Salami salami() {
		return new Salami();
	}

}
