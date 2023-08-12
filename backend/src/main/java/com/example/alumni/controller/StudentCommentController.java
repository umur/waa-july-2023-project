package com.example.alumni.controller;

import com.example.alumni.service.StudentCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.alumni.entity.StudentComment;

@RestController
@RequestMapping("/student-comments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentCommentController {

    @Autowired
    private StudentCommentService studentCommentService;

    @GetMapping
    @PreAuthorize("hasAuthority('FACULTY')")
    public ResponseEntity<Iterable<StudentComment>> getAll() {
        Iterable<StudentComment> cvs = studentCommentService.getAll();
        return new ResponseEntity<>(cvs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('FACULTY')")
    public ResponseEntity<StudentComment> getById(@PathVariable long id) {
        StudentComment studentComment = studentCommentService.getById(id);
        if (studentComment != null) {
            return new ResponseEntity<>(studentComment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('FACULTY')")
    public ResponseEntity<StudentComment> add(@RequestBody StudentComment studentComment) throws IllegalAccessException {
        StudentComment createdStudentComment = studentCommentService.add(studentComment);
        return new ResponseEntity<>(createdStudentComment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('FACULTY')")
    public ResponseEntity<StudentComment> update(@PathVariable long id, @RequestBody StudentComment studentComment) throws IllegalAccessException {
        Pair<Boolean, StudentComment> result = studentCommentService.update(studentComment);
        return (!result.getFirst())
        ? new ResponseEntity<>(result.getSecond(), HttpStatus.CREATED)
        : new ResponseEntity<StudentComment>(result.getSecond(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('FACULTY')")
    public ResponseEntity<Void> delete(@PathVariable long id) throws IllegalAccessException {
        boolean deleted = studentCommentService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
