package com.example.geeks.services;


import com.example.geeks.entity.JobAd;
import com.example.geeks.repos.JobAdRepo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class JobAdService {

    private final JobAdRepo jaRepo;

    public JobAd addJobAd(JobAd ja){
        return jaRepo.save(ja);
    }

    public List<JobAd> getAllJobAds(){
        return jaRepo.findAll();
    }
    public JobAd getJobAdById(Long id){
        return jaRepo.getJobAdByIdIs(id);
    }

    public List<JobAd> getJobAdsByCity(String city){
        return jaRepo.getJobAdsByCityIs(city);
    }

    public List<JobAd> getJobAdsByState(String state){
        return jaRepo.getJobAdsByStateIs(state);
    }

    public List<JobAd> getJobAdsByTag(String tag){
        return jaRepo.getJobAdsByTagIs(tag);
    }

    public List<JobAd> getJobAdsByCompanyName(String cName){
        return jaRepo.getJobAdsByCompanyNameIs(cName);
    }

}
