package com.epicode.dispositivi.security.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.dispositivi.security.constants.Status;
import com.epicode.dispositivi.security.model.Smartphone;
import com.epicode.dispositivi.security.model.Tablet;
import com.epicode.dispositivi.security.repository.SmartphoneRepository;


import jakarta.persistence.EntityNotFoundException;

@Service
public class SmartphoneService {
	@Autowired @Qualifier ("smartphone") private ObjectProvider<Smartphone> smartphoneProvider;
	@Autowired SmartphoneRepository sm;
	@Autowired GadgetService g;
	
	
	public Smartphone createSmartphone(String brand, String model, Status status, Integer memory, String operatingSystem, String isbn, Integer numOfSims, String operatingSystemVersion, LocalDate customDate) {
		Smartphone s = smartphoneProvider.getObject();
		
		s.setBrand(brand);;
		s.setModel(model);
		s.setMemory(memory);
		s.setOperatingSystem(operatingSystem);
		s.setIsbn(isbn);
		s.setNumOfSims(numOfSims);
		s.setOperatingSystemVersion(operatingSystemVersion);
		
		
		g.validateIsbn(s);
		
	    g.setDate(s, customDate); 
		
		return s;
	
	}
	
	  public Smartphone saveSmartphone(Smartphone smart) {
	        return sm.save(smart);
	    }
	    
	    
	    public List<Smartphone> getAllSmartphones() {
	    	List <Smartphone> t =  (List<Smartphone>) sm.findAll();
	    	return t;
	    }
	    
	    public Smartphone findSmartphone(Long id) {
	    	if(!sm.existsById(id)) {
	    		throw new EntityNotFoundException("Smartphone doesn't exists!!!");
	    	}
	    	return sm.findById(id).get();
			
	    }
	    
	    
	    public Smartphone updateSmartphone(Long id, Smartphone s) {
			if(!sm.existsById(id)) {
				throw new EntityNotFoundException("User not exists!!!");
			}
			return sm.save(s);
		}
	    
	    public String deleteSmartphone(Long id) {
			if(!sm.existsById(id)) {
				throw new EntityNotFoundException("User not exists!!!");
			}
			 sm.deleteById(id);
			 return "Laptop deleted";
		}

		
	

}
