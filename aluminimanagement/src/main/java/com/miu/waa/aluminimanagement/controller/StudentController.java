package com.miu.waa.aluminimanagement.controller;

import com.miu.waa.aluminimanagement.model.StudentPerState;
import com.miu.waa.aluminimanagement.model.dto.StudentDto;
import com.miu.waa.aluminimanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/students")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_FACULTY','ROLE_ADMIN')")
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public List<StudentDto> findAll(
            @RequestParam(required = false, defaultValue = "") String filter,
            @RequestParam(required = false, defaultValue = "") String value
    ) {
        var students = studentService.findAll(filter, value);
        return students;
    }

    @GetMapping("/perState")
    public List<StudentPerState> noOfStudentsPerState(){
        return studentService.noOfStudentsPerState();
    }


}
