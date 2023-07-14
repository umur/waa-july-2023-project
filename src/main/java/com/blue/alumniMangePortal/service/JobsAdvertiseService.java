package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Cv;
import com.blue.alumniMangePortal.entity.JobsAdvertise;

import java.util.List;

public interface JobsAdvertiseService {
    List<JobsAdvertise> getAll();
    JobsAdvertise getJobsAdvertiseById(Long id);
    JobsAdvertise saveJobsAdvertise(JobsAdvertise jobsAdvertise);
    JobsAdvertise updateJobsAdvertise(long id,JobsAdvertise jobsAdvertise);

    void findByDeletedTrue(Long id);

    List<JobsAdvertise> findTop10ByOrderByCreatedAtDesc();

   List<JobsAdvertise> findTop10ByOrderByAppliedAtDesc();
}
