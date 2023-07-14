package com.twohundred.alumni.repository;

import com.twohundred.alumni.entity.Comment;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends ListCrudRepository<Comment, Long> {

}
