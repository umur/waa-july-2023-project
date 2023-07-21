package com.example.alumnimanagementportalproject.service.impl;

import com.example.alumnimanagementportalproject.entity.JobAdvertisement;
import com.example.alumnimanagementportalproject.entity.JobExperience;
import com.example.alumnimanagementportalproject.entity.PasswordResetToken;
import com.example.alumnimanagementportalproject.entity.Student;
import com.example.alumnimanagementportalproject.repository.JobAdvertisementRepository;
import com.example.alumnimanagementportalproject.repository.JobExperienceRepository;
import com.example.alumnimanagementportalproject.repository.PasswordResetTokenRepository;
import com.example.alumnimanagementportalproject.repository.StudentRepository;
import com.example.alumnimanagementportalproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class StudentServiceImpl  implements StudentService {

    @Autowired
   private JobAdvertisementRepository jobAdvertisementRepository;
    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private JobExperienceRepository jobExperienceRepository;

    @Override
    public JobAdvertisement findJobByTag(String tag) {
        return jobAdvertisementRepository.findJobByTags(tag);
    }

    @Override
    public JobAdvertisement findJobByState(String state) {
        return jobAdvertisementRepository.findJobByLocation_State(state);
    }

    @Override
    public JobAdvertisement findJobByCity(String city) {
        return jobAdvertisementRepository.findJobByLocation_City(city);
    }

    @Override
    public JobAdvertisement findJobByCompany(String company) {
        return jobAdvertisementRepository.findJobByCompanyName(company);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public JobAdvertisement applyJob(JobAdvertisement jobAdvertisement) {
        return jobAdvertisementRepository.save(jobAdvertisement);
    }

    @Override
    public JobAdvertisement saveJob(JobAdvertisement jobAdvertisement) {
        return jobAdvertisementRepository.save(jobAdvertisement);
    }

    @Override
    public JobAdvertisement updateJob(JobAdvertisement jobAdvertisement) {
        return jobAdvertisementRepository.save(jobAdvertisement);
    }

    @Override
    public JobExperience saveJobExperience(JobExperience jobExperience) {
        return jobExperienceRepository.save(jobExperience);
    }

    @Override
    public PasswordResetToken resetPassword(PasswordResetToken passwordResetToken) {
        return passwordResetTokenRepository.save(passwordResetToken);
    }
}
