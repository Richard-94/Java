package com.epicode.dispositivi.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.dispositivi.security.exception.InvalidTypeException;
import com.epicode.dispositivi.security.model.Gadget;
import com.epicode.dispositivi.security.model.GadgetWrapper;
import com.epicode.dispositivi.security.model.Laptop;
import com.epicode.dispositivi.security.model.Smartphone;
import com.epicode.dispositivi.security.model.Tablet;
import com.epicode.dispositivi.security.service.GadgetService;
import com.epicode.dispositivi.security.service.LaptopService;
import com.epicode.dispositivi.security.service.SmartphoneService;
import com.epicode.dispositivi.security.service.TabletService;


import jakarta.persistence.EntityExistsException;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/gadget")
public class GadgetController {
	@Autowired TabletService tab;
	@Autowired GadgetService ga;
	@Autowired LaptopService lap;
	@Autowired SmartphoneService sm;
	
	
	//http://localhost:8080/api/gadget?type=laptops
	//http://localhost:8080/api/gadget?type=tablets
	//http://localhost:8080/api/gadget?type=smartphones
	@GetMapping
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<?>> getGadgets(@RequestParam(name = "type", required = false) String type) {
	    List<?> gadgets = null;
	    if (type.equalsIgnoreCase("tablets")) {
	        gadgets = tab.getAllTablets();
	    } else if (type.equalsIgnoreCase("laptops")) {
	        gadgets = lap.getAllLaptops();
	    } else if (type.equalsIgnoreCase("smartphones")) {
	    	gadgets = sm.getAllSmartphones();
	       
	    }
	    return new ResponseEntity<>(gadgets, HttpStatus.OK);
	}
	
//	
//	http://localhost:8080/api/gadget/tablets/1
//	http://localhost:8080/api/gadget/laptops/2
//	http://localhost:8080/api/gadget/smartphones/3
	@GetMapping("/{type}/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Gadget> getGadgetById(@PathVariable String type, @PathVariable Long id){
		Gadget gadget = null;
		 if (type.equalsIgnoreCase("tablets")) {
		        gadget =tab.findTablet(id);
		    } else if (type.equalsIgnoreCase("laptops")) {
		        gadget = lap.findLaptop(id);
		    } else if (type.equalsIgnoreCase("smartphones")) {
		    	gadget = sm.findSmartphone(id);
		       
		    }
		    return new ResponseEntity<>(gadget, HttpStatus.OK);
		}
		


	//http://localhost:8080/api/gadget
	@PostMapping
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> createGadget(@RequestBody GadgetWrapper gadgetWrapper) {
	    if (gadgetWrapper.getTablet() != null) {
	        Tablet t = gadgetWrapper.getTablet();
	        ga.validateIsbn(t);
	        Tablet tr = tab.saveTablet(t);
	        return new ResponseEntity<Tablet>(tr, HttpStatus.CREATED);
	    } else if (gadgetWrapper.getLaptop() != null) {
	        Laptop l = gadgetWrapper.getLaptop();
	        ga.validateIsbn(l);
	        Laptop lb = lap.saveLaptop(l);
	        return new ResponseEntity<Laptop>(lb, HttpStatus.CREATED);
	    }else if(gadgetWrapper.getSmartphone() != null) {
	    	Smartphone s = gadgetWrapper.getSmartphone();
	    	ga.validateIsbn(s);
	    	Smartphone sp = sm.saveSmartphone(s);
	    	 return new ResponseEntity<Smartphone>(sp, HttpStatus.CREATED);
	    	
	    }
	    else {
	    	throw new InvalidTypeException("Invalid gadget type. The type of gadget must be indicated in the json");
	    }
	    
	    
	}
	
	//http://localhost:8080/api/gadget/tablets/552
	@PutMapping("/{type}/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> updateGadgetById(@PathVariable String type, @PathVariable Long id, @RequestBody GadgetWrapper gadgetWrapper) {
		Gadget gadget = null;
		if (gadgetWrapper.getTablet() != null) {
	        Tablet t = gadgetWrapper.getTablet();
	        Tablet tr = tab.updateTablet(id, t);
	        return new ResponseEntity<Tablet>(tr, HttpStatus.CREATED);
	    } else if (gadgetWrapper.getLaptop() != null) {
	        Laptop l = gadgetWrapper.getLaptop();
	        Laptop lb = lap.updateLaptop(id,l);
	        return new ResponseEntity<Laptop>(lb, HttpStatus.CREATED);
	    }else if(gadgetWrapper.getSmartphone() != null) {
	    	Smartphone s = gadgetWrapper.getSmartphone();
	    	Smartphone sp = sm.updateSmartphone(id,s);
	    	 return new ResponseEntity<Smartphone>(sp, HttpStatus.CREATED);
	    	
	    }
	    else {
	    	throw new InvalidTypeException("Invalid gadget type. The type of gadget must be indicated in the json");
	    }
	}  
	
	
//	
//	http://localhost:8080/api/gadget/tablets/1
//	http://localhost:8080/api/gadget/laptops/2
//	http://localhost:8080/api/gadget/smartphones/3
	@DeleteMapping("/{type}/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<String> deleteGadgetById(@PathVariable String type, @PathVariable Long id){
		String msg = "";
		 if (type.equalsIgnoreCase("tablets")) {
		         msg  =tab.deleteTablet(id);
		    } else if (type.equalsIgnoreCase("laptops")) {
		         msg = lap.deleteLaptop(id);
		    } else if (type.equalsIgnoreCase("smartphones")) {
		    	 msg = sm.deleteSmartphone(id);
		       
		    }
		    return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
	   
	
	
	
	


//	Posting example
//	to address http://localhost:8080/api/gadget
//	{
//	    "laptop": {
//	        "brand": "Asus",
//	        "model": "Zen-253",
//	        "memory": 250,
//	        "operatingSystem": "Windows",
//	        "isbn": "XF253",
//	        "usbSlots": 7
//	    }
//	}
	
	
//	{
//		  
//		  "username": "oliviajones",
//
//		  "password": "myPassw0rd",
//		  "roles": ["USER"]
//		}
	
//	http://localhost:8080/api/gadget/tablets/1
//		http://localhost:8080/api/gadget/laptops/2
//		http://localhost:8080/api/gadget/smartphones/3
//	
//	   {
//	        "username": "annajohnson",
//	        "password": "pass123"
//
//	    }
	
//	{
//		  
//		  "username": "mikejohn",
//		  
//		  "password": "mysecretpass",
//		  "roles": ["USER"]
//		}
	
//	{
//		 
//		  "username": "danielmartinez",
//		  
//		  "password": "danielpass",
//		  "roles": ["ADMIN", "MODERATOR"]
//		}
	
//	{
//		  
//		  "username": "emmagarcia",
//		  
//		  "password": "emmapass",
//		  "roles": ["MODERATOR", "USER"]
//		}



}
