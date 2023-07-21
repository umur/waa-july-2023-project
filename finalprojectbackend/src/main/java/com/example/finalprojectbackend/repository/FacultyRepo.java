package com.example.finalprojectbackend.repository;

import com.example.finalprojectbackend.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepo extends JpaRepository<Faculty, Integer> {
}
