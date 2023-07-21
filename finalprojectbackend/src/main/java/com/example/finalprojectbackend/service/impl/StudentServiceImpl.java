package com.example.finalprojectbackend.service.impl;

import com.example.finalprojectbackend.entity.Job;
import com.example.finalprojectbackend.entity.Student;
import com.example.finalprojectbackend.repository.JobRepo;
import com.example.finalprojectbackend.repository.StudentRepo;
import com.example.finalprojectbackend.service.JobService;
import com.example.finalprojectbackend.service.StudentService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class StudentServiceImpl implements StudentService{
    @Autowired
    private JobRepo jobRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepo.deleteById(id);
    }


}
