package com.example.finalprojectbackend.service.impl;

import com.example.finalprojectbackend.entity.Job;
import com.example.finalprojectbackend.repository.JobRepo;
import com.example.finalprojectbackend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepo jobRepo;
    @Override
    public List<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    @Override
    public void delete(Integer id) {
        jobRepo.deleteById(id);
    }

}
