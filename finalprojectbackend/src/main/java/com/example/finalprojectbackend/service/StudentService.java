package com.example.finalprojectbackend.service;

import com.example.finalprojectbackend.entity.Job;
import com.example.finalprojectbackend.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();


    void deleteStudent(Integer id);
}
