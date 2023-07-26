package com.epicode.introSpring.ordini.classes;

import java.time.LocalTime;



import com.epicode.introSpring.classes.Menu;
import com.epicode.introSpring.classes.PizzaBase;
import com.epicode.introSpring.classes.Toppings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;





public class Orders {
	private static Menu menu;
	private String description;
	private Long oderNumber;
	private StatusOrder orderStatus;
	private int numberSeats;
	private LocalTime time;
	private Tavolo table;
	private static double orderCost;

	
	public Orders(Menu menu, String description, Long oderNumber, StatusOrder orderStatus, int numberSeats,
			LocalTime time, Tavolo table) {
		super();
		this.menu = menu;
		this.description = description;
		this.oderNumber = oderNumber;
		this.orderStatus = orderStatus;
		this.numberSeats = numberSeats;
		this.time = time;
		this.table = table;
	}


	public Orders() {
		super();
	}


	public static double pricing() {
        double totalMenuPrice = 0.0;
        for (PizzaBase pizza : menu.getMenuPizza()) {
            totalMenuPrice += pizza.getPrice();
            
            for(Toppings top : menu.getTop()) {
            	totalMenuPrice += top.getPrice();
            }
            
            totalMenuPrice += orderCost;
        }
        return totalMenuPrice;

    }


	@Override
	public String toString() {
		return "Orders [menu=" + menu + ", description=" + description + ", oderNumber=" + oderNumber + ", orderStatus="
				+ orderStatus + ", numberSeats=" + numberSeats + ", time=" + time + ", table=" + table + ", orderCost="
				+ orderCost + "]";
	}

	
	
}
