package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty,Long> {
    @Query("SELECT f FROM Faculty f WHERE f.is_deleted = false")
    List<Faculty> findAll();
    @Query("SELECT f from Faculty f where f.is_deleted=false")
    Optional<Faculty> findById(Long id);
}
