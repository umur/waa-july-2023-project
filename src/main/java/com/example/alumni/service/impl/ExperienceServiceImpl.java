package com.example.alumni.service.impl;

import com.example.alumni.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.alumni.entity.Experience;
import com.example.alumni.repository.ExperienceRepository;

import org.springframework.data.util.Pair;

@Service
@Transactional
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public Iterable<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience getExperienceById(long id) {
        return experienceRepository.findById(id).orElse(null);
    }

    @Override
    public Experience createExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public Pair<Boolean, Experience> updateExperience(Experience experience) {
        boolean exists = experienceRepository.existsById(experience.getId());
        experienceRepository.save(experience);
        return Pair.of(exists, experience);
    }

    @Override
    public boolean deleteExperience(long id) {
        Experience existingExperience = experienceRepository.findById(id).orElse(null);
        if (existingExperience != null) {
            experienceRepository.delete(existingExperience);
            return true;
        }
        return false;
    }
}
