package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.Faculty;
import com.blue.alumniMangePortal.entity.JobsAdvertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsAdvertiseRepo extends JpaRepository<JobsAdvertise, Long> {
    @Query("SELECT job FROM JobsAdvertise job WHERE job.isDeleted = false")
    List<JobsAdvertise> getAll();
  @Query("SELECT job FROM JobsAdvertise job ORDER BY job.id LIMIT 10")
      List<JobsAdvertise> findFirst10ByOrderByCreatedAtDesc();
  @Query("SELECT job FROM JobsAdvertise job ORDER BY job.jobAppliedDate DESC LIMIT 10")
    List<JobsAdvertise> findTop10ByOrderByAppliedAtDesc();
//    List<JobsAdvertise> findByTagValue(String tag);
    @Query("SELECT job FROM JobsAdvertise job WHERE job.tag = ?1")
    List<JobsAdvertise> findByTagValue(String tag);


}
