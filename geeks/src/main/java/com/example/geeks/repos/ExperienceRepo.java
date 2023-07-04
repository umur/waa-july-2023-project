package com.example.geeks.repos;

import com.example.geeks.entity.Experience;
import com.example.geeks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ExperienceRepo extends JpaRepository<Experience, Long> {

    List<Experience> getExperiencesByUser_Id(Long userId);

    List<Experience> getExperiencesByCompanyName(String companyName);

    Experience getExperienceById(Long experienceId);
}
