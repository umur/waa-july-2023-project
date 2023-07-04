package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Cv;
import com.blue.alumniMangePortal.entity.JobsAdvertise;

import java.util.List;

public interface JobsAdvertiseService {
    public String getAll();
    public String getJobsAdvertiseById(Long id);
    public JobsAdvertise saveJobsAdvertise(JobsAdvertise jobsAdvertise);
    public JobsAdvertise updateJobsAdvertise(long id,JobsAdvertise jobsAdvertise);
    public boolean DeleteJobsAdvertiseById(Long id);
    public List<JobsAdvertise> findFirst10ByOrderByPostedDateAsc();
}
