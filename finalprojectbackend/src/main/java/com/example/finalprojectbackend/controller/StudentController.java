package com.example.finalprojectbackend.controller;

import com.example.finalprojectbackend.entity.Job;
import com.example.finalprojectbackend.entity.Student;
import com.example.finalprojectbackend.service.JobService;
import com.example.finalprojectbackend.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private JobService jobService;

   @GetMapping(value = {"/all/jobs"})
    public ResponseEntity<List<Job>>getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }
    @GetMapping(value = {"/students/all"})
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @DeleteMapping(value = {"/{id}"} )
    public void delete(@PathVariable Integer id){
        jobService.delete(id);

    }





}
