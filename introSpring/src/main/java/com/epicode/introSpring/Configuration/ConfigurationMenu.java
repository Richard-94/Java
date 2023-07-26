package com.epicode.introSpring.Configuration;

import java.time.LocalTime;

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
import com.epicode.introSpring.ordini.classes.Orders;
import com.epicode.introSpring.ordini.classes.Status;
import com.epicode.introSpring.ordini.classes.StatusOrder;
import com.epicode.introSpring.ordini.classes.Tavolo;

public class ConfigurationMenu {

    @Bean
    @Scope("singleton")
    Menu menu() {
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
    PizzaMargerita pizzaMargherita() {
		return new PizzaMargerita();
	}

    @Bean
    @Scope("singleton")
    PizzaHawaiian pizzaHawaiian() {
		return new PizzaHawaiian();
		
	}

    @Bean
    @Scope("singleton")
    SalamiPizza salamiPizzazza() {
		return  new SalamiPizza();
		
	}


    @Bean
    @Scope("singleton")
    Onions onions() {
		return new Onions();
		
	}

    @Bean
    @Scope("singleton")
    Pineaple pineaple() {
		return new Pineaple();
	}

    @Bean
    @Scope("singleton")
    Ham ham() {
		return new Ham();
	}

    @Bean
    @Scope("singleton")
    Salami salami() {
		return new Salami();
	}
    
    @Bean
    @Scope("prototype")
    public Tavolo table() {
    	return new Tavolo();
    }
	
    @Bean
    @Scope("prototype")
    public Tavolo table1(int tableNumber, int numberSeats, Status status) {
    	return new Tavolo(tableNumber,numberSeats,status);
    }
    
    @Bean(name = "take")
    @Scope("prototype")
    public Orders newOrder(Menu menu, String description, Long oderNumber, StatusOrder orderStatus, int numberSeats,
            LocalTime time, Tavolo table) {
        return new Orders(menu, description, oderNumber, orderStatus, numberSeats, time, table);
    }

    
    
    

}
