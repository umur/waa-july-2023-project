package com.example.alumni.controller;

import java.util.List;

import com.example.alumni.service.JobJobAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.alumni.entity.JobAdvertisement;

@RestController
@RequestMapping("/jobAdvs")
public class JobAdvController {

    @Autowired
    private JobJobAdvertisementService jobJobAdvertisementService;

    @GetMapping
    public ResponseEntity<Iterable<JobAdvertisement>> getAllJobAdvs() {
        Iterable<JobAdvertisement> jobAdvs = jobJobAdvertisementService.getAllJobAdvs();
        return new ResponseEntity<>(jobAdvs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobAdvertisement> getJobAdvById(@PathVariable long id) {
        JobAdvertisement jobAdvertisement = jobJobAdvertisementService.getJobAdvById(id);
        if (jobAdvertisement != null) {
            return new ResponseEntity<>(jobAdvertisement, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/tags/{tags}")
    public ResponseEntity<Iterable<JobAdvertisement>> getJobAdvByTags(@PathVariable List<String> tags) {
        Iterable<JobAdvertisement> jobAdv = jobJobAdvertisementService.getJobAdvByTags(tags);
        if (jobAdv != null) {
            return new ResponseEntity<>(jobAdv, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<JobAdvertisement> createJobAdv(@RequestBody JobAdvertisement jobAdvertisement) {
        JobAdvertisement createdJobAdvertisement = jobJobAdvertisementService.createJobAdv(jobAdvertisement);
        return new ResponseEntity<>(createdJobAdvertisement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobAdvertisement> updateJobAdv(@PathVariable long id, @RequestBody JobAdvertisement jobAdvertisement) {
        Pair<Boolean, JobAdvertisement> result = jobJobAdvertisementService.updateJobAdv(jobAdvertisement);
        return (!result.getFirst())
        ? new ResponseEntity<>(result.getSecond(), HttpStatus.CREATED)
        : new ResponseEntity<JobAdvertisement>(result.getSecond(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobAdv(@PathVariable long id) {
        boolean deleted = jobJobAdvertisementService.deleteJobAdv(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
