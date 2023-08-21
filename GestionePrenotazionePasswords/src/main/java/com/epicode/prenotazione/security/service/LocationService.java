package com.epicode.prenotazione.security.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.prenotazione.security.constants.Type;
import com.epicode.prenotazione.security.model.Building;
import com.epicode.prenotazione.security.model.Location;
import com.epicode.prenotazione.security.repository.LocationRepository;

@Service
public class LocationService {
Logger log = LoggerFactory.getLogger(LocationService.class);
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
	
	
	public List<Location> findByCityAndType(Type t, String city) {
	    List<Location> userLocations = lo.findByTypeAndCity(t, city);
	    userLocations.forEach(k -> log.info("The locations in the city are " + k));
	    return userLocations;
	}

	

}


