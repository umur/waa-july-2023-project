package com.example.alumni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.alumni.entity.JobAdv;
import com.example.alumni.repository.JobAdvRepository;

import org.springframework.data.util.Pair;

@Service
@Transactional
public class JobAdvService {

    @Autowired
    private JobAdvRepository jobAdvRepository;

    public Iterable<JobAdv> getAllJobAdvs() {
        return jobAdvRepository.findAll();
    }

    public JobAdv getJobAdvById(long id) {
        return jobAdvRepository.findById(id).orElse(null);
    }

    public JobAdv createJobAdv(JobAdv jobAdv) {
        return jobAdvRepository.save(jobAdv);
    }

    public Pair<Boolean, JobAdv> updateJobAdv(JobAdv jobAdv) {
        boolean exists = jobAdvRepository.existsById(jobAdv.getId());
        jobAdvRepository.save(jobAdv);
        return Pair.of(exists, jobAdv);
    }

    public boolean deleteJobAdv(long id) {
        JobAdv existingJobAdv = jobAdvRepository.findById(id).orElse(null);
        if (existingJobAdv != null) {
            jobAdvRepository.delete(existingJobAdv);
            return true;
        }
        return false;
    }
}
