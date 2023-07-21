package com.miu.waa.aluminimanagement.service.impl;

import com.miu.waa.aluminimanagement.model.Faculty;
import com.miu.waa.aluminimanagement.repository.FacultyRepo;
import com.miu.waa.aluminimanagement.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepo facultyRepo;

    public Faculty save(Faculty faculty){
        return facultyRepo.save(faculty);
    }
}
