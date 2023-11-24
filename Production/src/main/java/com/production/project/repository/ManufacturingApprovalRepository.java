package com.production.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.production.project.model.ManufacturingApproval;

public interface ManufacturingApprovalRepository extends CrudRepository<ManufacturingApproval, Long> {

	boolean existsBySetUpOkIsTrue();


}
