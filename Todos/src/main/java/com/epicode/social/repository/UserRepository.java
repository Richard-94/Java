package com.epicode.social.repository;

import org.springframework.data.repository.CrudRepository;


import com.epicode.social.model.UserApp;

public interface UserRepository extends CrudRepository<UserApp, Long> {

	public boolean existsByUsername(String username);

	public boolean existsByLinkGit(String linkGit);

}
