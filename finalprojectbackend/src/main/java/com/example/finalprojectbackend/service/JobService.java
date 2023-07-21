package com.example.finalprojectbackend.service;

import com.example.finalprojectbackend.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();
    void delete(Integer id);

}
