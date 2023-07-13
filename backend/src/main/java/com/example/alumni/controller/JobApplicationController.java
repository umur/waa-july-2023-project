package com.example.alumni.controller;

import com.example.alumni.entity.JobApplication;
import com.example.alumni.entity.Resume;
import com.example.alumni.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job-applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @GetMapping
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<Iterable<JobApplication>> getAll() {
        Iterable<JobApplication> cvs = jobApplicationService.getAll();
        return new ResponseEntity<>(cvs, HttpStatus.OK);
    }
    @GetMapping("/all-applicants-for-my-jobs")
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<Iterable<JobApplication>> getAllApplicantsForMyJobs() {
        Iterable<JobApplication> cvs = jobApplicationService.getAllApplicantsForMyJobs();
        return new ResponseEntity<>(cvs, HttpStatus.OK);
    }

    @GetMapping("/job/{jobid}/student/{studentid}")
    @PreAuthorize("hasAuthority('STUDENT') or hasAuthority('FACULTY')")
    public ResponseEntity<JobApplication> getByJobId(@PathVariable Long jobId, @PathVariable Long studentId) {
        JobApplication resume = jobApplicationService.getByJobId(jobId);
        if (resume != null) {
            return new ResponseEntity<>(resume, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<JobApplication> add(@RequestBody JobApplication jobApplication) throws IllegalAccessException {
        JobApplication createdJobApplication = jobApplicationService.add(jobApplication);
        return new ResponseEntity<>(createdJobApplication, HttpStatus.CREATED);
    }
    @DeleteMapping("/job/{jobid}")
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<Void> delete(@PathVariable Long jobid) throws IllegalAccessException {
        boolean deleted = jobApplicationService.deleteByJobId(jobid);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
