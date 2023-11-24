package com.production.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.production.project.model.Spraying;

public interface SprayingRepository extends CrudRepository<Spraying, Long> {

	boolean existsByMachine(String string);

	boolean existsByStatusIsTrue();

}
