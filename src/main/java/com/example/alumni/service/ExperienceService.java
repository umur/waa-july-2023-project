package com.example.alumni.service;

import com.example.alumni.entity.Experience;
import org.springframework.data.util.Pair;

public interface ExperienceService {
    Iterable<Experience> getAllExperiences();

    Experience getExperienceById(long id);

    Experience createExperience(Experience experience);

    Pair<Boolean, Experience> updateExperience(Experience experience);

    boolean deleteExperience(long id);
}
