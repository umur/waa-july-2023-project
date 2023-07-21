package com.miu.waa.aluminimanagement.service;

import com.miu.waa.aluminimanagement.model.Department;
import com.miu.waa.aluminimanagement.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class

DepartmentServiceImpl implements DepartmentService {
    public final DepartmentRepository repository;

    @Override
    public List<Department> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Department> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Department save(Department department) {
        return repository.save(department);
    }

    @Override
    public void delete(Long id) {
     repository.deleteById(id);
    }

//    public Department update(Department department) {
//        return repository.save(department);
//    }

}
