package com.rimesh.usermanagement.repository;

import com.rimesh.usermanagement.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
