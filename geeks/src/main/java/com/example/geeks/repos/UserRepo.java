package com.example.geeks.repos;

import com.example.geeks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, List<User>> {



    public User findById(Long id);
    public List<User> findByState(String stateName);
    public List<User> findByCity(String cityName);
    public List<User> findByMajor(String major);
    public List<User> findByNameContaining(String name);
    public List<User> findByIdContaining(Long id);
}
