package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.Comment;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends ListCrudRepository<Comment,Long> {
}
