//package com.blue.alumniMangePortal.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//
//@RestController
//@RequiredArgsConstructor
//public class FileUploadController {
//    @Value("${file.upload.directory}")
//    private String uploadDirectory;
//    @PostMapping("/upload")
//    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
//        if (file.isEmpty()) {
//            // Handle empty file error
//            return "File upload failed: Empty file";
//        }
//
//        try {
//            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//            File destinationFile = new File(uploadDirectory + File.separator + fileName);
//            file.transferTo(destinationFile);
//            return "File uploaded successfully";
//        } catch (IOException e) {
//            // Handle file upload error
//            return "File upload failed: " + e.getMessage();
//        }
//    }
//}
