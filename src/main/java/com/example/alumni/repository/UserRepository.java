package com.example.alumni.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.alumni.entity.User;

public interface UserRepository extends ListCrudRepository<User, Long> {
}
