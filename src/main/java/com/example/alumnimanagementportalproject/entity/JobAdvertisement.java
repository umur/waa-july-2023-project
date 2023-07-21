package com.example.alumnimanagementportalproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "job_advertisements")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;


    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(nullable = false)
    private String companyName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address location;

    @Column(name = "tag")
    @ElementCollection(targetClass = String.class)
    private List<String> tags;

    @OneToMany(mappedBy = "jobAdvertisement", cascade = CascadeType.ALL)
    private List<JobFile> files;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private LocalDateTime dateCreated;

    @Column(nullable = false)
    private LocalDateTime dateUpdated;


}
