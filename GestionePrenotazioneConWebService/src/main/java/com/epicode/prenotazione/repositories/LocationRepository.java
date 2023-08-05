package com.epicode.prenotazione.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.epicode.prenotazione.constants.Type;
import com.epicode.prenotazione.model.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {
	public Location findByOccupants(int occupants);
	
	 @Query("SELECT l FROM Location l WHERE l.type = ?1 AND l.building.city = ?2")
	    List<Location> findByTypeAndCity(Type t, String city);

}
