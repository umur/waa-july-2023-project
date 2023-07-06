package com.twohundred.alumni.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.twohundred.alumni.entity.Student;
import com.twohundred.alumni.entity.dto.request.StudentDto;
import com.twohundred.alumni.repository.StudentRepo;
import com.twohundred.alumni.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    @Override
    public StudentDto delete(Student student) {
        Student tempStudent = findById(student.getId());
        tempStudent.setDeleted(true);
        Student newStudent = studentRepo.save(tempStudent);
        return modelMapper.map(newStudent, StudentDto.class);
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> optionalStudent = studentRepo.findById(id);

        if (!optionalStudent.isPresent()) {
            // TODO: throw exception
        }

        return optionalStudent.get();
    }

    @Override
    public StudentDto update(Student currentStudent, StudentDto studentDto) {
        Student tempStudent = findById(currentStudent.getId());
        tempStudent.setGpa(studentDto.getGpa());
        tempStudent.setMajor(studentDto.getMajor());

        tempStudent.getUser().setFirstName(studentDto.getUser().getFirstName());
        tempStudent.getUser().setLastName(studentDto.getUser().getLastName());
        tempStudent.getUser().setEmail(studentDto.getUser().getEmail());

        tempStudent.getUser().getAddress().setCity(studentDto.getUser().getAddress().getCity());
        tempStudent.getUser().getAddress().setState(studentDto.getUser().getAddress().getState());
        tempStudent.getUser().getAddress().setStreet(studentDto.getUser().getAddress().getStreet());
        tempStudent.getUser().getAddress().setZip(studentDto.getUser().getAddress().getZip());

        Student student = studentRepo.save(tempStudent);
        return modelMapper.map(student, StudentDto.class);
    }

}
