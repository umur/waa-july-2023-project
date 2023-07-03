package com.twohundred.alumni.service.impl;

import com.twohundred.alumni.entity.User;
import com.twohundred.alumni.repository.UserRepo;
import com.twohundred.alumni.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;

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
}
