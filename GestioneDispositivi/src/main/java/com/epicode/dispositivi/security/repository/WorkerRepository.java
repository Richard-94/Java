package com.epicode.dispositivi.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.dispositivi.security.model.Worker;

public interface WorkerRepository extends CrudRepository<Worker, Long> {
	public boolean existsByEmail(String email);
	public boolean existsByUsername(String username);
	public Worker findByUsername(String username);

}
