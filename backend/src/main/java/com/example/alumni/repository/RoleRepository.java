package com.example.alumni.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.alumni.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends ListCrudRepository<Role, Long> {
    Role findByRole(String name);
}
