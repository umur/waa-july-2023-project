package com.alumni.repository;

import com.alumni.entity.Comment;
import com.alumni.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {


    List<Comment> findAllByStudentId(Long id);
}
