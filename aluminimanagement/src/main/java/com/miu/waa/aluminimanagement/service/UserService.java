package com.miu.waa.aluminimanagement.service;

import com.miu.waa.aluminimanagement.model.dto.LoginRequest;
import com.miu.waa.aluminimanagement.model.dto.LoginResponse;
import com.miu.waa.aluminimanagement.model.dto.RegisterDto;
import com.miu.waa.aluminimanagement.model.dto.RoleDto;

import java.util.List;

public interface UserService {

    LoginResponse login(LoginRequest loginRequest);

    void register(RegisterDto person);

    List<RoleDto> findAllRoles();
}
