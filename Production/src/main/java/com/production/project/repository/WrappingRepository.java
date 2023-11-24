package com.production.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.production.project.model.Wrapping;

public interface WrappingRepository extends CrudRepository<Wrapping, Long> {

	boolean existsByMachine(String string);

	boolean existsByStatusIsTrue();

}
