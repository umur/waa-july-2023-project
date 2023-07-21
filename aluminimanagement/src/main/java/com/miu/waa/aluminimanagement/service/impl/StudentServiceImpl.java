package com.miu.waa.aluminimanagement.service.impl;

import com.miu.waa.aluminimanagement.model.Student;
import com.miu.waa.aluminimanagement.model.StudentPerState;
import com.miu.waa.aluminimanagement.model.dto.StudentDto;
import com.miu.waa.aluminimanagement.repository.StudentRepository;
import com.miu.waa.aluminimanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepo;

    private final ModelMapper modelMapper;
    @Override
    public List<StudentDto> findAll(String filter, String value) {
        List<StudentDto> students = new ArrayList<>();
        students = findAllStudents(filter, value);
        return students;
    }

    @Override
    public List<StudentPerState> noOfStudentsPerState() {
        return studentRepo.noOfJobsPerState();
    }

    private List<StudentDto> findAllStudents(String filter, String value){
        List<Student> students;
        switch (filter.toLowerCase()) {
            case "all":
                students = studentRepo.findAll();
                break;
            case "state":
                students = studentRepo.findByAddress_StateIgnoreCase(value);
                break;
            case "city":
                var state_city = value.split(".");
                students = studentRepo.findByAddress_StateIgnoreCaseAndAddress_CityIgnoreCase(state_city[0], state_city[1]);
                break;
            case "major":
                students = studentRepo.findByMajorContainingIgnoreCase(value);
                break;
            case "name":
                students = studentRepo.findByFirstnameContaining(value);
                break;
            case "universityid":
                students = studentRepo.findByUniversityId(Integer.parseInt(value));
                break;
            default:
                students = studentRepo.findAll();
                break;
        }
        return getDtoList(students);
    }

    public Student save(Student student) {
        return studentRepo.save(student);
    }

    private List<StudentDto> getDtoList(List<Student> students) {
        return students.stream().map(p -> {
            return getDto(p);
        }).toList();
    }

    private StudentDto getDto(Student user) {
        return modelMapper.map(user, StudentDto.class);

    }
}
