package com.epicode.dispositivi.security.repository;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;

import com.epicode.dispositivi.security.constants.Status;
import com.epicode.dispositivi.security.model.Allocation;
import com.epicode.dispositivi.security.model.Worker;

public interface AllocationRepository extends CrudRepository<Allocation, Long> {
	//Allocation findByStatus (Status status);
	//Allocation findByAssignedDate(LocalDate date);

	Allocation findByWorkers(Worker worker);

	Allocation findByAssignedDate(LocalDate allocation);

}
