package com.twohundred.alumni.service;

import com.twohundred.alumni.entity.Experience;

import java.util.List;


public interface ExperienceService {
    Experience create(Experience experience);

    List<Experience> findAll();

    Experience update(Experience experience);

    List<Experience> getExperiencesByUserId(Long id);

    Experience getExperience(Long id);

    void delete(Long id);
}
