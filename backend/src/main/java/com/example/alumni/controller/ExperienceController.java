package com.example.alumni.controller;

import com.example.alumni.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.alumni.entity.Experience;

@RestController
@RequestMapping("/experiences")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<Iterable<Experience>> getAll() {
        Iterable<Experience> experiences = experienceService.getAll();
        return new ResponseEntity<>(experiences, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<Experience> getById(@PathVariable long id) {
        Experience experience = experienceService.getById(id);
        if (experience != null) {
            return new ResponseEntity<>(experience, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<Experience> add(@RequestBody Experience experience) throws IllegalAccessException {
        Experience createdExperience = experienceService.add(experience);
        return new ResponseEntity<>(createdExperience, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<Experience> update(@PathVariable long id, @RequestBody Experience experience) throws IllegalAccessException {

        Pair<Boolean, Experience> result = experienceService.update(experience);
        return (!result.getFirst())
        ? new ResponseEntity<>(result.getSecond(), HttpStatus.CREATED)
        : new ResponseEntity<Experience>(result.getSecond(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<Void> delete(@PathVariable long id) throws IllegalAccessException {
        boolean deleted = experienceService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
