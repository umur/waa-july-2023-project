package com.miu.waa.aluminimanagement.repository;

import com.miu.waa.aluminimanagement.model.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobExperienceRepo extends JpaRepository<JobExperience,Integer> {
    List<JobExperience> findByStudentId(int id);
}
