package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Faculty;

import java.util.List;

public interface FacultyService {
    void addFaculty(Faculty faculty);
    List<Faculty> getFaculties();
    Faculty getFaculty(Long id);
    void updateFaculty(Long id, Faculty faculty);
    void deleteFaculty(Long id);
}
