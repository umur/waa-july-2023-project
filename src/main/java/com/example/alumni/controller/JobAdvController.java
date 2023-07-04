package com.example.alumni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.alumni.entity.JobAdv;
import com.example.alumni.entity.Tag;
import com.example.alumni.service.JobAdvService;

@RestController
@RequestMapping("/jobAdvs")
public class JobAdvController {

    @Autowired
    private JobAdvService jobAdvService;

    @GetMapping
    public ResponseEntity<Iterable<JobAdv>> getAllJobAdvs() {
        Iterable<JobAdv> jobAdvs = jobAdvService.getAllJobAdvs();
        return new ResponseEntity<>(jobAdvs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobAdv> getJobAdvById(@PathVariable long id) {
        JobAdv jobAdv = jobAdvService.getJobAdvById(id);
        if (jobAdv != null) {
            return new ResponseEntity<>(jobAdv, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/tags")
    public ResponseEntity<Iterable<JobAdv>> getJobAdvByTags(@RequestBody List<Tag> tags) {
        Iterable<JobAdv> jobAdv = jobAdvService.getJobAdvByTags(tags);
        if (jobAdv != null) {
            return new ResponseEntity<>(jobAdv, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<JobAdv> createJobAdv(@RequestBody JobAdv jobAdv) {
        JobAdv createdJobAdv = jobAdvService.createJobAdv(jobAdv);
        return new ResponseEntity<>(createdJobAdv, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobAdv> updateJobAdv(@PathVariable long id, @RequestBody JobAdv jobAdv) {
        Pair<Boolean, JobAdv> result = jobAdvService.updateJobAdv(jobAdv);
        return (!result.getFirst())
        ? new ResponseEntity<>(result.getSecond(), HttpStatus.CREATED)
        : new ResponseEntity<JobAdv>(result.getSecond(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobAdv(@PathVariable long id) {
        boolean deleted = jobAdvService.deleteJobAdv(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
