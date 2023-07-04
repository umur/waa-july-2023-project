package com.example.alumni.service;

import com.example.alumni.entity.JobAdvertisement;
import org.springframework.data.util.Pair;

import java.util.List;

public interface JobJobAdvertisementService {
    Iterable<JobAdvertisement> getAllJobAdvs();

//    Iterable<JobAdvertisement> getAll(boolean isDeleted);

    JobAdvertisement getJobAdvById(long id);

    Iterable<JobAdvertisement> getJobAdvByTags(List<String> tags);

    JobAdvertisement createJobAdv(JobAdvertisement jobAdvertisement);

    Pair<Boolean, JobAdvertisement> updateJobAdv(JobAdvertisement jobAdvertisement);

    boolean deleteJobAdv(long id);
}
