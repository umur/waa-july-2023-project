package com.miu.waa.aluminimanagement.service.impl;

import com.miu.waa.aluminimanagement.model.Role;
import com.miu.waa.aluminimanagement.repository.RoleRepo;
import com.miu.waa.aluminimanagement.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    @Override
    public Role findRoleByRole(String role) {
        return roleRepo.findRoleByRoleIgnoreCase(role);
    }
}
