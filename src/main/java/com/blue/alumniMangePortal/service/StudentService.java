package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Student;

import java.util.List;

public interface StudentService {
    String registerStudent(Student student);

    String updateProfile(Long id, Student student);

    String seeStudentCv(Long id);

    Student filterStudent(Object obj);

    Student getStudentById(Long id);

    List<Student> getAllStudents();

    String addJobExperience(Student student, String jobExperience);

    String resetPassword(Student student, String password);

    List<Student> deleteById(Long id);
}
