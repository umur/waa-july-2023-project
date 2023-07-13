package com.example.alumni.repository;

import com.example.alumni.entity.StudentComment;
import org.springframework.data.repository.ListCrudRepository;

public interface StudentCommentRepository extends ListCrudRepository<StudentComment, Long> {
}
