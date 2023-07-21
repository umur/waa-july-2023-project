package com.example.alumnimanagementportalproject.repository;


import com.example.alumnimanagementportalproject.entity.Faculty;
import com.example.alumnimanagementportalproject.entity.JobAdvertisement;
import com.example.alumnimanagementportalproject.entity.Student;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {



    Student findStudentByState(String state);
    Student findStudentByCity(String city);
    Student findStudentByMajor(String major);
    Student findStudentById(Long id);
    Student findStudentByName(String name);
}