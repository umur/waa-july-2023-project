package com.twohundred.alumni.controller;

import com.twohundred.alumni.entity.dto.request.StudentDto;
import com.twohundred.alumni.util.Mapper;
import org.springframework.web.bind.annotation.*;

import com.twohundred.alumni.entity.Faculty;
import com.twohundred.alumni.entity.dto.request.FacultyDto;
import com.twohundred.alumni.service.impl.FacultyServiceImpl;
import com.twohundred.alumni.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {
    private final FacultyServiceImpl facultyServiceImpl;
    private final SecurityUtil securityUtil;

    private final Mapper mapper;

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

    @GetMapping("/filter/students")
    public List<StudentDto> filterStudentsByParam(@RequestParam(value = "state", required = false) String state, @RequestParam(value = "city", required = false) String city, @RequestParam(value = "major", required = false) String major, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "id", required = false) String id) {
        return facultyServiceImpl.filterStudentsBySearchParam(state, city, major, name, id).stream().map(mapper::mapStudentToDTO).collect(Collectors.toList());
    }
}
