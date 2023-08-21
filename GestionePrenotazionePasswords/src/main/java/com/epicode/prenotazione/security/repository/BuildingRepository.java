package com.epicode.prenotazione.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.prenotazione.security.model.Building;



public interface BuildingRepository extends CrudRepository<Building, Long> {
	Boolean existsByPinCode(String pincode);

}
