package com.blue.alumniMangePortal.service.impl;

import com.blue.alumniMangePortal.service.CvService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CvServiceImpl implements CvService {
    private final CvService cvService;
}
