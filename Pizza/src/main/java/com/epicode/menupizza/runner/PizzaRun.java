package com.epicode.menupizza.runner;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.menupizza.model.HawaiianPizza;
import com.epicode.menupizza.model.MainPizza;
import com.epicode.menupizza.service.MenuServices;

@Component
public class PizzaRun implements CommandLineRunner {
	
	Logger log = LoggerFactory.getLogger(PizzaRun.class);
	
	@Autowired private MenuServices mService;
	
	
	@Override
	public void run(String... args) throws Exception {
		
	log.info("Run...");
		
		
		MainPizza hawaii = mService.createHawaiiPizza();
		MainPizza margherita = mService.creatMargheritaPizza();
		MainPizza salami = mService.creatSalamiPizza();
		
		//mService.addPizza(hawaii);
		//mService.addPizza(margherita);
		//mService.addPizza(salami);
		
		
		//mService.showPizzaList();
		
		//List<MainPizza> pizzasToSave = Arrays.asList(salami, margherita,hawaii);
		//mService.savePizza(pizzasToSave);
		
		MainPizza m = mService.readPizza(2l);
		System.out.println(m);
	}

}
