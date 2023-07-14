package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.JobExperience;
import com.blue.alumniMangePortal.entity.Student;

import java.util.List;

public interface StudentService {
    Student registerStudent(Student student);

    Student updateProfile(Long id, Student student);

    String seeStudentCv(Long id);

    List<Student> filterStudent(String obj);

    Student getStudentById(Long id);

    List<Student> getAllStudents();

    String addJobExperience(Long id, JobExperience jobExperience);

    String resetPassword(Student student, String password);

    void deleteById(Long id);
}
