package com.example.geeks.services;


import com.example.geeks.entity.Experience;
import com.example.geeks.entity.User;
import com.example.geeks.repos.ExperienceRepo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor

public class ExperienceService {

    private final ExperienceRepo jeRepo;


    public Experience addExperience(Experience je){
        return jeRepo.save(je);
    }

    public List<Experience> getAllExperiences(){
        return jeRepo.findAll();
    }

    public List<Experience> getExperiencesByUser(User u){
        return jeRepo.getExperiencesByUserIs(u);
    }

    public List<Experience> getExperiencesByCompanyName(String cName){
        return jeRepo.getExperiencesByCompanyName(cName);
    }

    public Experience getExperienceByIdIs(Long id){
        return jeRepo.getExperienceByIdIs(id);
    }
}
