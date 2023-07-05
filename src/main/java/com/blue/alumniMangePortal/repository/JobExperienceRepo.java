package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobExperienceRepo extends JpaRepository<JobExperience,Long> {

}
