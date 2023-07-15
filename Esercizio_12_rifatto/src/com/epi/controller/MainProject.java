package com.epi.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epi.model.Evento;
import com.epi.model.JpaUtil;


public class MainProject {
	static Logger log = LoggerFactory.getLogger(MainProject.class);

	static EntityManager manageEvent = JpaUtil.getEntityManagerFactory().createEntityManager();
    
    
    
	public static void main(String[] args) {
		Evento num1 = new Evento("Circo", LocalDate.of(2023, 9, 20), "Circo massimo direttamente dalla Romania", Type.PRIVATE, 100);
		saveEvent(num1);
		
		Evento show = getById(1);
		show.setEventType(Type.PUBLIC);
		manageEvent.refresh(show);
	}
	
	
	
	public static void saveEvent(Evento list) {
		try {
			manageEvent.getTransaction().begin();
			manageEvent.persist(list);
			manageEvent.getTransaction().commit();
			log.info("Event created: " + list);
			log.info("Event title: " + list.getTitle());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	
	public static Evento getById(int i) {
		manageEvent.getTransaction().begin();
		Evento eve = manageEvent.find(Evento.class, i);
		manageEvent.getTransaction().commit();
		return eve;
	}
	
	public static void del(Evento list) {
		manageEvent.getTransaction().begin();
		manageEvent.remove(list);
		manageEvent.getTransaction().commit();
		log.info("Event title: " + list.getTitle() + "deleted");
	}
}
