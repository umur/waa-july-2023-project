package com.twohundred.alumni.service.impl;

import com.twohundred.alumni.entity.User;
import com.twohundred.alumni.entity.dto.request.UserPasswordResetDto;
import com.twohundred.alumni.repository.UserRepo;
import com.twohundred.alumni.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        if(userPasswordResetDto.getPassword() == null ||
                !passwordEncoder.matches(userPasswordResetDto.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User current password is incorrect!");
        }

        if(userPasswordResetDto.getNewPassword() == null ||
           !userPasswordResetDto.getNewPassword().equals(userPasswordResetDto.getConfirmPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User new password does not match witch confirmed password!");
        }
        user.setPassword(passwordEncoder.encode(userPasswordResetDto.getNewPassword()));
        update(user);
    }
}
