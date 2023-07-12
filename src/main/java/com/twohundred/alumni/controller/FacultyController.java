package com.twohundred.alumni.controller;

import com.twohundred.alumni.entity.User;
import com.twohundred.alumni.entity.dto.request.StudentDto;
import com.twohundred.alumni.util.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.twohundred.alumni.entity.dto.request.FacultyDto;
import com.twohundred.alumni.service.impl.FacultyServiceImpl;
import com.twohundred.alumni.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {
    private final FacultyServiceImpl facultyServiceImpl;
    private final SecurityUtil securityUtil;

    private final Mapper mapper;

    @PutMapping
    public FacultyDto update(FacultyDto facultyDto) {
        User currentFaculty = securityUtil.getCurrentUser();
        return facultyServiceImpl.update(currentFaculty, facultyDto);
    }

    @DeleteMapping
    public FacultyDto delete() {
        User currentFaculty = securityUtil.getCurrentUser();
        return facultyServiceImpl.delete(currentFaculty);
    }

    @GetMapping("/filter/students")
    public ResponseEntity<?> filterStudentsByParam(@RequestParam(value = "state", required = false) String state, @RequestParam(value = "city", required = false) String city, @RequestParam(value = "major", required = false) String major, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "id", required = false) String id) {
        List<StudentDto> result = new ArrayList<>();
        try {
            result.addAll(facultyServiceImpl.filterStudentsBySearchParam(state, city, major, name, id).stream().map(mapper::mapStudentToDTO).toList());
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }

        return ResponseEntity.ok(result);
    }
}
