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

import com.twohundred.alumni.entity.CVId;
import com.twohundred.alumni.entity.dto.request.CVDto;
import com.twohundred.alumni.service.impl.CVServiceImpl;
import com.twohundred.alumni.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@RequestMapping("/cvs/")
@RestController
@RequiredArgsConstructor
public class CVController {
    private final CVServiceImpl cvService;
    private final SecurityUtil securityUtil;

    @GetMapping
    public List<CVDto> getCVs() {
        return cvService.getCVs(securityUtil.getCurrentUserId());
    }

    @GetMapping("{jobAdId}")
    public CVDto getCV(@PathVariable int jobAdId) {
        CVId cvId = new CVId();
        cvId.setJobAdId(jobAdId);
        cvId.setStudentId(securityUtil.getCurrentUserId());
        
        return cvService.findByIdDto(cvId);
    }

    @GetMapping("{jobAdId}/student/{studentId}")
    public CVDto getCVForCreator(@PathVariable int jobAdId, @PathVariable Long studentId) {
        CVId cvId = new CVId();

        cvId.setJobAdId(jobAdId);
        cvId.setStudentId(studentId);
        
        return cvService.findByIdDtoForCreator(cvId);
    }

    @PostMapping
    public CVDto create(@RequestBody CVDto cvDto) {
        cvDto.getId().setStudentId(securityUtil.getCurrentUserId());
        return cvService.create(cvDto);
    }

    @PutMapping("{jobAdId}")
    public CVDto update(@PathVariable int jobAdId, @RequestBody CVDto cvDto) {
        cvDto.getId().setStudentId(securityUtil.getCurrentUserId());
        cvDto.getId().setJobAdId(jobAdId);
        return cvService.update(cvDto);
    }

    @DeleteMapping("{jobAdId}")
    public CVDto delete(@PathVariable int jobAdId) {
        CVId cvId = new CVId();
        cvId.setJobAdId(jobAdId);
        cvId.setStudentId(securityUtil.getCurrentUserId());
        
        return cvService.delete(cvId);
    }
}
