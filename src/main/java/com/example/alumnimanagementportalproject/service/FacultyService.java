package com.example.alumnimanagementportalproject.service;


import com.example.alumnimanagementportalproject.entity.*;

public interface FacultyService {
    JobAdvertisement findJobByTag(String tag);
    JobAdvertisement findJobByLocationState(String state);
    JobAdvertisement findJobByCity(String city);


    JobAdvertisement findJobByCompany(String company);

    Student findStudentByState(String state);
    Student findStudentByCity(String city);
    Student findStudentByMajor(String major);
    Student findStudentById(Long id);
    Student findStudentByName(String name);
  Faculty updateFaculty(Faculty faculty);
  Comment addComment(Comment comment);
  PasswordResetToken resetPassword(PasswordResetToken passwordResetToken);


}