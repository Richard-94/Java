package com.epicode.prenotazione.security.service;

import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.prenotazione.security.model.Building;
import com.epicode.prenotazione.security.model.User;
import com.epicode.prenotazione.security.repository.BuildingRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class BuildingService {
Logger log = LoggerFactory.getLogger(BuildingService.class);
	
	@Autowired @Qualifier("build") private ObjectProvider<Building> buildProvider;
	@Autowired BuildingRepository bu;
	
	public Building creatBuilding(String name,String address,String city,String pinCode) {
		return buildProvider.getObject().builder()
				.name(name)
				.address(address)
				.city(city)
				.pinCode(pinCode)
				.build();
		
	}
	
	public Building  saveBuilding(Building b) {
		  if (b.getPinCode().length() != 8) {
		        throw new IllegalArgumentException("Pincode must be exactly 8 characters long.");
		    }
		  if (!b.getPinCode().matches("^[a-zA-Z0-9]*$")) {
		        throw new IllegalArgumentException("Pincode must be alphanumeric.");
		    }
		
		if(bu.existsByPinCode(b.getPinCode())) {
			throw new EntityExistsException("Pincode already exists!!!");
		}
		
		bu.save(b);
		log.info(b.getName()+ " saved in the database");
		return b;
	}
	
	 
	public Building userFind(Long id) {
		return bu.findById(id).get();
	}
	
	public List<Building> printaAllLocation(){
		return (List<Building>)bu.findAll();
		
	}
	
	public Building updateBuilding(Long id, Building u) {
		if(!bu.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
		}
		
		
		return bu.save(u);
	}
	
	public String buildingdel(Long id) {
		if(!bu.existsById(id)) {
			throw new EntityNotFoundException("Building not exists!!!");
		}
		 bu.deleteById(id);
		 return "contact deleted";
	}
	
	


}
