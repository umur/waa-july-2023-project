package waa.miu.AlumniManagementPortal.service;

import waa.miu.AlumniManagementPortal.entity.JobsApplied;

import java.util.List;

public interface JobsAppliedService {
    List<JobsApplied> findAll();

    JobsApplied findById(Long id);

    JobsApplied create(JobsApplied jobsApplied);

    JobsApplied update(Long id, JobsApplied jobAdvert);

    JobsApplied partialUpdate(Long id, JobsApplied jobAdvert);

    void delete(Long id);

    List<JobsApplied> findTop10JobsByDateApplied();
}
