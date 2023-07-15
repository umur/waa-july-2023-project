package com.blue.alumniMangePortal.repository;

import com.blue.alumniMangePortal.entity.UploadedFilePath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilePathUploadRepo extends JpaRepository<UploadedFilePath,Long> {

}
