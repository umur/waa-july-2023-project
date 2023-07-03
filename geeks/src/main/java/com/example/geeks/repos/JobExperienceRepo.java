package com.example.geeks.repos;

import com.example.geeks.entity.JobExperience;
import com.example.geeks.entity.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface JobExperienceRepo extends ListCrudRepository<JobExperience, List<JobExperience>> {
    public List<JobExperience> getJobExperiencesByUserIs(User u);

    public List<JobExperience> getJobExperiencesByCompanyName(String cName);

    public JobExperience getJobExperienceByIdIs(Long id);
}
