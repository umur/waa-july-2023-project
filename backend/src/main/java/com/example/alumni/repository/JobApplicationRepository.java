package com.example.alumni.repository;

import com.example.alumni.entity.JobApplication;
import com.example.alumni.entity.JobApplicationId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobApplicationRepository extends ListCrudRepository<JobApplication, JobApplicationId> {

    @Query("select j from JobApplication j " +
            " join j.jobAdvertisement ja " +
            " join j.user u " +
            " where ja.id=:jobAdvertisementId and u.id=:userId")
    Optional<JobApplication> findByJobAdvertisementIdAndUserId(Long jobAdvertisementId, Long userId);
    List<JobApplication> findAllByJobAdvertisement_User_Id(Long userId);

}
