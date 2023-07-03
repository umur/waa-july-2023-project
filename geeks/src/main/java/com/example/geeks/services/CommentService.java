package com.example.geeks.services;

import com.example.geeks.entity.Comment;
import com.example.geeks.entity.JobAd;
import com.example.geeks.entity.User;
import com.example.geeks.repos.CommentRepo;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CommentService {
    private final CommentRepo coRepo;


    public Comment addComment(Comment c){
        return coRepo.save(c);
    }
    public List<Comment> getCommentsOn(Long id){
        return coRepo.getCommentsByStudentId(id);
    }

    public List<Comment> getCommentsBy(Long id){
        return coRepo.getCommentsByCommenter_Id(id);
    }

    public List<Comment> getCommentsByOn(Long commenterId, User student){
        return coRepo.getCommentsByCommenter_IdAndStudentIs(commenterId, student);
    }
}
