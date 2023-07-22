package com.twohundred.alumni.service;

import com.twohundred.alumni.entity.Faculty;
import com.twohundred.alumni.entity.Student;
import com.twohundred.alumni.entity.User;
import com.twohundred.alumni.entity.dto.request.FacultyDto;

import java.util.List;

public interface FacultyService {
    Faculty findById(Long id);
    FacultyDto update(FacultyDto facultyDto);

    FacultyDto delete(User faculty);
    List<Student> filterStudentsBySearchParam(String state, String city, String major, String name, String id);
}
