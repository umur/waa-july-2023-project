package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.auth.RegisterRequest;
import com.blue.alumniMangePortal.entity.Faculty;

import java.util.List;
import java.util.Optional;

public interface FacultyService {
//    void addFaculty(Faculty faculty);

    void addFaculty(RegisterRequest faculty);

    List<Faculty> getFaculties();
    Faculty getFaculty(Long id);
    Faculty getFacultyByEmail(String email);
    void updateFaculty(Long id, Faculty faculty);
    void deleteFaculty(Long id);
}
