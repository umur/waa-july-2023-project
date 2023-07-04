package waa.miu.AlumniManagementPortal.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import waa.miu.AlumniManagementPortal.entity.Major;
import waa.miu.AlumniManagementPortal.entity.Student;

import java.util.List;

@Repository
public interface MajorRepo extends ListCrudRepository<Major, Long> {

    List<Student> findAllByMajorName(String major);

}
