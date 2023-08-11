package com.epicode.dispositivi.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.dispositivi.security.entity.ERole;
import com.epicode.dispositivi.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
