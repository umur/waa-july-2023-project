package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Department;

import java.util.List;

public interface DepartmentService {
    void addDepartment(Department department);
    List<Department> getDepartments();
    Department getDepartment(Long id);
    void updateDepartment(Long id, Department department);
    void deleteDepartment(Long id);
}
