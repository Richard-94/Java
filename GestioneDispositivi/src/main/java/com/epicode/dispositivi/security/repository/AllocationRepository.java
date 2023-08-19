package com.epicode.dispositivi.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.dispositivi.security.constants.Status;
import com.epicode.dispositivi.security.model.Allocation;

public interface AllocationRepository extends CrudRepository<Allocation, Long> {
	//Allocation findByStatus (Status status);

}
