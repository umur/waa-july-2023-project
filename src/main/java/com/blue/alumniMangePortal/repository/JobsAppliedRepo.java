package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.JobsApplied;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsAppliedRepo extends JpaRepository<JobsApplied, Long> {

}
