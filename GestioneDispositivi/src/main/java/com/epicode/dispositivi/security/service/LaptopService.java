package com.epicode.dispositivi.security.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.dispositivi.security.model.Laptop;
import com.epicode.dispositivi.security.model.Tablet;
import com.epicode.dispositivi.security.repository.LaptopRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LaptopService {
	@Autowired @Qualifier("laptop") private ObjectProvider<Laptop> laptopProvider;
	@Autowired GadgetService gadget;
	@Autowired LaptopRepository lap;
	
	public Laptop createLaptop(String brand, String model, Integer memory, String operatingSystem, String isbn,  Integer usbSlots) {
		Laptop l = laptopProvider.getObject();
		l.setBrand(brand);
		l.setModel(model);
		l.setMemory(memory);
		l.setOperatingSystem(operatingSystem);
		l.setIsbn(isbn);
		l.setUsbSlots(usbSlots);
		
		gadget.validateIsbn(l);
		
		return l;
		
	}
	
	public Laptop saveLaptop(Laptop lb) {
        return lap.save(lb);
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
