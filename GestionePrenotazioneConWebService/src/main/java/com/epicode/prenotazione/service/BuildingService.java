package com.epicode.prenotazione.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.prenotazione.model.Building;
import com.epicode.prenotazione.model.User;
import com.epicode.prenotazione.repositories.BuildingRepository;

import com.epicode.prenotazione.runner.BookingRunner;

@Service
public class BuildingService {
Logger log = LoggerFactory.getLogger(BookingRunner.class);
	
	@Autowired @Qualifier("build") private ObjectProvider<Building> buildProvider;
	@Autowired BuildingRepository bu;
	
	public Building creatBuilding(String name,String address,String city) {
		return buildProvider.getObject().builder()
				.name(name)
				.address(address)
				.city(city)
				.build();
		
	}
	
	public void saveBuilding(Building b) {
		bu.save(b);
		log.info(b.getName()+ " saved in the database");
	}
	
	 
	public Building userFind(Long id) {
		return bu.findById(id).get();
	}
	
	public List<Building> printaAllLocation(){
		return (List<Building>)bu.findAll();
		
	}
	
	


}
