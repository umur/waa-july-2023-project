package com.example.geeks.controller;

import com.example.geeks.entity.Experience;
import com.example.geeks.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiences")
@CrossOrigin
public class ExperienceController {

    @Qualifier("exs")
    @Autowired
    ExperienceService experienceService;

    /*
    @PostMapping
    public Experience addExperience(@RequestBody Experience experience) {
        Experience savedExperience = experienceService.addExperience(experience);
        return savedExperience;
    }
    */


    @GetMapping
    public List<Experience> getAllExperiences() {
        List<Experience> experiences = experienceService.getAllExperiences();
        return experiences;
    }

    @GetMapping("/user/{userId}")
    public List<Experience> getExperiencesByUser(@PathVariable Long userId) {
        // Assuming "userId" refers to the user's ID
        List<Experience> experiences = experienceService.getExperiencesByUser(userId);
        return experiences;
    }

    @GetMapping("/company/{companyName}")
    public List<Experience> getExperiencesByCompanyName(@PathVariable String companyName) {
        List<Experience> experiences = experienceService.getExperiencesByCompanyName(companyName);
        return experiences;
    }

    @GetMapping("/{id}")
    public Experience getExperienceById(@PathVariable Long id) {
        Experience experience = experienceService.getExperienceById(id);
        if (experience != null) {
            return experience;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}/{cName}")
    public void deleteExperience(@PathVariable Long id, @PathVariable String cName) {
        experienceService.deleteExperience(id, cName);
    }
}
