package com.miu.waa.aluminimanagement.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Entity
@Data
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private String name;
    private String originalName;
    private Long size;
    private String type;
    private String location;
    @CreatedBy
    private String createdBy;
    @CreatedDate
    private Instant createdDate;
}
