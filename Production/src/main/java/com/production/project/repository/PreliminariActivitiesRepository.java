package com.production.project.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.production.project.model.PreliminariActivities;

public interface PreliminariActivitiesRepository extends CrudRepository<PreliminariActivities, Long> {

	Optional<PreliminariActivities> findById(Optional<PreliminariActivities> activitiesId);

}
