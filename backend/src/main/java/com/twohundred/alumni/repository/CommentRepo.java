package com.twohundred.alumni.repository;

import com.twohundred.alumni.entity.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends ListCrudRepository<Comment, Long> {
    @Query(value = "SELECT * FROM comment WHERE student_id = :id",
            nativeQuery = true)
    List<Comment> getCommentsByStudentId(@Param("id") Long id);
}
