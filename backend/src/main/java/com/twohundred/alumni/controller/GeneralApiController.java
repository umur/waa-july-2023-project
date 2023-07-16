package com.twohundred.alumni.controller;

import com.twohundred.alumni.entity.dto.request.JobAdvertisementDto;
import com.twohundred.alumni.service.JobAdvertisementService;
import com.twohundred.alumni.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GeneralApiController {

    private final JobAdvertisementService jobAdvertisementService;

    private final Mapper mapper;

    @GetMapping("/filter/job-advertisements")
    public ResponseEntity<?> filterAdvertisementsByParam(@RequestParam(value = "tag", required = false) String tag, @RequestParam(value = "city", required = false) String city, @RequestParam(value = "state", required = false) String state, @RequestParam(value = "company", required = false) String company) {
        List<JobAdvertisementDto> result = new ArrayList<>();
        try {
            result.addAll(jobAdvertisementService.filterJobAdsBySearchParam(tag, city, state, company).stream().map(mapper::mapJobAdToFilteredDTO).toList());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
        return ResponseEntity.ok(result);
    }
}
