package com.epicode.dispositivi.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.dispositivi.security.model.Laptop;
import com.epicode.dispositivi.security.model.Smartphone;

public interface SmartphoneRepository extends CrudRepository<Smartphone, Long> {
	boolean existsByIsbn(String isbn);
	public Smartphone findByIsbn(String isbn);

}
