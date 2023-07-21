package com.twohundred.alumni.service;

import com.twohundred.alumni.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment create(Comment review);

    List<Comment> findAll();

    void update(Comment review);

    Comment getComment(Long id);

    List<Comment> getCommentByStudentId(Long id);

    void delete(Comment review);
}
