package com.example.alumni.service;

import com.example.alumni.entity.JobApplication;
import com.example.alumni.entity.JobApplicationId;
import com.example.alumni.entity.Role;
import org.springframework.data.util.Pair;

public interface RoleService extends BaseService<Role, Long>{
    Role getByRole(String role);
}
