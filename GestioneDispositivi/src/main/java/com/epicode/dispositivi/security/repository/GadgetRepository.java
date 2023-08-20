package com.epicode.dispositivi.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.dispositivi.security.constants.Status;

import com.epicode.dispositivi.security.model.Gadget;

public interface GadgetRepository extends CrudRepository<Gadget, Long> {
	Gadget findByStatus (Status status);
	 Gadget findByIsbn(String isbn);

}
