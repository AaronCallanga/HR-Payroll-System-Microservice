package com.hrps.authservice.repository;

import com.hrps.authservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Set<Role> findByEmail(String email);
}
