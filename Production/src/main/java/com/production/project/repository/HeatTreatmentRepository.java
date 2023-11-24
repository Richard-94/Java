package com.production.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.production.project.model.HeatTreatment;

public interface HeatTreatmentRepository extends CrudRepository<HeatTreatment, Long> {

	boolean existsByMachine(String string);

	boolean existsByStatusIsTrue();

}
