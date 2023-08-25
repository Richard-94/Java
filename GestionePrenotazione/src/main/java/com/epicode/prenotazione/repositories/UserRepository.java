package com.epicode.prenotazione.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epicode.prenotazione.constants.Type;
import com.epicode.prenotazione.model.Location;
import com.epicode.prenotazione.model.Prenotation;
import com.epicode.prenotazione.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	

}
