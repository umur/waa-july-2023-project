package com.twohundred.alumni.controller;

import com.twohundred.alumni.entity.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twohundred.alumni.entity.dto.request.StudentDto;
import com.twohundred.alumni.service.impl.StudentServiceImpl;
import com.twohundred.alumni.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServiceImpl studentServiceImpl;
    private final SecurityUtil securityUtil;

    @PutMapping
    public StudentDto update(StudentDto studentDto) {
        return studentServiceImpl.update(studentDto);
    }

    @DeleteMapping
    public StudentDto delete() {
        User currentStudent = securityUtil.getCurrentUser();
        return studentServiceImpl.delete(currentStudent);
    }

}
