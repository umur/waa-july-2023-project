package com.twohundred.alumni.service;

import com.twohundred.alumni.entity.User;
import com.twohundred.alumni.entity.dto.request.UserPasswordResetDto;

import java.util.List;

public interface UserService {
    void create(User user);

    List<User> findAll();

    void update(User user);

    User getUser(Long id);

    void delete(User user);

    void resetPassword(UserPasswordResetDto userPasswordResetDto);
}
