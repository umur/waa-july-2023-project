package com.miu.waa.aluminimanagement.repository;

import com.miu.waa.aluminimanagement.model.JobApplication;
import com.miu.waa.aluminimanagement.model.JobApplicationId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobApplicationRepo extends JpaRepository<JobApplication, JobApplicationId> {
    Page<JobApplication> findAll(Pageable pageable);
    List<JobApplication> findByStudent_Id(int id);
}
