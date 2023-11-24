package com.production.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.production.project.model.Paintings;

public interface PaintingsRepository extends CrudRepository<Paintings, Long> {

	boolean existsBySetUpOkIsTrue();


}
