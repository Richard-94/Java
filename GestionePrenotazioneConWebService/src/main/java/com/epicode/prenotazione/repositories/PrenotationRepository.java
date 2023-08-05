package com.epicode.prenotazione.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.epicode.prenotazione.model.Prenotation;
import com.epicode.prenotazione.model.User;

public interface PrenotationRepository extends CrudRepository<Prenotation, Long> {
	 boolean existsByOccupiedTrue();
	 List<Prenotation> findByPrenotationDateAndUser(LocalDate date, User user);

	}

	



