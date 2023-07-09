package com.alumni.Service;

import com.alumni.entity.BaseUser;
import com.alumni.entity.Role;

import java.util.List;

public interface BaseUserService {

    BaseUser save(String email, String password, List<Role> roles);

    void changePassword( BaseUser user,String password);
}
