package com.miu.waa.aluminimanagement.repository;

import com.miu.waa.aluminimanagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findRoleByRoleIgnoreCase(String role);
}
