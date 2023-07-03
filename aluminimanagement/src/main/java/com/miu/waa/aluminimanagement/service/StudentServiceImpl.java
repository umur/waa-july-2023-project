package com.miu.waa.aluminimanagement.service;

import com.miu.waa.aluminimanagement.model.Department;
import com.miu.waa.aluminimanagement.model.Student;
import com.miu.waa.aluminimanagement.repository.DepartmentRepository;
import com.miu.waa.aluminimanagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository repository;

    private final DepartmentRepository departmentRepository;
    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Student save(Student student) {
        Department department = departmentRepository.findById(student.getDepartment().getId()).get();
        student.setDepartment(department);
        Student created = repository.save(student);
        return created;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
