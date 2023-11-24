package com.production.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.production.project.model.RawMaterials;

public interface RawMaterialRepository extends CrudRepository<RawMaterials, Long> {

	

	
	
	boolean existsById(RawMaterials id);

	boolean existsBySetUpOkIsTrue();
	
	//boolean existsBySetUpOkIsTrue(Long rawMatId);








	

}
