package com.epicode.dispositivi.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.dispositivi.security.model.Laptop;

public interface LaptopRepository extends CrudRepository<Laptop, Long> {
	  boolean existsByIsbn(String isbn);

}
