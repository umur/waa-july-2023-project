package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.JobsAdvertise;
import com.blue.alumniMangePortal.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorRepo extends JpaRepository<Major,Long> {
    @Query("SELECT m FROM Major m WHERE m.isDeleted = false")
    List<Major> getAll();
}
