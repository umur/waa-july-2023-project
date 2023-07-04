package com.example.alumni.service;

import com.example.alumni.entity.User;
import org.springframework.data.util.Pair;

public interface UserService {
    Iterable<User> getAllUsers();

    User getUserById(long id);

    User createUser(User user);

    Pair<Boolean, User> updateUser(User user);

    boolean deleteUser(long id);
}
