package com.alumni.repository;

import com.alumni.entity.JobAdvertisement;
import com.alumni.entity.JobApplication;
import com.alumni.entity.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findAllByJobAdvertisementId(Long jobId);
}
