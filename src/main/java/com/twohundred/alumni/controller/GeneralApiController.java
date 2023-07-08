package com.twohundred.alumni.controller;

import com.twohundred.alumni.entity.dto.request.JobAdvertisementDto;
import com.twohundred.alumni.service.JobAdvertisementService;
import com.twohundred.alumni.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class GeneralApiController {

    private final JobAdvertisementService jobAdvertisementService;

    private final Mapper mapper;

    @GetMapping("/filter/job-advertisements")
    public List<JobAdvertisementDto> filterAdvertisementsByParam(@RequestParam(value = "tag", required = false) String tag, @RequestParam(value = "city", required = false) String city, @RequestParam(value = "state", required = false) String state, @RequestParam(value = "company", required = false) String company) {
        return jobAdvertisementService.filterJobAdsBySearchParam(tag, city, state, company).stream().map(mapper::mapJobAdToFilteredDTO).collect(Collectors.toList());
    }
}
