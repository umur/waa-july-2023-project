package com.example.alumnimanagementportalproject.repository;


import com.example.alumnimanagementportalproject.entity.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

}