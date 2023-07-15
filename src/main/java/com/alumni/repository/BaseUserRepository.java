package com.alumni.repository;

import com.alumni.entity.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BaseUserRepository extends JpaRepository<BaseUser, Long> {

    BaseUser findByEmailAndPassword(String email, String password);

    Optional<BaseUser> findByEmail(String email);
}
