package com.blue.alumniMangePortal.controller;

import com.blue.alumniMangePortal.entity.Comment;
import com.blue.alumniMangePortal.entity.Faculty;
import com.blue.alumniMangePortal.service.CommentService;
import com.blue.alumniMangePortal.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumniMangePortal/comments")
public class CommentController {
    @Autowired
    public CommentService commentService;
    @Autowired
    public FacultyService facultyService;

    @PostMapping("/{facultyId}")
    public void addComment(@PathVariable Long facultyId, @RequestBody Comment comment){
        Faculty faculty = facultyService.getFaculty(facultyId);
        comment.setFaculty(faculty);
        commentService.addComment(comment);
    }

    @GetMapping
    public List<Comment> getComments(){
        return commentService.getComments();
    }

    @GetMapping("/{id}")
    public Comment getComment(@PathVariable Long id){
        return commentService.getComment(id);
    }

    @PutMapping("/{id}/comment")
    public void updateComment(@PathVariable Long id, @RequestBody Comment comment){
        commentService.updateComment(id,comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
    }
}