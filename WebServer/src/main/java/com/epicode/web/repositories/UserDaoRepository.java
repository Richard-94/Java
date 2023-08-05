package com.epicode.web.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epicode.web.model.User;

public interface UserDaoRepository extends CrudRepository<User, Long> {
	 //User findByUserName(String name);
}
