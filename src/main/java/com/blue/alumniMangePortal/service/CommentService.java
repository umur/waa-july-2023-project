package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommentService {
    void addComment(Comment comment);
    List<Comment> getComments();
    Comment getComment(Long id);
    void updateComment(Long id, Comment comment);
    void deleteComment(Long id);
}
