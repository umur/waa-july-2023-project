package com.example.alumni.service.impl;

import com.example.alumni.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.alumni.entity.Role;
import com.example.alumni.repository.RoleRepository;

import org.springframework.data.util.Pair;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Iterable<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Pair<Boolean, Role> updateRole(Role role) {
        boolean exists = roleRepository.existsById(role.getId());
        roleRepository.save(role);
        return Pair.of(exists, role);
    }
    @Override
    public boolean deleteRole(long id) {
        Role existingRole = roleRepository.findById(id).orElse(null);
        if (existingRole != null) {
            roleRepository.delete(existingRole);
            return true;
        }
        return false;
    }
}
