package com.twohundred.alumni.controller;

import com.twohundred.alumni.entity.Experience;
import com.twohundred.alumni.entity.User;
import com.twohundred.alumni.entity.dto.request.ExperienceDto;
import com.twohundred.alumni.service.impl.ExperienceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private final ExperienceServiceImpl experienceService;

    @PutMapping
    public StudentDto update(StudentDto studentDto) {
        return studentServiceImpl.update(studentDto);
    }

    @DeleteMapping
    public StudentDto delete() {
        User currentStudent = securityUtil.getCurrentUser();
        return studentServiceImpl.delete(currentStudent);
    }

    @PutMapping("/experience")
    public ResponseEntity<?> addExperience(@RequestBody ExperienceDto experienceDto) {
        User currentStudent;
        try {
            currentStudent = securityUtil.getCurrentUser();
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        Experience experience = new Experience();
        experience.setStudent(currentStudent);
        experience.setTitle(experienceDto.getTitle());
        experience.setFrom(experienceDto.getStarDate());
        experience.setTo(experienceDto.getEndDate());
        experience.setCompany(experienceDto.getCompany());
        return ResponseEntity.ok(experienceService.create(experience));
    }

}
