package com.twohundred.alumni.repository;

import com.twohundred.alumni.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
