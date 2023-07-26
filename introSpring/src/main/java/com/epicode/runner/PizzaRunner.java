package com.epicode.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.epicode.introSpring.Configuration.ConfigurationMenu;
//import com.epicode.introSpring.Configuration.GestioneMenu;
import com.epicode.introSpring.classes.Menu;
@Component
public class PizzaRunner implements CommandLineRunner {

	AnnotationConfigApplicationContext appContext;
	Menu menu;
	
	
	Logger log = LoggerFactory.getLogger(PizzaRunner.class);


	@Override
    public void run(String... args) throws Exception {
		configureBeans();
		stampaMenu();
		OrderRunner n = new OrderRunner();
		n.creatOrder();
    }
	
	public void configureBeans() {
		
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationMenu.class);
		menu = (Menu) appContext.getBean("menu");
		appContext.close();
	}
	
	public void stampaMenu() {
		log.info("***** Menu *****");
		log.info("Pizzas");
		
		menu.getMenuPizza().forEach(p->log.info(p.toString()));
		
		log.info("Toppings");
		menu.getTop().forEach(t->log.info(t.toString()));
	}


}
