package waa.miu.AlumniManagementPortal.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import waa.miu.AlumniManagementPortal.entity.Department;

@Repository
public interface DepartmentRepo extends ListCrudRepository<Department,Long> {
}
