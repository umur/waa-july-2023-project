package com.twohundred.alumni.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twohundred.alumni.entity.Faculty;
import com.twohundred.alumni.entity.dto.request.FacultyDto;
import com.twohundred.alumni.service.impl.FacultyServiceImpl;
import com.twohundred.alumni.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {
    private final FacultyServiceImpl facultyServiceImpl;
    private final SecurityUtil securityUtil;

    @PutMapping
    public FacultyDto update(FacultyDto facultyDto) {
        Faculty currentFaculty = securityUtil.getCurrentUser().getFaculty();
        return facultyServiceImpl.update(currentFaculty, facultyDto);
    }

    @DeleteMapping
    public FacultyDto delete() {
        Faculty currentFaculty = securityUtil.getCurrentUser().getFaculty();
        return facultyServiceImpl.delete(currentFaculty);
    }
}
