package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.Department;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends ListCrudRepository<Department,Long> {
}
