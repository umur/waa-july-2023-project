package com.example.alumni.service;

import com.example.alumni.entity.User;
import com.example.alumni.entity.dto.request.ResetUserPasswordRequest;
import com.example.alumni.entity.dto.request.ToggleUserStatusRequest;

import java.util.List;

public interface UserService extends BaseService<User, Long> {
    List<User> getAllByMajor(String major);
    List<User> getAllByState(String state);
    List<User> getAllByCity(String city);

    User toggleUserStatus(ToggleUserStatusRequest toggleUserStatusRequest);

    User resetUserPassword(ResetUserPasswordRequest resetUserPasswordRequest);
}
