package com.example.alumni.controller;

import com.example.alumni.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.alumni.entity.Resume;

@RestController
@RequestMapping("/resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping
    public ResponseEntity<Iterable<Resume>> getAll() {
        Iterable<Resume> cvs = resumeService.getAll();
        return new ResponseEntity<>(cvs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resume> getById(@PathVariable long id) {
        Resume resume = resumeService.getById(id);
        if (resume != null) {
            return new ResponseEntity<>(resume, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Resume> add(@RequestBody Resume resume) throws IllegalAccessException {
        Resume createdResume = resumeService.add(resume);
        return new ResponseEntity<>(createdResume, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resume> update(@PathVariable long id, @RequestBody Resume resume) throws IllegalAccessException {
        Pair<Boolean, Resume> result = resumeService.update(resume);
        return (!result.getFirst())
        ? new ResponseEntity<>(result.getSecond(), HttpStatus.CREATED)
        : new ResponseEntity<Resume>(result.getSecond(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) throws IllegalAccessException {
        boolean deleted = resumeService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
