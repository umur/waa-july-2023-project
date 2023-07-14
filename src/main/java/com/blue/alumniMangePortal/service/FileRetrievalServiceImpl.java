package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Student;
import com.blue.alumniMangePortal.entity.UploadedFilePath;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileRetrievalServiceImpl implements FileRetrievalService {
    private final StudentService studentService;
    @Override
    public String getStudentCv(Long id){
        Student std=studentService.getStudentById(id);
        UploadedFilePath uploadedFilePath=std.getCv();
        String path=uploadedFilePath.getFilePath();
        return path;
    }
}
