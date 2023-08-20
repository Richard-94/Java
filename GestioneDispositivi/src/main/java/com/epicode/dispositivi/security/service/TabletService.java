package com.epicode.dispositivi.security.service;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.dispositivi.security.constants.Status;
import com.epicode.dispositivi.security.exception.NotNullException;
import com.epicode.dispositivi.security.model.Laptop;
import com.epicode.dispositivi.security.model.Tablet;
import com.epicode.dispositivi.security.repository.TabletRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TabletService {
	
	@Autowired @Qualifier ("tablet") private ObjectProvider<Tablet> tabletProvider;
	@Autowired TabletRepository tab;
	@Autowired GadgetService g;
	
	public Tablet createTablet(String brand, String model, Status status, Integer memory, String operatingSystem, String isbn, String simDati, LocalDate customDate) {
	    try {
	        Tablet t = tabletProvider.getObject();
	        t.setBrand(brand);
	        t.setModel(model);
	        t.setMemory(memory);
	        t.setOperatingSystem(operatingSystem);
	        t.setIsbn(isbn);
	        t.setSimDati(simDati);
	        t.setStatus(status);

	        // Validate ISBN
	        try {
	            g.validateIsbn(t);
	        } catch (EntityExistsException e) {
	            System.err.println("Error: ISBN already exists.");
	            return null; 
	        }

	        g.setDate(t, customDate);

	        return t;
	    } catch (NotNullException e) {
	        System.err.println("Error creating tablet: " + e.getMessage());
	        return null;
	    }
	}


	public Tablet saveTablet(Tablet tb) {
        try {
            if (tb == null) {
                throw new IllegalArgumentException("Tablet object cannot be null.");
            }
            g.controlNotNull(tb);
            return tab.save(tb);
        } catch (IllegalArgumentException e) {
            throw new NotNullException("Tablet object is not valid for saving: " + e.getMessage());
        }
    }
    
    public Tablet findTablet(Long id) {
    	if(!tab.existsById(id)) {
    		throw new EntityNotFoundException("Tablet doesn't exists in the db!!!");
    	}
    	return tab.findById(id).get();
		
    }
    
    public Tablet updateTablet(Long id, Tablet t) {
		if(!tab.existsById(id)) {
			throw new EntityNotFoundException("Worker not exists!!!");
		}

		return tab.save(t);
	}
	
    
    
    public List<Tablet> getAllTablets() {
    	List <Tablet> t =  (List<Tablet>) tab.findAll();
    	return t;
    }
    
    public String deleteTablet(Long id) {
		if(!tab.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
		}
		 tab.deleteById(id);
		 return "Laptop deleted";
	}
    
    public Tablet tabletFindIsbn(String isbn) {
  		if(!tab.existsByIsbn(isbn)) {
  			throw new EntityNotFoundException("UserName doesn't exists!!!");
  		}
  		return tab.findByIsbn(isbn);
  	}



}
