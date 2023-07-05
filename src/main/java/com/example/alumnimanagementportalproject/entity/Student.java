package com.example.alumnimanagementportalproject.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "students")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("student")

public class Student extends User {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String major;

    @Lob
    private String cv;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<JobAdvertisement> jobAdvertisements;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<JobExperience> jobExperiences;
}
