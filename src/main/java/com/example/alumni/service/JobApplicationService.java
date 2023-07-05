package com.example.alumni.service;

import com.example.alumni.entity.JobApplication;
import com.example.alumni.entity.JobApplicationId;

import java.util.List;

public interface JobApplicationService extends BaseService<JobApplication, JobApplicationId> {
    boolean deleteByJobId(Long id) throws IllegalAccessException;

    JobApplication getByJobId(Long jobId);

    JobApplication getByJobId(Long jobId, Long userId);

    List<JobApplication> getAllApplicantsForMyJobs();
}
