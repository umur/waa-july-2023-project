package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByState(String var);
    Student findByCity(String var);
    Student findByMajor(String var);
    Student findByName(String var);
    List<Student> findAllByIsDeletedFalse();
}
