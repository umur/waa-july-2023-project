package com.blue.alumniMangePortal.controller;

import com.blue.alumniMangePortal.service.MajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MajorController {
    private final MajorService majorService;
}
