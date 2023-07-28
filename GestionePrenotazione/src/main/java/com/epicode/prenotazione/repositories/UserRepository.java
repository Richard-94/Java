package com.epicode.prenotazione.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epicode.prenotazione.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
