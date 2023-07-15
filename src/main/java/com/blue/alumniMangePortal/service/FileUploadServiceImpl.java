package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Student;
import com.blue.alumniMangePortal.entity.UploadedFilePath;
import com.blue.alumniMangePortal.repository.FilePathUploadRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements  FileUploadService {
    private final FilePathUploadRepo filePathUploadRepo;
    private final StudentService studentService;
    private String path="C:\\Users\\HP\\Desktop\\upload";
    @Override
    public String updateFileToDesktop(Long id, MultipartFile file) throws IOException {
        byte[] data=file.getBytes();
        Path path1= Paths.get(path,file.getOriginalFilename());
        Files.write(path1,data);
        String pathToDb=path1.toString();
        UploadedFilePath filePath=new UploadedFilePath();
        filePath.setFilePath(pathToDb);
        filePathUploadRepo.save(filePath);
        Student student=studentService.getStudentById(id);
        studentService.updateProfile(id,student);
        return "CV updated";
    }
}
