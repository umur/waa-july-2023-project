package com.twohundred.alumni.service.impl;

import com.twohundred.alumni.entity.Experience;
import com.twohundred.alumni.entity.dto.request.ExperienceDto;
import com.twohundred.alumni.repository.ExperienceRepo;
import com.twohundred.alumni.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepo experienceRepo;

    @Override
    public Experience create(Experience experience) {
        return experienceRepo.save(experience);
    }

    @Override
    public List<Experience> findAll() {
        return experienceRepo.findAll();
    }

    @Override
    public Experience update(Experience experience) {
        return experienceRepo.save(experience);
    }

    @Override
    public List<Experience> getExperiencesByUserId(Long id) {
        return experienceRepo.findAllByUserId(id);
    }

    @Override
    public Experience getExperience(Long id) {
        return experienceRepo.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public void delete(Long id) {
        experienceRepo.deleteById(id);
    }
}
