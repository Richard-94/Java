package com.production.project.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.production.project.model.Equipment;

public interface EquipmentRepository extends CrudRepository<Equipment, Long> {

	boolean existsBySetUpOkIsTrue();

	Optional<Equipment> findByMachine(String equipmentName);


}
