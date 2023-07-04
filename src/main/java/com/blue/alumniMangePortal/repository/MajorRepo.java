package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorRepo extends JpaRepository<Major,Long> {
}
