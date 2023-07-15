package com.blue.alumniMangePortal.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {

    String updateFileToDesktop(Long id, MultipartFile file) throws IOException;
}
