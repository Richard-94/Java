package com.production.project.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.production.project.model.PreliminariActivities;
import com.production.project.model.Processing;

public interface ProcessingRepository extends CrudRepository<Processing, Long> {

	Optional<Processing> findById(Optional<Processing> processingId);

}
