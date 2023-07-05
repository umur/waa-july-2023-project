package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Department;
import com.blue.alumniMangePortal.repository.DepartmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepo departmentRepo;

    @Override
    public void addDepartment(Department department) {
        departmentRepo.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public Department getDepartment(Long id) {
        Optional<Department> departmentOptional = departmentRepo.findById(id);
        return departmentOptional.orElseThrow();
    }

    @Override
    public void updateDepartment(Long id, Department department) {
        Department departmentToUpdate = getDepartment(id);
        departmentToUpdate.setName(departmentToUpdate.getName());
        departmentRepo.save(departmentToUpdate);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepo.deleteById(id);
    }
}
