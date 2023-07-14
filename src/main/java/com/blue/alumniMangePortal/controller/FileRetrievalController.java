//package com.blue.alumniMangePortal.controller;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.File;
//import java.io.IOException;
//
//@RestController
//@RequestMapping
//public class FileRetrievalController {
//    @Value("${file.upload.directory}")
//    private String uploadDirectory;
//
//    @GetMapping("/files/{filename}")
//    public Resource downloadFile(@PathVariable String filename) throws IOException {
//        File file = new File(uploadDirectory + File.separator + filename);
//        Resource resource = new UrlResource(file.toURI());
//
//        if (resource.exists() && resource.isReadable()) {
//            return resource;
//        } else {
//            throw new RuntimeException("File not found: " + filename);
//        }
//    }
//}
