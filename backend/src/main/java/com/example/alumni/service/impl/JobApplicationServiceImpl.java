package com.example.alumni.service.impl;

import com.example.alumni.entity.JobApplication;
import com.example.alumni.entity.JobApplicationId;
import com.example.alumni.repository.JobApplicationRepository;
import com.example.alumni.service.JobApplicationService;
import com.example.alumni.util.CurrentUserUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    private final CurrentUserUtil currentUserUtil;

    @Override
    public Iterable<JobApplication> getAll() {

        return new ArrayList<>();
    }

    @Override
    public JobApplication getById(JobApplicationId jobApplicationId) {
        return jobApplicationRepository.findById(jobApplicationId).orElse(null);
    }
    @Override
    public JobApplication add(JobApplication jobApplication) throws IllegalAccessException {
        jobApplication.setUser(currentUserUtil.getUser().get());
        return jobApplicationRepository.save(jobApplication);
    }
    @Override
    public Pair<Boolean, JobApplication> update(JobApplication jobApplication) throws IllegalAccessException {
        return null;
    }
    @Override
    public boolean delete(JobApplicationId jobApplicationId) throws IllegalAccessException {
        JobApplication existingJobApplication = jobApplicationRepository.findById(jobApplicationId).orElse(null);
        if (existingJobApplication != null) {
            jobApplicationRepository.delete(existingJobApplication);
            return true;
        }
        return false;
    }
    @Override
    public boolean deleteByJobId(Long jobId) throws IllegalAccessException {
        JobApplication existingJob = jobApplicationRepository.findByJobAdvertisementIdAndUserId(jobId,
                currentUserUtil.getUserId().get()).orElse(null);
        if (existingJob != null) {
            jobApplicationRepository.delete(existingJob);
            return true;
        }
        return false;
    }

    @Override
    public JobApplication getByJobId(Long jobId) {
       return jobApplicationRepository.findByJobAdvertisementIdAndUserId(jobId,
                currentUserUtil.getUserId().get()).orElse(null);
    }

    @Override
    public JobApplication getByJobId(Long jobId, Long userId) {
        return jobApplicationRepository.findByJobAdvertisementIdAndUserId(jobId,
                userId).orElse(null);
    }

    @Override
    public List<JobApplication> getAllApplicantsForMyJobs() {
        return jobApplicationRepository.findAllByJobAdvertisement_User_Id(currentUserUtil.getUserId().get());
    }
}
