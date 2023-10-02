package com.work.project.security.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.work.project.security.exception.InvalidTypeException;
import com.work.project.security.model.EventWrapper;
import com.work.project.security.model.Events;
import com.work.project.security.model.SportsEvents;
import com.work.project.security.service.SportService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/events")
public class EventsController {
	@Autowired SportService sportService;
	
	//http://localhost:8083/api/events?type=sports
	@GetMapping
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<?>> getEvents(@RequestParam(name = "type", required = false) String type) {
	    List<?> events = null;
	    if (type.equalsIgnoreCase("sports")) {
	        events = sportService.getAllEvents();
	    } 
//	    else if (type.equalsIgnoreCase("laptops")) {
//	        gadgets = lap.getAllLaptops();
//	    } else if (type.equalsIgnoreCase("smartphones")) {
//	    	gadgets = sm.getAllSmartphones();
//	       
//	    }
	    return new ResponseEntity<>(events, HttpStatus.OK);
	}
	
	
	//http://localhost:8083/api/events/sports/1
	@GetMapping("/{type}/{id}")
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Events> getGadgetById(@PathVariable String type, @PathVariable Long id){
		Events event = null;
		 if (type.equalsIgnoreCase("sports")) {
		        event =sportService.findSport(id);
		    } 
//		 else if (type.equalsIgnoreCase("laptops")) {
//		        gadget = lap.findLaptop(id);
//		    } else if (type.equalsIgnoreCase("smartphones")) {
//		    	gadget = sm.findSmartphone(id);
//		       
//		    }
		    return new ResponseEntity<>(event, HttpStatus.OK);
		}
	
	//http://localhost:8083/api/events
		@PostMapping
		
		public ResponseEntity<?> createGadget(@RequestBody EventWrapper eventWrapper) {
		    if (eventWrapper.getSportsEvents() != null) {
		        SportsEvents sport = eventWrapper.getSportsEvents();
		         
		        SportsEvents sportEve = sportService.saveSports(sport);
		        return new ResponseEntity<SportsEvents>(sportEve, HttpStatus.CREATED);
		    } 
//		    else if (gadgetWrapper.getLaptop() != null) {
//		        Laptop l = gadgetWrapper.getLaptop();
//		        ga.validateIsbn(l);
//		        Laptop lb = lap.saveLaptop(l);
//		        return new ResponseEntity<Laptop>(lb, HttpStatus.CREATED);
//		    }else if(gadgetWrapper.getSmartphone() != null) {
//		    	Smartphone s = gadgetWrapper.getSmartphone();
//		    	ga.validateIsbn(s);
//		    	Smartphone sp = sm.saveSmartphone(s);
//		    	 return new ResponseEntity<Smartphone>(sp, HttpStatus.CREATED);
//		    	
//		    }
		    else {
		    	throw new InvalidTypeException("Invalid Event type. The type of event must be indicated in the json");
		    }
		    
		    
		}

}
