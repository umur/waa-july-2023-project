package com.blue.alumniMangePortal.controller;

import com.blue.alumniMangePortal.service.FileRetrievalService;
import com.blue.alumniMangePortal.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FileRetrievalController {
    private final FileRetrievalService fileRetrievalService;
    @GetMapping("/retrieve/{id}")
    public String getPath(@PathVariable Long id){
        return fileRetrievalService.getStudentCv(id);
    }
}
