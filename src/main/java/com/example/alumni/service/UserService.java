package com.example.alumni.service;

import com.example.alumni.entity.UniversityMember;
import com.example.alumni.entity.User;
import org.springframework.data.util.Pair;

import java.util.List;

public interface UserService extends BaseService<User, Long> {
    List<User> getAllByMajor(String major);
    List<User> getAllByState(String state);

    List<User> getAllByCity(String city);
}
