//package com.example.finalprojectbackend.controller;
//
//import com.example.finalprojectbackend.entity.Job;
//import com.example.finalprojectbackend.service.JobService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@Controller("/jobs")
//public class JobController {
//    @Autowired
//    private JobService jobService;
//
//    @GetMapping(value = {"/all/hello"})
//    public List<Job> getHello() {
//
//        return jobService.getAllJobs();
//    }
//}
