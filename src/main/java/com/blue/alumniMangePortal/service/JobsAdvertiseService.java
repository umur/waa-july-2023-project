package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Cv;
import com.blue.alumniMangePortal.entity.JobsAdvertise;

import java.util.List;

public interface JobsAdvertiseService {
    String getAll();
    String getJobsAdvertiseById(Long id);
    JobsAdvertise saveJobsAdvertise(JobsAdvertise jobsAdvertise);
    JobsAdvertise updateJobsAdvertise(long id,JobsAdvertise jobsAdvertise);
    boolean DeleteJobsAdvertiseById(Long id);
    //List<JobsAdvertise> getFirstTenJobAppliedAdverts();
}
