package com.epicode.prenotazione.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.prenotazione.security.entity.ERole;
import com.epicode.prenotazione.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
