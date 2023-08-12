package com.example.alumni.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import com.example.alumni.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("select u from User u join u.roles as r where r.role='STUDENT' and u.city=:city")
    List<User> findByCity(String city);

    @Query("select u from User u join u.roles as r where r.role='STUDENT' and u.state=:state")
    List<User> findByState(String state);

    @Query("select u from User u join u.roles as r where r.role='STUDENT' and u.major=:major")
    List<User> findByMajor(String major);
}
