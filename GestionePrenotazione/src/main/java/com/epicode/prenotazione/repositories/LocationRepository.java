package com.epicode.prenotazione.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epicode.prenotazione.model.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {

}
