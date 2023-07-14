package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvRepo extends JpaRepository<Cv,Long> {
}
