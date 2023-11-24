package com.production.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.production.project.model.Springs;

public interface SpringRepository extends CrudRepository<Springs, Long> {

	boolean existsBySteelType(String string);



	boolean existsByOrderNumber(String string);
	
    

}
