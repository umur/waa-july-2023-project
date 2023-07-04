package com.example.geeks.repos;

import com.example.geeks.entity.Comment;
import com.example.geeks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, List<Comment>> {

    public List<Comment> getCommentsByCommentGiver_Id(Long u);



    public List<Comment> getCommentsByCommentReceiver_Id(Long u);


    public List<Comment> getCommentsByCommentGiver_IdAndCommentReceiver_Id(Long staffId, Long studentId);
}
