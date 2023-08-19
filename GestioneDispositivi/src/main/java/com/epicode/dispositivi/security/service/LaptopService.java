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

import com.epicode.dispositivi.security.repository.LaptopRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class LaptopService {
	@Autowired @Qualifier("laptop") private ObjectProvider<Laptop> laptopProvider;
	@Autowired GadgetService gadget;
	@Autowired LaptopRepository lap;
	
	public Laptop createLaptop(String brand, String model, Status status, Integer memory, String operatingSystem, String isbn,  Integer usbSlots, LocalDate customDate) {
	    try {
	    	Laptop l = laptopProvider.getObject();
		    l.setBrand(brand);
		    l.setModel(model);
		    l.setStatus(status);
		    l.setMemory(memory);
		    l.setOperatingSystem(operatingSystem);
		    l.setIsbn(isbn);
		    l.setUsbSlots(usbSlots);
		    l.setStatus(status);
		    
		    try {
	            gadget.validateIsbn(l);
	        } catch (EntityExistsException e) {
	            System.err.println("Error: ISBN already exists.");
	            return null; 
	        }
		    gadget.setDate(l, customDate); 
		    
		    return l;
	    }catch (IllegalArgumentException e) {
	        System.err.println("Error creating tablet: " + e.getMessage());
	        return null;
	    }
		
	}

	
	public Laptop saveLaptop(Laptop lb) {
		try {
			if (lb == null) {
	            throw new IllegalArgumentException("Laptop object cannot be null.");
	        }
			gadget.controlNotNull(lb);
	        return lap.save(lb);
		}catch (IllegalArgumentException e) {
            throw new NotNullException("Laptop object is not valid for saving: " + e.getMessage());
        }
    }
	
	public Laptop findLaptop(Long id) {
    	if(!lap.existsById(id)) {
    		throw new EntityNotFoundException("Tablet doesn't exists!!!");
    	}
    	return lap.findById(id).get();
		
    }
	
	public Laptop updateLaptop(Long id, Laptop l) {
		if(!lap.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
		}
		return lap.save(l);
	}

    public List<Laptop> getAllLaptops() {
    	List <Laptop> t = (List<Laptop>) lap.findAll();
		return t;
    
    }
    
    public String deleteLaptop(Long id) {
		if(!lap.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
		}
		 lap.deleteById(id);
		 return "Laptop deleted";
	}


}
