package com.miu.waa.aluminimanagement.service;

import com.miu.waa.aluminimanagement.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();
    Optional<Student> findById(Long id);
    Student save(Student student);
    void delete(Long id);

}
