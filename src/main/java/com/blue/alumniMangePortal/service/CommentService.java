package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Comment;

import java.util.List;

public interface CommentService {
    void addComment(Comment comment);
    List<Comment> getComments();
    Comment getComment(Long id);
    void updateComment(Long id, Comment comment);
    void deleteComment(Long id);
}
