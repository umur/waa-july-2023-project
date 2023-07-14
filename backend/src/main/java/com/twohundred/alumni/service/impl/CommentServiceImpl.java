package com.twohundred.alumni.service.impl;

import com.twohundred.alumni.entity.Comment;
import com.twohundred.alumni.repository.CommentRepo;
import com.twohundred.alumni.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {


    private final CommentRepo commentRepo;

    public Comment create(Comment comment) {
       return commentRepo.save(comment);
    }

    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    @Override
    public void update(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public Comment getComment(Long id) {
        return commentRepo.findById(id).orElseGet(null);
    }

    @Override
    public void delete(Comment comment) {
        commentRepo.delete(comment);
    }
}
