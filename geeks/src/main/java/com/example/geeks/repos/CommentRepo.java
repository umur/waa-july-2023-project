package com.example.geeks.repos;

import com.example.geeks.entity.Comment;
import com.example.geeks.entity.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CommentRepo extends ListCrudRepository<Comment, List<Comment>> {

    public List<Comment> getCommentsByCommenter_Id(Long id);


    //TODO Check that
    public List<Comment> getCommentsByStudentId(Long id);


    public List<Comment> getCommentsByCommenter_IdAndStudentIs(Long id, User student);
}
