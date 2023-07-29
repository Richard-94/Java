package com.epicode.prenotazione.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.prenotazione.model.Building;
import com.epicode.prenotazione.model.Location;
import com.epicode.prenotazione.model.Prenotation;
import com.epicode.prenotazione.model.User;
import com.epicode.prenotazione.repositories.LocationRepository;
import com.epicode.prenotazione.repositories.PrenotationRepository;
import com.epicode.prenotazione.runner.BookingRunner;

@Service
public class PrenotationService {
	//Logger log = LoggerFactory.getLogger(BookingRunner.class);
	private static final Logger log = LoggerFactory.getLogger(PrenotationService.class);
	
	@Autowired @Qualifier("booking") private ObjectProvider<Prenotation> prenotatioProvider;
	@Autowired PrenotationRepository pre;
	@Autowired LocationRepository lo;
	
	public void savePrenotation(Prenotation b) {
		pre.save(b);
		log.info(b.getUser().getFullName()+ " saved prenotation in the database");
	}
	
	
	
	
	public Prenotation prenote(User user, Location location) {
		 List<Prenotation> userPrenotations = pre.findByPrenotationDateAndUser(LocalDate.now(), user);
		    if (!userPrenotations.isEmpty()) {
		        throw new IllegalArgumentException("Hai già una prenotazione per oggi");
		    }
		        		LocalDateTime validity = LocalDateTime.now().plus(1, ChronoUnit.DAYS);
			            LocalDate prenotationDate = LocalDate.now();
			            Boolean occupied = true;
			            if(location.getOccupants()<=0) {
			            	 
			            	 throw new IllegalArgumentException("Posti Esauriti");
			            }
			            Prenotation newPrenotation = prenotatioProvider.getObject().builder()
			                    .user(user)
			                    .location(location)
			                    .validity(validity.toLocalDate())
			                    .prenotationDate(prenotationDate)
			                    .occupied(occupied)
			                    .build();
			            location.setOccupants(location.getOccupants() - 1);
			            lo.save(location);
			            return newPrenotation;
			          
			        
		        	
		        
		         
	  }
		  
	       
}
