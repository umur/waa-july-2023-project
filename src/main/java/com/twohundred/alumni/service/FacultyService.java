package com.twohundred.alumni.service;

import com.twohundred.alumni.entity.Faculty;
import com.twohundred.alumni.entity.Student;
import com.twohundred.alumni.entity.dto.request.FacultyDto;

import java.util.List;

public interface FacultyService {
    Faculty findById(Long id);
    FacultyDto update(Faculty faculty, FacultyDto facultyDto);

    FacultyDto delete(Faculty faculty);
    List<Student> filterStudentsBySearchParam(String state, String city, String major, String name, String id);
}
