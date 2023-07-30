package com.epicode.prenotazione.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
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
	static int currentYear = LocalDate.now().getYear();
	static int currentDayOfMonth = LocalDate.now().getDayOfMonth();
	
	static Month currentMonth = LocalDate.now().getMonth();
	
	@Autowired @Qualifier("booking") private ObjectProvider<Prenotation> prenotatioProvider;
	@Autowired PrenotationRepository pre;
	@Autowired LocationRepository lo;
	
	public void savePrenotation(Prenotation b) {
		pre.save(b);
		log.info(b.getUser().getFullName()+ " saved prenotation in the database");
	}
	
	
	
	
	public Prenotation prenote(User user, Location location,LocalDate date) {
						List<Prenotation> userPrenotations = pre.findByPrenotationDateAndUser(date, user);

						if (!userPrenotations.isEmpty()) {
							throw new IllegalArgumentException("Hai già una prenotazione per quella data");
						}
						if(date.getYear() >= currentYear + 3){
							 throw new  IllegalArgumentException("SI PUO' PRENOTARE FINO A TRE ANNI A PARTIRE DA QUESTO ANNO");
						}else if (date.getYear()< currentYear) {
		                    throw new IllegalArgumentException("L'ANNO NON PUO' ESSERE MINORE DELL'ANNO CORRENTE");
		                }

						LocalDate validity = date.plusDays(1);

			            Boolean occupied = true;
			            if(location.getOccupants()<=0) {
			            	 
			            	 throw new IllegalArgumentException("Posti Esauriti");
			            }
			            Prenotation newPrenotation = prenotatioProvider.getObject().builder()
			                    .user(user)
			                    .location(location)
			                    .validity(validity)
			                    .prenotationDate(date)
			                    .occupied(occupied)
			                    .build();
			            location.setOccupants(location.getOccupants() - 1);
			            lo.save(location);
						return newPrenotation;
   
	  }
		  
	       
}
