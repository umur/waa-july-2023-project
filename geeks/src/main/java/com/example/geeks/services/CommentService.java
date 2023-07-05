package com.example.geeks.services;

import com.example.geeks.entity.Comment;
import com.example.geeks.entity.Advertisement;
import com.example.geeks.entity.User;
import com.example.geeks.repos.CommentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Qualifier("cos")
@Component
@Transactional
public class CommentService {
    private final CommentRepo coRepo;


    public Comment addComment(Comment c){
        return coRepo.save(c);
    }
    public List<Comment> getCommentsOn(Long uId){
        return coRepo.getCommentsByCommentReceiver_IdAndIsDeleted(uId, false);
    }

    public List<Comment> getCommentsBy(Long uId){
        return coRepo.getCommentsByCommentGiver_IdAndIsDeleted(uId, false);
    }

    public List<Comment> getCommentsByOn(Long staffId, Long studentId){
        return coRepo.getCommentsByCommentGiver_IdAndCommentReceiver_IdAndIsDeleted(staffId, studentId, false);
    }

    public void deleteComment(Long id, Long id2){
        coRepo.updateCommentByIdIs(id, id2);
    }
}
