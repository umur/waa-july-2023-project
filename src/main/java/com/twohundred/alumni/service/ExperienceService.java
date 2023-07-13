package com.twohundred.alumni.service;

import com.twohundred.alumni.entity.Experience;

import java.util.List;


public interface ExperienceService {
    Experience create(Experience experience);

    List<Experience> findAll();

    void update(Experience experience);

    Experience getExperience(Long id);

    void delete(Experience experience);
}
