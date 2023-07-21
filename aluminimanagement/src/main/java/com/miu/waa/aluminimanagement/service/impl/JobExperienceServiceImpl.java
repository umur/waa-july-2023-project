package com.miu.waa.aluminimanagement.service.impl;

import com.miu.waa.aluminimanagement.model.JobExperience;
import com.miu.waa.aluminimanagement.model.Student;
import com.miu.waa.aluminimanagement.model.dto.JobExperienceDto;
import com.miu.waa.aluminimanagement.repository.JobExperienceRepo;
import com.miu.waa.aluminimanagement.security.MyUserDetails;
import com.miu.waa.aluminimanagement.service.JobExperienceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class JobExperienceServiceImpl implements JobExperienceService {

    private final JobExperienceRepo jobExperienceRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<JobExperienceDto> findAll() {
        List<JobExperienceDto> jobExpereince= jobExperienceRepo.findAll().stream()
                .filter(j ->!j.isDeleted())
                .map(j ->modelMapper.map(j,JobExperienceDto.class))
                .toList();
        return jobExpereince;
    }

    @Override
    public JobExperienceDto findById(int id) {
        JobExperience jobExperience = jobExperienceRepo.findById(id).filter(j -> !j.isDeleted()).orElseThrow(() -> new RuntimeException("Job Experience Not found"));
        return modelMapper.map(jobExperience, JobExperienceDto.class);
    }

    @Override
    public JobExperienceDto save(JobExperience jobExperience) {
        System.out.println("hi.........");
        int studentId = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        Student student = new Student();
        student.setId(studentId);
        JobExperience jobExperience1 = modelMapper.map(jobExperience, JobExperience.class);
        jobExperience1.setStudent(student);
        try {
            jobExperienceRepo.save(jobExperience1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return modelMapper.map(jobExperience1, JobExperienceDto.class);
    }

    @Override
    public JobExperienceDto update(int id, JobExperienceDto jobExperienceDto) {
        jobExperienceRepo.findById(id).orElseThrow(()->new RuntimeException("Job Experience Not Found."));
        JobExperience jobExperience = modelMapper.map(jobExperienceDto,JobExperience.class);
        jobExperience.setId(id);
        jobExperienceRepo.save(jobExperience);
        return modelMapper.map(jobExperience,JobExperienceDto.class);
    }

    @Override
    public List<JobExperienceDto> findByStudentId(int userId) {
        return jobExperienceRepo.findByStudentId(userId)
                .stream()
                .filter(j->!j.isDeleted())
                .map(j->modelMapper.map(j,JobExperienceDto.class))
                .toList();
    }

    @Override
    public void delete(int id) {
        JobExperience jobExperience = jobExperienceRepo.findById(id).orElseThrow(()
                -> new RuntimeException("Job Experience Not Found"));
        jobExperience.setId(id);
        jobExperience.setDeleted(true);
        jobExperienceRepo.save(jobExperience);
    }
}
