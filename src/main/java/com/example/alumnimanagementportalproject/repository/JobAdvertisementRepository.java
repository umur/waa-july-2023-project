package com.example.alumnimanagementportalproject.repository;


import com.example.alumnimanagementportalproject.entity.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Long> {
    JobAdvertisement findJobByTags(String tag);
    JobAdvertisement findJobByLocation_State(String state);
    JobAdvertisement findJobByLocation_City(String city);
    JobAdvertisement findJobByCompanyName(String company);
}