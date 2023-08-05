package com.epicode.dispositivi.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.dispositivi.security.model.Gadget;
import com.epicode.dispositivi.security.repository.LaptopRepository;
import com.epicode.dispositivi.security.repository.SmartphoneRepository;
import com.epicode.dispositivi.security.repository.TabletRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class GadgetService {
	@Autowired TabletRepository tb;
	@Autowired LaptopRepository lab;
	@Autowired SmartphoneRepository sm;
	
	  public void validateIsbn(Gadget g) {
	        if (tb.existsByIsbn(g.getIsbn())) {
	        	throw new EntityExistsException("ISBN already exists");
	        }else if(lab.existsByIsbn(g.getIsbn())) {
	        	throw new EntityExistsException("ISBN already exists");
	        }else if(sm.existsByIsbn(g.getIsbn())) {
	        	throw new EntityExistsException("ISBN already exists");
	        }
	    }

}
