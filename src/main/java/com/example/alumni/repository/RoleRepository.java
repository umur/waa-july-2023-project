package com.example.alumni.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.alumni.entity.Role;

public interface RoleRepository extends ListCrudRepository<Role, Long> {
}
