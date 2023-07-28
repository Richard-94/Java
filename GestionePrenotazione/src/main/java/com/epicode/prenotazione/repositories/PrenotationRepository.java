package com.epicode.prenotazione.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epicode.prenotazione.model.Prenotation;

public interface PrenotationRepository extends CrudRepository<Prenotation, Long> {

}
