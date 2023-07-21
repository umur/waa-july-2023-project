package com.example.finalprojectbackend.repository;

import com.example.finalprojectbackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
