package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.Faculty;
import com.blue.alumniMangePortal.entity.JobsAdvertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsAdvertiseRepo extends JpaRepository<JobsAdvertise, Long> {
    @Query("SELECT j FROM JobsAdvertise j WHERE j.isDeleted = false")
    List<JobsAdvertise> getAll();
  @Query("SELECT j FROM JobsAdvertise j ORDER BY j.id LIMIT 10")
      List<JobsAdvertise> findFirst10ByOrderByCreatedAtDesc();
  @Query("SELECT j FROM JobsAdvertise j ORDER BY j.jobAppliedDate DESC LIMIT 10")
    List<JobsAdvertise> findTop10ByOrderByAppliedAtDesc();


}
