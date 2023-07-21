package com.miu.waa.aluminimanagement.controller;

<<<<<<< HEAD

import com.miu.waa.aluminimanagement.service.CommentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentServiceImpl commentService;

//    @GetMapping("/{id})
//            public List<Comment> findCommentsByStudent(@PathVariable Long id) {
//        return commentService.findCommentsByStudent(id);
//    }
=======
import com.miu.waa.aluminimanagement.model.dto.CommentDto;
import com.miu.waa.aluminimanagement.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public List<CommentDto> getAllComments(){
        var x = commentService.findAll();
        return x;
    }

    @GetMapping("/students/{studentId}")
    List<CommentDto> findCommentByStudent_Id(@PathVariable int studentId){
        return commentService.findCommentByStudent_Id(studentId);
    }
    @GetMapping("/{id}")
    public CommentDto getComment(@PathVariable int id){
        return commentService.findById(id);
    }
    @PostMapping
    public CommentDto addComment(@RequestBody CommentDto comment){
        return commentService.addComment(comment);
    }

    @PutMapping("/{id}")
    public CommentDto updateComment(@PathVariable int id, @RequestBody CommentDto comment){
        return commentService.updateComment(id,comment);
    }
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable int id){
        commentService.deleteComment(id);
    }

>>>>>>> d04e8fcb214aa5015d586690d5daf5c64c82438d
}
