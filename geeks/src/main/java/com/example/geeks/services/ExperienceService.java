package com.example.geeks.services;


import com.example.geeks.entity.Experience;
import com.example.geeks.repos.ExperienceRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Qualifier("exs")
@Component
@Transactional
public class ExperienceService {

    private final ExperienceRepo jeRepo;


    public Experience addExperience(Experience je){
        return jeRepo.save(je);
    }

    public List<Experience> getAllExperiences(){
        return jeRepo.findAll();
    }

    public List<Experience> getExperiencesByUser(Long id){
        return jeRepo.getExperiencesByUser_IdAndIsDeleted(id, false);
    }

    public List<Experience> getExperiencesByCompanyName(String cName){
        return jeRepo.getExperiencesByCompanyNameAndIsDeleted(cName, false);
    }

    public Experience getExperienceById(Long id){
        return jeRepo.getExperienceById(id);
    }

    public void deleteExperience(Long id, String cName){
        jeRepo.deleteExperience(id, cName) ;
    }
}
