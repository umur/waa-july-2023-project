package com.example.geeks.controller;

import com.example.geeks.entity.Comment;
import com.example.geeks.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Qualifier("cos")
    @Autowired
    CommentService commentService;

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        Comment savedComment = commentService.addComment(comment);
        return savedComment;
    }

    @GetMapping("/receiver/{userId}")
    public List<Comment> getCommentsOnUser(@PathVariable Long userId) {
        // Assuming "userId" refers to the receiver user's ID
        List<Comment> comments = commentService.getCommentsOn(userId);
        return comments;
    }

    @GetMapping("/giver/{userId}")
    public List<Comment> getCommentsByUser(@PathVariable Long userId) {
        // Assuming "userId" refers to the giver user's ID
        List<Comment> comments = commentService.getCommentsBy(userId);
        return comments;
    }
}
