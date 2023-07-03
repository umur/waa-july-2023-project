package com.example.geeks.services;

import com.example.geeks.entity.Application;
import com.example.geeks.repos.ApplicationRepo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor

public class ApplicationService {


    private final ApplicationRepo apRepo;


    public Application addApplication(Application a){
        return apRepo.save(a);
    }
    public List<Application> getAllApplications(){
        return apRepo.findAll();
    }

    public List<Application> getApplicationsOfStudent(Long id){
        return apRepo.getApplicationsByStudent_Id(id);
    }

    public Application getApplicationById(Long id){
        return apRepo.getApplicationByAppIdIs(id);
    }


}
