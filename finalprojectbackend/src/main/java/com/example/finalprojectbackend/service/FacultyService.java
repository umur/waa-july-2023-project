package com.example.finalprojectbackend.service;

import com.example.finalprojectbackend.entity.Faculty;

import java.util.List;

public interface FacultyService {
    List<Faculty> getAllFaculty();
    Faculty updateFaculty(Faculty faculty);
}
