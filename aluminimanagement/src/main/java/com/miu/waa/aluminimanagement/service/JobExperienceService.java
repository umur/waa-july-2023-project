package com.miu.waa.aluminimanagement.service;

import com.miu.waa.aluminimanagement.model.JobExperience;
import com.miu.waa.aluminimanagement.model.dto.JobApplicationDto;
import com.miu.waa.aluminimanagement.model.dto.JobExperienceDto;

import java.util.List;

public interface JobExperienceService {
    List<JobExperienceDto> findAll();
    JobExperienceDto findById(int id);

    JobExperienceDto save(JobExperience jobExperience);

    JobExperienceDto update(int id, JobExperienceDto JobExperienceDto);

    List<JobExperienceDto> findByStudentId(int userId);

    void delete(int id);
}
