package waa.miu.AlumniManagementPortal.service;

import waa.miu.AlumniManagementPortal.entity.Department;

import java.util.List;

public interface DepartmentService {

    public List<Department> getAllDepartments();
    public void deleteDepartment(Long id);
    public Department getDepartmentById(Long id);
    public Department updateDepartment(Department department);
    public Department createDepartment(Department department);
}
