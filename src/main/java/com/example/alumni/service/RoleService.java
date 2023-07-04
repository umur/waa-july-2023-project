package com.example.alumni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.alumni.entity.Role;
import com.example.alumni.repository.RoleRepository;

import org.springframework.data.util.Pair;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Iterable<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Pair<Boolean, Role> updateRole(Role role) {
        boolean exists = roleRepository.existsById(role.getId());
        roleRepository.save(role);
        return Pair.of(exists, role);
    }

    public boolean deleteRole(long id) {
        Role existingRole = roleRepository.findById(id).orElse(null);
        if (existingRole != null) {
            roleRepository.delete(existingRole);
            return true;
        }
        return false;
    }
}
