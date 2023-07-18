package com.twohundred.alumni.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twohundred.alumni.aspect.annotation.LogMe;
import com.twohundred.alumni.entity.Comment;
import com.twohundred.alumni.entity.User;
import com.twohundred.alumni.entity.dto.request.CommentDto;
import com.twohundred.alumni.entity.dto.request.FacultyDto;
import com.twohundred.alumni.entity.dto.request.StudentDto;
import com.twohundred.alumni.service.impl.CommentServiceImpl;
import com.twohundred.alumni.service.impl.FacultyServiceImpl;
import com.twohundred.alumni.service.impl.StudentServiceImpl;
import com.twohundred.alumni.util.Mapper;
import com.twohundred.alumni.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/faculties")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@PreAuthorize("hasAuthority('FACULTY')")
public class FacultyController {
    private final FacultyServiceImpl facultyServiceImpl;
    private final CommentServiceImpl commentService;
    private final StudentServiceImpl studentService;
    private final SecurityUtil securityUtil;

    private final Mapper mapper;

    @LogMe
    @PutMapping
    public FacultyDto update(@RequestBody FacultyDto facultyDto) {
        User currentStudent = securityUtil.getCurrentUser();
        facultyDto.setId(currentStudent.getId());
        return facultyServiceImpl.update(facultyDto);
    }

    @LogMe
    @DeleteMapping
    public FacultyDto delete() {
        User currentFaculty = securityUtil.getCurrentUser();
        return facultyServiceImpl.delete(currentFaculty);
    }

    @GetMapping("/filter/students")
    public ResponseEntity<?> filterStudentsByParam(@RequestParam(value = "state", required = false) String state, @RequestParam(value = "city", required = false) String city, @RequestParam(value = "major", required = false) String major, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "id", required = false) String id) {
        List<StudentDto> result = new ArrayList<>();
        try {
            result.addAll(facultyServiceImpl.filterStudentsBySearchParam(state, city, major, name, id).stream().map(mapper::mapStudentToDTO).toList());
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping("/student/comment")
    public ResponseEntity<?> addCommentToStudent(@RequestBody CommentDto commentDto) {
        User currentFaculty, student;
        try {
            currentFaculty = securityUtil.getCurrentUser();
            student = studentService.findById(commentDto.getStudentId());
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        Comment comment = new Comment();
        comment.setComment(commentDto.getComment());
        comment.setFaculty(currentFaculty);
        comment.setStudent(student);
        comment.setCommentedAt(new Date());
        Comment result;
        try {
            result = commentService.create(comment);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }

        return ResponseEntity.ok(result);
    }

//    @GetMapping("/student/comments")
//    public ResponseEntity<?> getAllComments() {
////        User currentFaculty;
////        try {
////            currentFaculty = securityUtil.getCurrentUser();
////        } catch (Exception e) {
////            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
////        }
//        return ResponseEntity.ok(commentService.findAll());
//    }

    @GetMapping("/student/comments")
    public ResponseEntity<?> getCommentsByStudentId(@RequestParam long id) {
        List<Comment> result = new ArrayList<>();
        try {
            result.addAll(commentService.getCommentByStudentId(id));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }


}
