package com.example.alumni.service;

import com.example.alumni.entity.JobAdv;
import org.springframework.data.util.Pair;

import java.util.List;

public interface JobAdvService {
    Iterable<JobAdv> getAllJobAdvs();

    JobAdv getJobAdvById(long id);

    Iterable<JobAdv> getJobAdvByTags(List<String> tags);

    JobAdv createJobAdv(JobAdv jobAdv);

    Pair<Boolean, JobAdv> updateJobAdv(JobAdv jobAdv);

    boolean deleteJobAdv(long id);
}
