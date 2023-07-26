package com.epicode.runner;

import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.epicode.introSpring.Configuration.ConfigurationMenu;
import com.epicode.introSpring.classes.Cheese;
import com.epicode.introSpring.classes.Menu;
import com.epicode.introSpring.classes.Onions;
import com.epicode.introSpring.classes.PizzaBase;
import com.epicode.introSpring.classes.PizzaHawaiian;
import com.epicode.introSpring.classes.PizzaMargerita;
import com.epicode.introSpring.classes.Toppings;
import com.epicode.introSpring.ordini.classes.Orders;
import com.epicode.introSpring.ordini.classes.Status;
import com.epicode.introSpring.ordini.classes.StatusOrder;
import com.epicode.introSpring.ordini.classes.Tavolo;

@Component
public class OrderRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		   creatOrder();
	
	}
	
	public void creatOrder() {
	    AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationMenu.class);
	    Tavolo t = new Tavolo(15, 10, Status.FREE);
	    Menu m = createMenuWithPizzaAndToppings();
	    LocalTime time1 = LocalTime.of(12, 30);
	    Orders o1 = (Orders) appContext.getBean("take", m, "Tavolo da 10 persone", 123L, StatusOrder.PREPARING, 10, time1, t);
	    System.out.println(o1);
	    System.out.println(o1.pricing());
	    appContext.close();
	}


	private Menu createMenuWithPizzaAndToppings() {
        Menu menu = new Menu();
        PizzaBase pizza1 = new PizzaMargerita();
        PizzaBase pizza2 = new PizzaHawaiian();

        Toppings topping1 = new Onions();
        Toppings topping2 = new Cheese();

       
        menu.getMenuPizza().add(pizza1);
        menu.getMenuPizza().add(pizza2);
        menu.getTop().add(topping1);
        menu.getTop().add(topping2);
        
        return menu;
    }

}
