package com.epicode.social.repository;

import org.springframework.data.repository.CrudRepository;


import com.epicode.social.model.UserApp;

public interface UserRepository extends CrudRepository<UserApp, Long> {


}
