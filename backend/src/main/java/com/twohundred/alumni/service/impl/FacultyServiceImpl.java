package com.twohundred.alumni.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.twohundred.alumni.entity.Address;
import com.twohundred.alumni.entity.Faculty;
import com.twohundred.alumni.entity.Student;
import com.twohundred.alumni.entity.User;
import com.twohundred.alumni.entity.dto.request.FacultyDto;
import com.twohundred.alumni.exception.Exceptions;
import com.twohundred.alumni.repository.FacultyRepo;
import com.twohundred.alumni.repository.StudentRepo;
import com.twohundred.alumni.service.FacultyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepo facultyRepo;
    private final ModelMapper modelMapper;
    private final StudentRepo studentRepo;

    @Override
    public FacultyDto delete(User faculty) {
        Faculty tempFaculty = findById(faculty.getId());
        tempFaculty.setDeleted(true);
        Faculty newFaculty = facultyRepo.save(tempFaculty);
        return modelMapper.map(newFaculty, FacultyDto.class);
    }

    @Override
    public Faculty findById(Long id) {
        Optional<Faculty> optionalFaculty = facultyRepo.findById(id);

        if (!optionalFaculty.isPresent()) {
            throw Exceptions.FACULTY_NOT_FOUND;
        }

        return optionalFaculty.get();
    }

    @Override
    public FacultyDto update(FacultyDto facultyDto) {
        Faculty tempFaculty = findById(facultyDto.getId());
        tempFaculty.setSalary(facultyDto.getSalary());
        tempFaculty.setTitle(facultyDto.getTitle());

        tempFaculty.setFirstName(facultyDto.getFirstName());
        tempFaculty.setLastName(facultyDto.getLastName());

        if (tempFaculty.getAddress() == null) {
            tempFaculty.setAddress(new Address());
        }

        tempFaculty.getAddress().setCity(facultyDto.getAddress().getCity());
        tempFaculty.getAddress().setState(facultyDto.getAddress().getState());
        tempFaculty.getAddress().setStreet(facultyDto.getAddress().getStreet());
        tempFaculty.getAddress().setZip(facultyDto.getAddress().getZip());

        Faculty faculty = facultyRepo.save(tempFaculty);
        return modelMapper.map(faculty, FacultyDto.class);
    }

    @Override
    public List<Student> filterStudentsBySearchParam(String state, String city, String major, String name, String id) {
        if (isNotEmpty(state))
            return studentRepo.findAllByStateLike(state);
        else if (isNotEmpty(city))
            return studentRepo.findAllByCityLike(city);
        else if (isNotEmpty(major))
            return studentRepo.findAllByMajorContainingIgnoreCase(major);
        else if (isNotEmpty(id))
            return Collections.singletonList(studentRepo.findById(Long.parseLong(id)).orElse(null));
        else if (isNotEmpty(name))
            return studentRepo.findAllByFirstNameOrLastNameLike(name);
        else
            return studentRepo.findAll();
    }

    private boolean isNotEmpty(@Nullable Object str) {
        return str != null && !"".equals(str);
    }

}
