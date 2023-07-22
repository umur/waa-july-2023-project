package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Comment;
import com.blue.alumniMangePortal.repository.CommentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepo commentRepo;

    @Override
    public void addComment(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public List<Comment> getComments() {
        return commentRepo.findAll();
    }

    @Override
    public Comment getComment(Long id) {
        Optional<Comment> commentOptional = commentRepo.findById(id);
        return commentOptional.orElseThrow();
    }

    @Override
    public void updateComment(Long id, Comment comment) {
        Comment commentToUpdate = getComment(id);
        commentToUpdate.setComment(comment.getComment());
        commentRepo.save(commentToUpdate);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepo.deleteById(id);
    }
}
