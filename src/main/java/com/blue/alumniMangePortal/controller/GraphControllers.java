package com.blue.alumniMangePortal.controller;

import com.blue.alumniMangePortal.service.GraphService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/auth")
public class GraphControllers {
    private final GraphService graphService;
    @GetMapping("/numberPerCity")
    public List<Map<String, Integer>> getNumberStudentsPerCity(){
        return graphService.getNumberStudentsPerCity();
    }

    @GetMapping("/numberPerState")
    public List<Map<String, Integer>> getNumberStudentsPerState() {
        return graphService.getNumberStudentsPerState();
    }
    @GetMapping("/jobsAdvertisedPerState")
    public List<Map<String, Integer>> getJobsAdvertisePerLocation(){
        return graphService.getJobsAdvertisePerState();
    }

}
