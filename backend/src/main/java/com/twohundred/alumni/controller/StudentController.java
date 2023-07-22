package com.twohundred.alumni.controller;

import com.twohundred.alumni.aspect.annotation.LogMe;
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
@RequestMapping("/students/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {
    private final StudentServiceImpl studentServiceImpl;
    private final SecurityUtil securityUtil;
    private final ExperienceServiceImpl experienceService;

    @LogMe
    @PutMapping
    public StudentDto update(@RequestBody StudentDto studentDto) {
        User currentStudent = securityUtil.getCurrentUser();
        studentDto.setId(currentStudent.getId());
        return studentServiceImpl.update(studentDto);
    }

    @LogMe
    @DeleteMapping
    public StudentDto delete() {
        User currentStudent = securityUtil.getCurrentUser();
        return studentServiceImpl.delete(currentStudent);
    }

    @PostMapping("experience")
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

    @PutMapping("/experience")
    public ResponseEntity<?> updateExperience(@RequestBody ExperienceDto experienceDto) {
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
        return ResponseEntity.ok(experienceService.update(experience));
    }
    @GetMapping("/experience")
    public ResponseEntity<?> getExperience(@RequestParam long id) {
        return ResponseEntity.ok(experienceService.getExperiencesByUserId(id));
    }

    @DeleteMapping("/experience")
    public ResponseEntity<?> deleteExperienceById(@RequestParam long id) {
        try {
            experienceService.delete(id);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok("Experience deleted successfully");
    }

}
