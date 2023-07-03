package com.example.geeks.repos;

import com.example.geeks.entity.Experience;
import com.example.geeks.entity.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ExperienceRepo extends ListCrudRepository<Experience, List<Experience>> {
    public List<Experience> getExperiencesByUserIs(User u);

    public List<Experience> getExperiencesByCompanyName(String cName);

    public Experience getExperienceByIdIs(Long id);
}
