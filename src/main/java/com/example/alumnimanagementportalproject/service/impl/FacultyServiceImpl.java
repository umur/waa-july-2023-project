package com.example.alumnimanagementportalproject.service.impl;


import com.example.alumnimanagementportalproject.entity.*;
import com.example.alumnimanagementportalproject.repository.CommentRepository;
import com.example.alumnimanagementportalproject.repository.FacultyRepository;
import com.example.alumnimanagementportalproject.repository.JobAdvertisementRepository;
import com.example.alumnimanagementportalproject.repository.PasswordResetTokenRepository;
import com.example.alumnimanagementportalproject.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service

public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private JobAdvertisementRepository jobAdvertisementRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

   @Override
    public JobAdvertisement findJobByTag(String tag) {
        return jobAdvertisementRepository.findJobByTags(tag);
    }

   @Override
    public JobAdvertisement findJobByLocationState(String state) {
        return jobAdvertisementRepository.findJobByLocation_State(state);
    }

    @Override

    public JobAdvertisement findJobByCity(String city) {
        return jobAdvertisementRepository.findJobByLocation_City(city);
    }


    public JobAdvertisement findJobByCompany(String company) {
        return jobAdvertisementRepository.findJobByCompanyName(company);
    }


    @Override
    public Student findStudentByState(String state) {
        return facultyRepository.findStudentByState(state);
    }

    @Override
    public Student findStudentByCity(String city) {
        return facultyRepository.findStudentByCity(city);
    }

    @Override
    public Student findStudentByMajor(String major) {
        return facultyRepository.findStudentByMajor(major);
    }

    @Override
    public Student findStudentById(Long id) {
        return facultyRepository.findStudentById(id);
    }

    @Override
    public Student findStudentByName(String name) {
        return facultyRepository.findStudentByName(name);
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public PasswordResetToken resetPassword(PasswordResetToken passwordResetToken) {
        return passwordResetTokenRepository.save(passwordResetToken);
    }
}
