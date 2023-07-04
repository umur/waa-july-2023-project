package com.example.alumni.service;

import com.example.alumni.entity.Role;
import org.springframework.data.util.Pair;

public interface RoleService {
    Iterable<Role> getAllRoles();

    Role getRoleById(long id);

    Role createRole(Role role);

    Pair<Boolean, Role> updateRole(Role role);

    boolean deleteRole(long id);

    Role findByRole(String role);
}
