package com.example.alumnimanagementportalproject.controller;

import com.example.alumnimanagementportalproject.entity.*;
import com.example.alumnimanagementportalproject.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @RequestMapping("/login")
    public String login() {
        return "faculty";
    }

    @GetMapping("/job/tag")
    public JobAdvertisement findJobByTag(@PathVariable String tag) {
        return facultyService.findJobByTag(tag);
    }
    @GetMapping("/job/state")
    public JobAdvertisement findJobByState(@PathVariable String state) {
        return facultyService.findJobByLocationState(state);
    }
    @GetMapping("/job/city")
    public JobAdvertisement findJobByCity(@PathVariable String city) {
        return facultyService.findJobByCity(city);
    }
    @GetMapping("/job/company")
    public JobAdvertisement findJobByCompany(@PathVariable String company) {
        return facultyService.findJobByCompany(company);
    }
    @GetMapping("/student/state")
    public Student findStudentByState(@PathVariable String state) {
        return facultyService.findStudentByState(state);
    }
    @GetMapping("/student/city")
    public Student findStudentByCity(String city) {
        return facultyService.findStudentByCity(city);
    }
    @GetMapping("/student/major")
    public Student findStudentByMajor(@PathVariable String major) {
        return facultyService.findStudentByMajor(major);
    }
    @GetMapping("/student/{id}")
    public Student findStudentById(@PathVariable Long id) {
        return facultyService.findStudentById(id);
    }
    @GetMapping("/student/name")
    public Student findStudentByName(@PathVariable String name) {
        return facultyService.findStudentByName(name);
    }
    @PostMapping("/student/all")
    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        return facultyService.updateFaculty(faculty);
    }
    @PostMapping("/comment/all")
    public Comment addComment(@RequestBody Comment comment) {
        return facultyService.addComment(comment);
    }
    @PutMapping("password/reset")
    public PasswordResetToken resetPassword(@RequestBody PasswordResetToken passwordResetToken) {
        return facultyService.resetPassword(passwordResetToken);
    }
}
