package com.twohundred.alumni.service.impl;

import com.twohundred.alumni.entity.User;
import com.twohundred.alumni.entity.dto.request.UserPasswordResetDto;
import com.twohundred.alumni.repository.UserRepo;
import com.twohundred.alumni.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    public void create(User user) {
        userRepo.save(user);
    }

    public List<User> findAll() {
        List<User> result = new ArrayList<>();
        userRepo.findAll().forEach(result::add);
        return result;
    }

    @Override
    public void update(User user) {
        userRepo.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepo.findById(id).orElseGet(null);
    }

    @Override
    public void delete(User user) {
        userRepo.delete(user);
    }

    @Override
    public void resetPassword(UserPasswordResetDto userPasswordResetDto) {
        User user = getUser(userPasswordResetDto.getId());
        if(userPasswordResetDto.getOldPassword() == null ||
                user.getPassword().equals(passwordEncoder.encode(userPasswordResetDto.getOldPassword()))) {
            throw new RuntimeException("User password is incorrect!");
        }

        if(userPasswordResetDto.getNewPassword() == null ||
           !userPasswordResetDto.getNewPassword().equals(userPasswordResetDto.getNewPasswordConfirm())) {
            throw new RuntimeException("User new password does not match witch confirmed password!");
        }
        user.setPassword(passwordEncoder.encode(userPasswordResetDto.getNewPassword()));
        update(user);
    }
}
