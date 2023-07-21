package waa.miu.AlumniManagementPortal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import waa.miu.AlumniManagementPortal.entity.JobsApplied;
import waa.miu.AlumniManagementPortal.repository.JobsAppliedRepo;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobsAppliedServiceImpl implements JobsAppliedService{
    private final JobsAppliedRepo jobsAppliedRepo;

    @Override
    public List<JobsApplied> findAll() {
        return jobsAppliedRepo.findAll();
    }

    @Override
    public JobsApplied findById(Long id) {
        return jobsAppliedRepo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Job advert with id "+id+" not found"));
    }

    @Override
    public JobsApplied create(JobsApplied jobsApplied) {
        jobsApplied.setDateApplied(LocalDateTime.now());
        return jobsAppliedRepo.save(jobsApplied);
    }

    @Override
    public JobsApplied update(Long id, JobsApplied jobAdvert) {
        JobsApplied existingJobApplied = findById(id);
        existingJobApplied.setStudents(jobAdvert.getStudents());
        existingJobApplied.setJobAdvert(jobAdvert.getJobAdvert());
        return jobsAppliedRepo.save(existingJobApplied);
    }

    @Override
    public JobsApplied partialUpdate(Long id, JobsApplied jobAdvert) {
        JobsApplied existingJobApplied = findById(id);
        existingJobApplied.setStudents(jobAdvert.getStudents());
        existingJobApplied.setJobAdvert(jobAdvert.getJobAdvert());
        return jobsAppliedRepo.save(existingJobApplied);
    }

    @Override
    public void delete(Long id) {
        jobsAppliedRepo.deleteById(id);
    }


    @Override
    public List<JobsApplied> findTop10JobsByDateApplied(){
        return jobsAppliedRepo.findTop10ByOrderByDateAppliedDesc();
    }


}
