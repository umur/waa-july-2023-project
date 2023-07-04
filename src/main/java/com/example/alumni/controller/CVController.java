package com.example.alumni.controller;

import com.example.alumni.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.alumni.entity.Resume;

@RestController
@RequestMapping("/cvs")
public class CVController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping
    public ResponseEntity<Iterable<Resume>> getAllCVs() {
        Iterable<Resume> cvs = resumeService.getAllCVs();
        return new ResponseEntity<>(cvs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resume> getCVById(@PathVariable long id) {
        Resume resume = resumeService.getCVById(id);
        if (resume != null) {
            return new ResponseEntity<>(resume, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Resume> createCV(@RequestBody Resume resume) {
        Resume createdResume = resumeService.createCV(resume);
        return new ResponseEntity<>(createdResume, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resume> updateCV(@PathVariable long id, @RequestBody Resume resume) {
        Pair<Boolean, Resume> result = resumeService.updateCV(resume);
        return (!result.getFirst())
        ? new ResponseEntity<>(result.getSecond(), HttpStatus.CREATED)
        : new ResponseEntity<Resume>(result.getSecond(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCV(@PathVariable long id) {
        boolean deleted = resumeService.deleteCV(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
