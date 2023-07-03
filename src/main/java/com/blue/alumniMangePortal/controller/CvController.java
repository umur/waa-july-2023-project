package com.blue.alumniMangePortal.controller;

import com.blue.alumniMangePortal.service.CvService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CvController {
    private final CvService cvService;
}
