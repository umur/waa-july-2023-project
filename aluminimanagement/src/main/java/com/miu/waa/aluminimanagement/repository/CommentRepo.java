package com.miu.waa.aluminimanagement.repository;

import com.miu.waa.aluminimanagement.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
    List<Comment> findCommentByStudent_Id(int id);
}
