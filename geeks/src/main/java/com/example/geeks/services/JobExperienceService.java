package com.example.geeks.services;


import com.example.geeks.entity.JobExperience;
import com.example.geeks.entity.User;
import com.example.geeks.repos.JobExperienceRepo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class JobExperienceService {

    private final JobExperienceRepo jeRepo;


    public JobExperience addJobExperience(JobExperience je){
        return jeRepo.save(je);
    }

    public List<JobExperience> getAllExperiences(){
        return jeRepo.findAll();
    }

    public List<JobExperience> getJobExperiencesByUser(User u){
        return jeRepo.getJobExperiencesByUserIs(u);
    }

    public List<JobExperience> getJobExperiencesByCompanyName(String cName){
        return jeRepo.getJobExperiencesByCompanyName(cName);
    }

    public JobExperience getJobExperienceByIdIs(Long id){
        return jeRepo.getJobExperienceByIdIs(id);
    }
}
