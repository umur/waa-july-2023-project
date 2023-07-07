package com.twohundred.alumni.service;

import com.twohundred.alumni.entity.Student;
import com.twohundred.alumni.entity.dto.request.StudentDto;

public interface StudentService {
    Student findById(Long id);

    StudentDto update(Student currentStudent, StudentDto studentDto);

    StudentDto delete(Student student);

}
