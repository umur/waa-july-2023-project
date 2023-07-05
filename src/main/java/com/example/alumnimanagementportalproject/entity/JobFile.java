package com.example.alumnimanagementportalproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "job_files")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JobFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_advertisement_id", nullable = false)
    private JobAdvertisement jobAdvertisement;

    @Column(nullable = false)
    private String fileName;
}
