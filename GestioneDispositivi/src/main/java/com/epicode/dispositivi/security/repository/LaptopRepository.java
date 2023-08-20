package com.epicode.dispositivi.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.dispositivi.security.model.Laptop;
import com.epicode.dispositivi.security.model.Worker;

public interface LaptopRepository extends CrudRepository<Laptop, Long> {
	  boolean existsByIsbn(String isbn);
	  public Laptop findByIsbn(String isbn);

}
