package com.epi.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epi.model.Evento;
import com.epi.model.JpaUtil;
import com.epi.model.Location;
import com.epi.model.Participation;
import com.epi.model.Person;


public class MainProject {
	static Logger log = LoggerFactory.getLogger(MainProject.class);

	static EntityManager manageEvent = JpaUtil.getEntityManagerFactory().createEntityManager();
    
    
	static Person number1;
    
	public static void main(String[] args) {
		Participation first = new Participation(number1, Confirmed.CONFIRMED);
		List<Participation> participate = new ArrayList<>();
		participate.add(first);

		List<Person> who = new ArrayList<>();

		number1 = new Person("George", "Brown", "test@gmail.com", LocalDate.of(1995, 1, 31), Gender.MALE, participate);
		Person number2 = new Person("Maria", "Bronx", "test@yahoo.com", LocalDate.of(2005, 10, 15), Gender.FEMALE, participate);

		List<Person> numberOfParticipants = new ArrayList<>();
		//numberOfParticipants.add(number1);
		numberOfParticipants.add(number2);

		//Location where = new Location("Marano", "Vicenza");
		Location where1 = new Location("Marano", "Vicenza");

		//Evento num1 = new Evento("Festa Giovani", where, LocalDate.of(2023, 8, 20), "Festa organizzata per tutti i giovani d'Italia", participate, Type.PRIVATE, numberOfParticipants);
		Evento num2 = new Evento("Film all'aperto", where1, LocalDate.of(2023, 5, 2), "Film per tutte le età", participate, Type.PRIVATE, numberOfParticipants);
		//saveEvent(num1);

	
		 //Evento s = getById(2);
		   // log.info("Event: " + s);
		
		
		//Evento show = getById(2l);
		//show.setEventType(Type.PUBLIC);
		//manageEvent.refresh(show);
		//log.info("Event  REFRESHED: " + show);
		//del(show);
		//log.info("Event  deleted: " + show);
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
	
	
	public static Evento getById(long id) {
	    log.info("Retrieving Evento with ID: " + id);
	    manageEvent.getTransaction().begin();
	    Evento eve = manageEvent.find(Evento.class, id);
	    manageEvent.getTransaction().commit();
	    //System.out.println("Retrieved Evento: " + eve);
	    return eve;
	}

	
	public static void del(Evento list) {
		manageEvent.getTransaction().begin();
		manageEvent.remove(list);
		manageEvent.getTransaction().commit();
		log.info("Event title: " + list.getTitle() + "deleted");
	}
}
