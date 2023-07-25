package waa.miu.AlumniManagementPortal.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import waa.miu.AlumniManagementPortal.entity.Major;


@Repository
public interface MajorRepo extends ListCrudRepository<Major, Long> {
}
