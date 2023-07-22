package com.twohundred.alumni.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.twohundred.alumni.entity.Address;
import com.twohundred.alumni.entity.Student;
import com.twohundred.alumni.entity.User;
import com.twohundred.alumni.entity.dto.request.StudentDto;
import com.twohundred.alumni.exception.Exceptions;
import com.twohundred.alumni.repository.StudentRepo;
import com.twohundred.alumni.service.StudentService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    @Override
    public StudentDto delete(User student) {
        Student tempStudent = findById(student.getId());
        tempStudent.setDeleted(true);
        Student newStudent = studentRepo.save(tempStudent);
        return modelMapper.map(newStudent, StudentDto.class);
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> optionalStudent = studentRepo.findById(id);

        if (!optionalStudent.isPresent()) {
            throw Exceptions.STUDENT_NOT_FOUND;
        }

        return optionalStudent.get();
    }

    @Override
    public StudentDto update(StudentDto studentDto) {
        Student tempStudent = findById(studentDto.getId());
        tempStudent.setGpa(studentDto.getGpa());
        tempStudent.setMajor(studentDto.getMajor());

        tempStudent.setFirstName(studentDto.getFirstName());
        tempStudent.setLastName(studentDto.getLastName());

        if (tempStudent.getAddress() == null) {
            tempStudent.setAddress(new Address());
        }

        tempStudent.getAddress().setCity(studentDto.getAddress().getCity());
        tempStudent.getAddress().setState(studentDto.getAddress().getState());
        tempStudent.getAddress().setStreet(studentDto.getAddress().getStreet());
        tempStudent.getAddress().setZip(studentDto.getAddress().getZip());

        Student student = studentRepo.save(tempStudent);
        return modelMapper.map(student, StudentDto.class);
    }

}
