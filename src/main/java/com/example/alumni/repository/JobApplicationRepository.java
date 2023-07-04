package com.example.alumni.repository;

import com.example.alumni.entity.JobApplication;
import com.example.alumni.entity.JobApplicationId;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends ListCrudRepository<JobApplication, JobApplicationId> {

}
