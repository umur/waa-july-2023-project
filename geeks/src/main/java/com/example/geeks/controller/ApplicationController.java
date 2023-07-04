package com.example.geeks.controller;

import com.example.geeks.entity.Application;
import com.example.geeks.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Qualifier("aps")
    @Autowired
    ApplicationService applicationService;

    @PostMapping
    public Application addApplication(@RequestBody Application application) {
        Application savedApplication = applicationService.addApplication(application);
        return savedApplication;
    }

    @GetMapping
    public List<Application> getAllApplications() {
        List<Application> applications = applicationService.getAllApplications();
        return applications;
    }

    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable Long id) {
        Application application = applicationService.getApplicationById(id);
        if (application != null) {
            return application;
        } else {
            return null;
        }
    }

    @GetMapping("/student/{studentId}")
    public List<Application> getApplicationsOfStudent(@PathVariable Long studentId) {
        List<Application> applications = applicationService.getApplicationsOfStudent(studentId);
        return applications;
    }
}
