package com.twohundred.alumni.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twohundred.alumni.aspect.annotation.LogMe;
import com.twohundred.alumni.entity.dto.request.JobAdDtoWithCV;
import com.twohundred.alumni.entity.dto.request.JobAdvertisementDto;
import com.twohundred.alumni.service.impl.JobAdvertisementServiceImpl;
import com.twohundred.alumni.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/job-ads")
public class JobAdvertisementController {
    private final JobAdvertisementServiceImpl jobAdServiceImpl;
    private final SecurityUtil securityUtil;

    @LogMe
    @GetMapping("/created")
    public List<JobAdDtoWithCV> getCreatedJobAds() {
        return jobAdServiceImpl.getCreatedJobAds(securityUtil.getCurrentUserId());
    }

    @LogMe
    @GetMapping("/{id}")

    public JobAdvertisementDto get(@PathVariable int id) {
        return jobAdServiceImpl.getByIdDto(id);
    }

    @LogMe
    @GetMapping("/cv/{id}")

    public JobAdDtoWithCV getWithCV(@PathVariable int id) {
        return jobAdServiceImpl.getByIdDtoWithCV(id);
    }

    @LogMe
    @GetMapping
    public List<JobAdvertisementDto> getAll() {
        return jobAdServiceImpl.getAll();
    }

    @LogMe
    @PostMapping
    public JobAdvertisementDto create(@RequestBody JobAdvertisementDto jobAdvertisementDto) {
        return jobAdServiceImpl.create(jobAdvertisementDto, securityUtil.getCurrentUserId());
    }

    @LogMe
    @PutMapping("/{id}")
    public JobAdvertisementDto update(@PathVariable int id, @RequestBody JobAdvertisementDto jobAdvertisementDto) {
        jobAdvertisementDto.setId(id);
        return jobAdServiceImpl.update(jobAdvertisementDto, securityUtil.getCurrentUserId());
    }

    @LogMe
    @DeleteMapping("/{id}")
    public JobAdvertisementDto delete(@PathVariable int id) {
        return jobAdServiceImpl.delete(id, securityUtil.getCurrentUserId());
    }
}
