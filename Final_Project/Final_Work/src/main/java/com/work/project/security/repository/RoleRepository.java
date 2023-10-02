package com.work.project.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.project.security.entity.ERole;
import com.work.project.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
