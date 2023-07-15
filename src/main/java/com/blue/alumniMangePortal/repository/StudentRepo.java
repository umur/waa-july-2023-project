package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByLastName(String lastName);
    List<Student> findByEmail(String email);
    List<Student> findAllByIsDeletedFalse();
}
