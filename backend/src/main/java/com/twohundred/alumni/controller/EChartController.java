package com.twohundred.alumni.controller;

import com.twohundred.alumni.service.EChartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/echart")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EChartController {

    @Autowired
    EChartService eChartService;

    @GetMapping("/numberOfJobsPerLocation")
    public Map<String, Long> numberOfJobsPerLocation() {
        log.info("Number of job advertisements per location.");
        return eChartService.numberOfJobsPerLocation();
    }

    @GetMapping("/numberOfStudentsPerState")
    public Map<String, Long> numberOfStudentsPerState() {
        log.info("Number of students per state.");
        return eChartService.numberOfStudentsPerState();
    }

    @GetMapping("/numberOfStudentsPerCity")
    public Map<String, Long> numberOfStudentsPerCity() {
        log.info("Number of students per city.");
        return eChartService.numberOfStudentsPerCity();
    }

    @GetMapping("/tags")
    public List<String> tags() {
        log.info("tags.");
        return eChartService.getAllTags();
    }

    @GetMapping("/tagsWithLocation")
    public Map<String, List<String>> tagsWithLocation() {
        log.info("Tags with location.");
        return eChartService.tagsWithLocation();
    }

    @GetMapping("/averageTimeSpentToFindJobPerGPARange")
    public Map<String, Long> averageTimeSpentToFindJobPerGPARange() {
        log.info("Average time spent to find a job per gpa range.");
        return eChartService.averageTimeSpentToFindJobPerGPARange();
    }
}