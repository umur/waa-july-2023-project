package com.example.geeks.repos;

import com.example.geeks.entity.JobAd;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface JobAdRepo extends ListCrudRepository<JobAd, List<JobAd>> {


    public JobAd getJobAdByIdIs(Long id);

    public List<JobAd> getJobAdsByTagIs(String tag);

    public List<JobAd> getJobAdsByStateIs(String state);

    public List<JobAd> getJobAdsByCityIs(String city);

    public List<JobAd> getJobAdsByCompanyNameIs(String companyName);
}
