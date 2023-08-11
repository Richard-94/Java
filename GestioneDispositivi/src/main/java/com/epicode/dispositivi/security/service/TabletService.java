package com.epicode.dispositivi.security.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.dispositivi.security.model.Gadget;
import com.epicode.dispositivi.security.model.Smartphone;
import com.epicode.dispositivi.security.model.Tablet;
import com.epicode.dispositivi.security.repository.TabletRepository;


import jakarta.persistence.EntityNotFoundException;

@Service
public class TabletService {
	
	@Autowired @Qualifier ("tablet") private ObjectProvider<Tablet> tabletProvider;
	@Autowired TabletRepository tab;
	@Autowired GadgetService g;
	
	public Tablet createTablet(String brand, String model, Integer memory, String operatingSystem, String isbn, String simDati) {
        Tablet t = tabletProvider.getObject();
        t.setBrand(brand);
        t.setModel(model);
        t.setMemory(memory);
        t.setOperatingSystem(operatingSystem);
        t.setIsbn(isbn);
        t.setSimDati(simDati);
        
        //fa la verifica solo su lato server
        g.validateIsbn(t);

        return t;
    }

    public Tablet saveTablet(Tablet tb) {
        return tab.save(tb);
    }
    
    public Tablet findTablet(Long id) {
    	if(!tab.existsById(id)) {
    		throw new EntityNotFoundException("Tablet doesn't exists!!!");
    	}
    	return tab.findById(id).get();
		
    }
    
    public Tablet updateTablet(Long id, Tablet t) {
		if(!tab.existsById(id)) {
			throw new EntityNotFoundException("User not exists!!!");
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


}
