package com.twohundred.alumni.service.impl;

import com.twohundred.alumni.entity.Role;
import com.twohundred.alumni.repository.RoleRepo;
import com.twohundred.alumni.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;
    @Override
    public List<Role> findAll() {
        List<Role> result = new ArrayList<>();
        roleRepo.findAll().forEach(result::add);
        return result;
    }
}
