package com.epicode.dispositivi.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.dispositivi.security.model.Laptop;
import com.epicode.dispositivi.security.model.Tablet;

public interface TabletRepository extends CrudRepository<Tablet, Long> {
	  boolean existsByIsbn(String isbn);
	  public Tablet findByIsbn(String isbn);

}
