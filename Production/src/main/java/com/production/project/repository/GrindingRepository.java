package com.production.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.production.project.model.Grinding;

public interface GrindingRepository extends CrudRepository<Grinding, Long> {

	boolean existsByMachine(String string);

	boolean existsByStatusIsTrue();

}
