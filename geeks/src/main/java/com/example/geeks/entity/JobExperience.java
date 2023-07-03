package com.example.geeks.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Setter
@Getter
@Entity
public class JobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String role;
    private LocalDate dateStarted;
    private LocalDate dateEnded;
    private String description;

    @ManyToOne
    private User user;

    // Add constructors, getters, and setters
}

