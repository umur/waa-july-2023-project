package com.miu.waa.aluminimanagement.repository;

import com.miu.waa.aluminimanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>, JpaSpecificationExecutor<Student> {
    //Optional<Student> findByUserId(String userId);

    //Optional<Student> findByEmail(String email);
}
