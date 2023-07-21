package com.example.alumnimanagementportalproject.controller;

import com.example.alumnimanagementportalproject.entity.JobAdvertisement;
import com.example.alumnimanagementportalproject.entity.JobExperience;
import com.example.alumnimanagementportalproject.entity.PasswordResetToken;
import com.example.alumnimanagementportalproject.entity.Student;
import com.example.alumnimanagementportalproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public String login() {
        return "student";
    }
    @GetMapping("/job/tag")
    public JobAdvertisement findJobByTag(@PathVariable String tag) {
        return studentService.findJobByTag(tag);
    }
    @GetMapping("/job/state")
    public JobAdvertisement findJobByState(@PathVariable String state) {
        return studentService.findJobByState(state);
    }
    @GetMapping("/job/city")
    public JobAdvertisement findJobByCity(@PathVariable String city) {
        return studentService.findJobByCity(city);
    }
    @GetMapping("/job/company")
    public JobAdvertisement findJobByCompany(@PathVariable String company) {
        return studentService.findJobByCompany(company);
    }
    @PutMapping("/update/profile")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
    @PostMapping("/apply")
    public JobAdvertisement applyJob(@RequestBody JobAdvertisement jobAdvertisement) {
        return studentService.applyJob(jobAdvertisement);
    }
    @PostMapping("/save")
    public JobAdvertisement saveJob(@RequestBody JobAdvertisement jobAdvertisement) {
        return studentService.saveJob(jobAdvertisement);
    }
    @PutMapping("/update/job")
    public JobAdvertisement updateJob(@RequestBody JobAdvertisement jobAdvertisement) {
        return studentService.updateJob(jobAdvertisement);
    }
    @PostMapping("/experience")
    public JobExperience saveJobExperience(@RequestBody JobExperience jobExperience) {
        return studentService.saveJobExperience(jobExperience);
    }
    @PostMapping("/reset")
    public PasswordResetToken resetPassword(@RequestBody PasswordResetToken passwordResetToken) {
        return studentService.resetPassword(passwordResetToken);
    }
}
