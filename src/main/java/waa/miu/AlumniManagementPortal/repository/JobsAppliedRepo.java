package waa.miu.AlumniManagementPortal.repository;

import org.springframework.data.repository.ListCrudRepository;
import waa.miu.AlumniManagementPortal.entity.JobAdvert;
import waa.miu.AlumniManagementPortal.entity.JobsApplied;

import java.util.List;

public interface JobsAppliedRepo extends ListCrudRepository<JobsApplied, Long> {
    List<JobsApplied> findTop10ByOrderByDateAppliedDesc();
}
