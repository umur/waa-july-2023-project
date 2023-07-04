package waa.miu.AlumniManagementPortal.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import waa.miu.AlumniManagementPortal.entity.JobAdvert;

@Repository
public interface JobAdvertRepo extends ListCrudRepository<JobAdvert, Long> {
}
