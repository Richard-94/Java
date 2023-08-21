package com.epicode.prenotazione.security.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epicode.prenotazione.security.model.User;



public interface UserPassRepository extends CrudRepository<User, Long> {
	public boolean existsByEmail(String email);
	

}
