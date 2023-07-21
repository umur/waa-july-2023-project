package com.miu.waa.aluminimanagement.repository;

import com.miu.waa.aluminimanagement.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

//    Optional<Faculty> findByUserId(String userId);

//    Optional<Faculty> findByEmail(String email);

}
