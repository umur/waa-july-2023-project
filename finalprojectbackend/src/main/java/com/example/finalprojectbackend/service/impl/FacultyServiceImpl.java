package com.example.finalprojectbackend.service.impl;

import com.example.finalprojectbackend.entity.Faculty;
import com.example.finalprojectbackend.repository.FacultyRepo;
import com.example.finalprojectbackend.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyRepo facultyRepo;
    @Override
    public Faculty updateFaculty(Faculty faculty) {
        Faculty existingFaculty = facultyRepo.findById(faculty.getId()).orElse(null);
            existingFaculty.setId(faculty.getId());
            existingFaculty.setName(faculty.getName());
            existingFaculty.setPhone(faculty.getPhone());
            existingFaculty.setEmail(faculty.getEmail());
            existingFaculty.setAddress(faculty.getAddress());


        return facultyRepo.save(existingFaculty);
    }
    @Override
    public List<Faculty> getAllFaculty() {
        return facultyRepo.findAll();
    }
}
