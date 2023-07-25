package com.epicode.introSpring.classes;

public abstract class Toppings {
	private String name;
	private double calorie;
	private double price;
	public Toppings(String name, double calorie, double price) {
		super();
		this.name = name;
		this.calorie = calorie;
		this.price = price;
	}
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getCalorie() {
		return calorie;
	}



	public void setCalorie(double calorie) {
		this.calorie = calorie;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "Toppings [name=" + name + ", calorie=" + calorie + ", price=" + price + "]";
	}
	
	
}
