package com.miu.waa.aluminimanagement.service;

import com.miu.waa.aluminimanagement.model.JobApplication;
import com.miu.waa.aluminimanagement.model.Tag;
import com.miu.waa.aluminimanagement.model.dto.JobApplicationDto;
import com.miu.waa.aluminimanagement.model.dto.JobCount;
import com.miu.waa.aluminimanagement.model.dto.JobDto;
import com.miu.waa.aluminimanagement.model.dto.JobSimpleDto;

import java.util.List;

public interface JobService {
    List<JobSimpleDto> findAll(String string, String value);
    List<JobSimpleDto> findMyJobs();
    JobDto addJob(JobDto job);
    JobDto updateJob(int id, JobDto job);
    void deleteJob(int id);
    JobDto findById(int id);
    List<JobSimpleDto> getLastTenJobs();
    List<JobApplication> getLastTenAppliedJobs();
    List<Tag> findTagsByTag(String filter);
    JobApplication applyJob(int jobId, int StudentId);
    List<JobApplicationDto> myJobApplications();
    String sendJobApplicationEmail(String recipent, String status);
    String sendJobApplicationNotificationEmail(String recipent, String status);
    List<JobCount> noOfJobsPerLocation();
}
