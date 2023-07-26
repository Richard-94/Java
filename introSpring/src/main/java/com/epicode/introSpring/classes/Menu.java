package com.epicode.introSpring.classes;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<PizzaBase> menuPizza = new ArrayList<PizzaBase>();
	private List<Toppings> top = new ArrayList <Toppings>();

	public List<PizzaBase> getMenuPizza() {
		return menuPizza;
	}

	public List<Toppings> getTop() {
		return top;
	}

	@Override
	public String toString() {
		return "Menu [menuPizza=" + menuPizza + ", top=" + top + "]";
	}

}
