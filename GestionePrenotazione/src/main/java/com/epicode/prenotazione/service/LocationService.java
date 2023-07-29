package com.epicode.prenotazione.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.prenotazione.constants.Type;
import com.epicode.prenotazione.model.Building;
import com.epicode.prenotazione.model.Location;
import com.epicode.prenotazione.model.Location.LocationBuilder;
import com.epicode.prenotazione.model.User;
import com.epicode.prenotazione.repositories.LocationRepository;
import com.epicode.prenotazione.runner.BookingRunner;

@Service
public class LocationService {
Logger log = LoggerFactory.getLogger(BookingRunner.class);
int occupants;
	
	@Autowired @Qualifier("place") private ObjectProvider<Location> placeProvider;
	@Autowired LocationRepository lo;
	
	public Location createLocation(String code, String description, Type type, Building building) {
	    if (type.equals(Type.CONFERENCE_ROOM)) {
	        occupants = 100;
	    } else if (type.equals(Type.OPENSPACE)) {
	        occupants = 150;
	    } else if (type.equals(Type.PRIVATE)) {
	        occupants = 1;
	    } else {
	        log.info("Unidentified Type");
	    }

	    return placeProvider.getObject().builder()
	            .code(code)
	            .description(description)
	            .type(type)
	            .occupants(occupants)
	            .building(building)
	            .build(); 
	}

	
	public void saveLocation(Location f) {
		
		lo.save(f);
		log.info( " save location in the DB");
	}
	
	public List<Location> printAllLocations() {
		return (List<Location>)lo.findAll();
	}
	
	 
	public Location locationFind(Long id) {
		return lo.findById(id).get();
	}
	

}


