package com.epicode.prenotazione.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.epicode.prenotazione.security.constants.Type;
import com.epicode.prenotazione.security.model.Location;

;

public interface LocationRepository extends CrudRepository<Location, Long> {
	public Location findByOccupants(int occupants);
	
	 @Query("SELECT l FROM Location l WHERE l.type = ?1 AND l.building.city = ?2")
	    List<Location> findByTypeAndCity(Type t, String city);

}
