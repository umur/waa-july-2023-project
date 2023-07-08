package com.alumni.repository;

import com.alumni.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Faculty,Long> {


}
