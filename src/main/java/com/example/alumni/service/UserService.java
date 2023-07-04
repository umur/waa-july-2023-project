package com.example.alumni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.alumni.entity.User;
import com.example.alumni.repository.UserRepository;

import org.springframework.data.util.Pair;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Pair<Boolean, User> updateUser(User user) {
        boolean exists = userRepository.existsById(user.getId());
        userRepository.save(user);
        return Pair.of(exists, user);
    }

    public boolean deleteUser(long id) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            userRepository.delete(existingUser);
            return true;
        }
        return false;
    }
}
