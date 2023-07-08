package com.twohundred.alumni.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.twohundred.alumni.entity.Student;
import com.twohundred.alumni.repository.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.twohundred.alumni.entity.Faculty;
import com.twohundred.alumni.entity.dto.request.FacultyDto;
import com.twohundred.alumni.repository.FacultyRepo;
import com.twohundred.alumni.service.FacultyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepo facultyRepo;
    private final ModelMapper modelMapper;
    private final StudentRepo studentRepo;

    @Override
    public FacultyDto delete(Faculty faculty) {
        Faculty tempFaculty = findById(faculty.getId());
        tempFaculty.getUser().setDeleted(true);
        Faculty newFaculty = facultyRepo.save(tempFaculty);
        return modelMapper.map(newFaculty, FacultyDto.class);
    }

    @Override
    public Faculty findById(Long id) {
        Optional<Faculty> optionalFaculty = facultyRepo.findById(id);

        if (!optionalFaculty.isPresent()) {
            // TODO: throw exception
        }

        return optionalFaculty.get();
    }

    @Override
    public FacultyDto update(Faculty currentFaculty, FacultyDto facultyDto) {
        Faculty tempFaculty = findById(currentFaculty.getId());
        tempFaculty.setSalary(facultyDto.getSalary());
        tempFaculty.setTitle(facultyDto.getTitle());

        tempFaculty.getUser().setFirstName(facultyDto.getUser().getFirstName());
        tempFaculty.getUser().setLastName(facultyDto.getUser().getLastName());
        tempFaculty.getUser().setEmail(facultyDto.getUser().getEmail());

        tempFaculty.getUser().getAddress().setCity(facultyDto.getUser().getAddress().getCity());
        tempFaculty.getUser().getAddress().setState(facultyDto.getUser().getAddress().getState());
        tempFaculty.getUser().getAddress().setStreet(facultyDto.getUser().getAddress().getStreet());
        tempFaculty.getUser().getAddress().setZip(facultyDto.getUser().getAddress().getZip());

        Faculty faculty = facultyRepo.save(tempFaculty);
        return modelMapper.map(faculty, FacultyDto.class);
    }

    @Override
    public List<Student> filterStudentsBySearchParam(String state, String city, String major, String name, String id) {
        if (isNotEmpty(state)) return studentRepo.findAllByStateLike(state);
        else if (isNotEmpty(city)) return studentRepo.findAllByCityLike(city);
        else if (isNotEmpty(major)) return studentRepo.findAllByMajorLike(major);
        else if (isNotEmpty(id))
            return Collections.singletonList(studentRepo.findById(Long.parseLong(id)).orElse(null));
        else if (isNotEmpty(name)) return studentRepo.findAllByFirstNameOrLastNameLike(name, name);
        else return studentRepo.findAll();
    }

    private boolean isNotEmpty(@Nullable Object str) {
        return str != null && !"".equals(str);
    }

}
