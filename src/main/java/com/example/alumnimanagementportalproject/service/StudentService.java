package com.example.alumnimanagementportalproject.service;


import com.example.alumnimanagementportalproject.entity.JobAdvertisement;
import com.example.alumnimanagementportalproject.entity.JobExperience;
import com.example.alumnimanagementportalproject.entity.PasswordResetToken;
import com.example.alumnimanagementportalproject.entity.Student;

public interface StudentService {

    JobAdvertisement findJobByTag(String tag);
    JobAdvertisement findJobByState(String state);
    JobAdvertisement findJobByCity(String city);
    JobAdvertisement findJobByCompany(String company);

    Student updateStudent(Student student);
    JobAdvertisement applyJob(JobAdvertisement jobAdvertisement);
    JobAdvertisement saveJob(JobAdvertisement jobAdvertisement);
    JobAdvertisement updateJob(JobAdvertisement jobAdvertisement);
    JobExperience saveJobExperience(JobExperience jobExperience);
    PasswordResetToken resetPassword(PasswordResetToken passwordResetToken);
}