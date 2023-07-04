package com.example.alumni.controller;

import java.util.List;

import com.example.alumni.service.JobAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.alumni.entity.JobAdvertisement;

@RestController
@RequestMapping("/job-advertisements")
public class JobAdvertisementController {

    @Autowired
    private JobAdvertisementService jobAdvertisementService;



    @GetMapping
    public ResponseEntity<Iterable<JobAdvertisement>> getAllJobAdvs() {
        Iterable<JobAdvertisement> jobAdvs = jobAdvertisementService.getAll();
        return new ResponseEntity<>(jobAdvs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobAdvertisement> getJobAdvById(@PathVariable long id) {
        JobAdvertisement jobAdvertisement = jobAdvertisementService.getById(id);
        if (jobAdvertisement != null) {
            return new ResponseEntity<>(jobAdvertisement, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/tags/{tags}")
    public ResponseEntity<Iterable<JobAdvertisement>> getJobAdvByTags(@PathVariable List<String> tags) {
        Iterable<JobAdvertisement> jobAdv = jobAdvertisementService.getByTags(tags);
        if (jobAdv != null) {
            return new ResponseEntity<>(jobAdv, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<JobAdvertisement> add(@RequestBody JobAdvertisement jobAdvertisement) throws IllegalAccessException {
        JobAdvertisement createdJobAdvertisement = jobAdvertisementService.add(jobAdvertisement);
        return new ResponseEntity<>(createdJobAdvertisement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<JobAdvertisement> update(@PathVariable Long id, @RequestBody JobAdvertisement jobAdvertisement) throws IllegalAccessException {

        Pair<Boolean, JobAdvertisement> result = jobAdvertisementService.update(jobAdvertisement);
        return (!result.getFirst())
        ? new ResponseEntity<>(result.getSecond(), HttpStatus.CREATED)
        : new ResponseEntity<JobAdvertisement>(result.getSecond(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobAdv(@PathVariable long id) {
        boolean deleted = jobAdvertisementService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
