package com.epicode.dispositivi.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import com.epicode.dispositivi.security.exception.NotNullException;
import com.epicode.dispositivi.security.constants.Status;
import com.epicode.dispositivi.security.model.Gadget;
import com.epicode.dispositivi.security.model.Laptop;
import com.epicode.dispositivi.security.model.Smartphone;
import com.epicode.dispositivi.security.model.Tablet;
import com.epicode.dispositivi.security.repository.LaptopRepository;
import com.epicode.dispositivi.security.repository.SmartphoneRepository;
import com.epicode.dispositivi.security.repository.TabletRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class GadgetService {
	@Autowired TabletRepository tb;
	@Autowired LaptopRepository lab;
	@Autowired SmartphoneRepository sm;
	
	  public Gadget validateIsbn(Gadget g) {
	        if (tb.existsByIsbn(g.getIsbn())) {
	        	throw new EntityExistsException("ISBN already exists");
	        }else if(lab.existsByIsbn(g.getIsbn())) {
	        	throw new EntityExistsException("ISBN already exists");
	        }else if(sm.existsByIsbn(g.getIsbn())) {
	        	throw new EntityExistsException("ISBN already exists");
	        }
	        else {
	        	return null;
	        }
	        
	    }
	  
	  public Gadget controlNotNull(Gadget g) {
		    if (g.getBrand() == null) {
		        throw new NotNullException("Brand field cannot be null.");
		    }
		    if (g.getModel() == null) {
		        throw new NotNullException("Model field cannot be null.");
		    }
		    if (g.getIsbn() == null) {
		        throw new NotNullException("ISBN field cannot be null.");
		    }
		    if (g.getOperatingSystem() == null) {
		        throw new NotNullException("OperatingSystem field cannot be null.");
		    }
		    if (g.getStatusDate() == null) {
		        throw new NotNullException("StatusDate field cannot be null.");
		    }
		    if (g.getMemory() == null) {
		        throw new NotNullException("Memory field cannot be null.");
		    }
		    if (g instanceof Smartphone) {
		        Smartphone smartphone = (Smartphone) g;
		        if (smartphone.getOperatingSystemVersion() == null) {
		            throw new NotNullException("OperatingSystemVersion field cannot be null.");
		        }
		        if (smartphone.getNumOfSims() == null) {
		            throw new NotNullException("NumOfSims field cannot be null.");
		        }
		        
		    }
		    if (g instanceof Tablet) {
		        Tablet tablet = (Tablet) g;
		        if (tablet.getSimDati() == null) {
		            throw new NotNullException("SimDati field cannot be null.");
		        }
		  
		    }
		    
		    if (g instanceof Laptop) {
		    	Laptop laptop = (Laptop) g;
		        if (laptop.getUsbSlots() == null) {
		            throw new NotNullException("UsbSlots field cannot be null.");
		        }
		  
		    }
			return g;
		}


	  
	  public void setDate(Gadget ga, LocalDate customDate) {
		    if (ga.getStatus() == Status.MAINTENANCE || ga.getStatus() == Status.RETIRED) {
		        ga.setStatusDate(customDate);
		    } else if (ga.getStatus() == Status.AVAILABLE) {
		        ga.setAvailableDate(customDate);
		    } else {
		        throw new IllegalArgumentException("Invalid status");
		    }
		}


}
