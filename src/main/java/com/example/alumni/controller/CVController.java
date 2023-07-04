package com.example.alumni.controller;

import com.example.alumni.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.alumni.entity.CV;

@RestController
@RequestMapping("/cvs")
public class CVController {

    @Autowired
    private CVService cvService;

    @GetMapping
    public ResponseEntity<Iterable<CV>> getAllCVs() {
        Iterable<CV> cvs = cvService.getAllCVs();
        return new ResponseEntity<>(cvs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CV> getCVById(@PathVariable long id) {
        CV cv = cvService.getCVById(id);
        if (cv != null) {
            return new ResponseEntity<>(cv, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CV> createCV(@RequestBody CV cv) {
        CV createdCV = cvService.createCV(cv);
        return new ResponseEntity<>(createdCV, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CV> updateCV(@PathVariable long id, @RequestBody CV cv) {
        Pair<Boolean, CV> result = cvService.updateCV(cv);
        return (!result.getFirst())
        ? new ResponseEntity<>(result.getSecond(), HttpStatus.CREATED)
        : new ResponseEntity<CV>(result.getSecond(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCV(@PathVariable long id) {
        boolean deleted = cvService.deleteCV(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
