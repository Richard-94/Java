package com.epicode.menupizza.service;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.menupizza.model.HawaiianPizza;
import com.epicode.menupizza.model.Ingredients;
import com.epicode.menupizza.model.MainPizza;
import com.epicode.menupizza.model.MargheritaPizza;
import com.epicode.menupizza.model.MenuPizzas;
import com.epicode.menupizza.model.SalamiPizza;
import com.epicode.menupizza.model.Spicy;
import com.epicode.menupizza.model.Types;
import com.epicode.menupizza.repositories.RepositoryMenu;
import com.epicode.menupizza.runner.PizzaRun;

@Service
public class MenuServices {
	Logger log = LoggerFactory.getLogger(PizzaRun.class);
	
	@Autowired RepositoryMenu sv;
	
	@Autowired @Qualifier("menuPizza") private ObjectProvider<MenuPizzas> pizzas;
	@Autowired @Qualifier("pizzaMargherita") private ObjectProvider<MargheritaPizza> pizzaMarherita;
	@Autowired @Qualifier("pizzaHawaii") private ObjectProvider<HawaiianPizza> pizzaHawaiiProv;
	@Autowired @Qualifier("pizzaSalami") private ObjectProvider<SalamiPizza> pizzaSalami;
	
	
	public void addPizza(MainPizza m) {
		List <MainPizza> list = pizzas.getObject().getPizzas();
		list.add(m);
	}
	
	public void showPizzaList(MainPizza a) {
	    List<MainPizza> list = pizzas.getObject().getPizzas();
	    list.forEach(p -> {
	        System.out.println(p);
	        log.info("Pizza: name={}, calories={}, price={}, ingredients={}", 
	                p.getCalories(), p.getPrice(), p.getIngredients());
	    });
	}

	public HawaiianPizza createHawaiiPizza() {
		HawaiianPizza m = pizzaHawaiiProv.getObject();
		List<Ingredients> list = new ArrayList<Ingredients>();
		list.add(Ingredients.CHEESE);
		list.add(Ingredients.HAM);
		list.add(Ingredients.PINEAPLE);
		list.add(Ingredients.TOMATO);
		m.setCalories(1124.0);
		m.setIngredients(list);
		//m.setName("Hawaiian Pizza");
		m.setPrice(4.99);
		m.setSpecialIngredient("Mozzarella");
		return m;
		
	}
	
	public SalamiPizza creatSalamiPizza() {
		List<Ingredients> list = new ArrayList<Ingredients>();
		list.add(Ingredients.TOMATO);
		list.add(Ingredients.CHEESE);
		list.add(Ingredients.SALAMI);
		SalamiPizza s = pizzaSalami.getObject();
		s.setSpicy(Spicy.HOT);
		//s.setName("Salami Pizza");
		s.setPrice(5.99);
		s.setIngredients(list);
		s.setCalories(1160.0);
		return s;
	}
	
	public MargheritaPizza creatMargheritaPizza() {
		List<Ingredients> list = new ArrayList<Ingredients>();
		list.add(Ingredients.TOMATO);
		list.add(Ingredients.CHEESE);
		MargheritaPizza s = pizzaMarherita.getObject();
		s.setType(Types.NAPOLETANA);
		//s.setName("Margherita Pizza");
		s.setPrice(7.99);
		s.setIngredients(list);
		s.setCalories(1104.0);
		return s;
	}
	
	public void savePizza(List<MainPizza> list) {
		list.forEach(p->log.info(p.toString()+ " added"));
		sv.saveAll(list);
		
	}
	
	public void updatePizza(MainPizza m) {
		sv.save(m);
		log.info("elemento modificato");
	}
	
	public MainPizza readPizza(Long id) {
		return sv.findById(id).get();
		
	}
	
	public List<MainPizza> readAllPizzas() {
		return (List<MainPizza>) sv.findAll();
	}
	
	public void deletePizza(MainPizza m) {
		sv.delete(m);
	}


}
