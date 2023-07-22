package com.blue.alumniMangePortal.controller;

import com.blue.alumniMangePortal.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("uploadFile")
@RequiredArgsConstructor
public class FileUploadController {
    private final FileUploadService fileUploadService;
    @PostMapping("/{id}")
    public String updateCv(@PathVariable Long id,@RequestParam("file") MultipartFile file){
        try {
            return fileUploadService.updateFileToDesktop(id, file);
        } catch (IOException e) {
            System.out.println("not inserted");
            throw new RuntimeException(e);
        }
    }
}
