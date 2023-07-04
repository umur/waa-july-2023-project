package com.example.alumni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alumni.entity.Experience;
import com.example.alumni.repository.ExperienceRepository;

import org.springframework.data.util.Pair;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    public Iterable<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    public Experience getExperienceById(long id) {
        return experienceRepository.findById(id).orElse(null);
    }

    public Experience createExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    public Pair<Boolean, Experience> updateExperience(Experience experience) {
        boolean exists = experienceRepository.existsById(experience.getExperience_id());
        experienceRepository.save(experience);
        return Pair.of(exists, experience);
    }

    public boolean deleteExperience(long id) {
        Experience existingExperience = experienceRepository.findById(id).orElse(null);
        if (existingExperience != null) {
            experienceRepository.delete(existingExperience);
            return true;
        }
        return false;
    }
}
