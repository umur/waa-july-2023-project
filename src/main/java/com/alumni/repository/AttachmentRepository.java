package com.alumni.repository;

import com.alumni.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttachmentRepository extends JpaRepository<Attachment,Long> {

    public Optional<Attachment> findByName(String name);

}
