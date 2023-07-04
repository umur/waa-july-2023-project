package com.alumni.Service;

import com.alumni.dtos.response.AttachmentDTO;
import com.alumni.dtos.response.AttachmentUploadResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AttachmentService {
    public AttachmentUploadResponseDTO uploadAttachment(MultipartFile file) throws IOException;

    public AttachmentDTO getAttachment(String filePath) throws IOException;
}
