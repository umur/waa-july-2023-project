package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.JobsApplied;
import com.blue.alumniMangePortal.entity.Student;
import com.blue.alumniMangePortal.repository.JobsAppliedRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class JobsAppliedServiceImpl implements JobsAppliedService {
    private final JobsAppliedRepo jobsAppliedRepo;
    private final StudentService studentService;
    @Override
    public JobsApplied addJobsApplied(Long id, JobsApplied jobsApplied){
        Student student= studentService.getStudentById(id);
        jobsApplied.setStudent(student);
        return jobsAppliedRepo.save(jobsApplied);
    }
}
