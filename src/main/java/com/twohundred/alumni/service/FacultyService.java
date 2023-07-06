package com.twohundred.alumni.service;

import com.twohundred.alumni.entity.Faculty;
import com.twohundred.alumni.entity.dto.request.FacultyDto;

public interface FacultyService {
    Faculty findById(Long id);
    FacultyDto update(Faculty faculty, FacultyDto facultyDto);

    FacultyDto delete(Faculty faculty);
}
