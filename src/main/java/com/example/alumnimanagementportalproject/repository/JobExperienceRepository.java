package com.example.alumnimanagementportalproject.repository;


import com.example.alumnimanagementportalproject.entity.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface JobExperienceRepository extends JpaRepository<JobExperience, Long> {

}