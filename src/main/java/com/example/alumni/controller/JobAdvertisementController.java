package com.example.alumni.controller;

import java.util.List;

import com.example.alumni.entity.dto.JobAdvertisementDto;
import com.example.alumni.service.JobAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job-advertisements")
public class JobAdvertisementController {

    @Autowired
    private JobAdvertisementService jobAdvertisementService;


    @GetMapping
    @PreAuthorize("hasAuthority('STUDENT') or hasAuthority('FACULTY')")
    public ResponseEntity<Iterable<JobAdvertisementDto>> getAll() {
        Iterable<JobAdvertisementDto> jobs = jobAdvertisementService.getAll();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('STUDENT') or hasAuthority('FACULTY')")
    public ResponseEntity<JobAdvertisementDto> getById(@PathVariable long id) {
        JobAdvertisementDto jobAdvertisement = jobAdvertisementService.getById(id);
        if (jobAdvertisement != null) {
            return new ResponseEntity<>(jobAdvertisement, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/tags/")
    @PreAuthorize("hasAuthority('STUDENT') or hasAuthority('FACULTY')")
    public ResponseEntity<Iterable<JobAdvertisementDto>> getByTags(@RequestParam List<String> tags) {
        Iterable<JobAdvertisementDto> jobs = jobAdvertisementService.getByTags(tags);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<JobAdvertisementDto> add(@RequestBody JobAdvertisementDto jobAdvertisement) throws IllegalAccessException {
        JobAdvertisementDto createdJobAdvertisement = jobAdvertisementService.add(jobAdvertisement);
        return new ResponseEntity<>(createdJobAdvertisement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<JobAdvertisementDto> update(@PathVariable Long id, @RequestBody JobAdvertisementDto jobAdvertisement) throws IllegalAccessException {

        Pair<Boolean, JobAdvertisementDto> result = jobAdvertisementService.update(jobAdvertisement);
        return (!result.getFirst())
                ? new ResponseEntity<>(result.getSecond(), HttpStatus.CREATED)
                : new ResponseEntity<>(result.getSecond(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('STUDENT') or hasAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws IllegalAccessException {
        boolean deleted = jobAdvertisementService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
