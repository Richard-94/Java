package com.tesifacile.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.tesifacile.project.model.RicieveMessage;

public interface TesiRepository extends CrudRepository<RicieveMessage, Long> {

	RicieveMessage findByName(String name);

}
