package com.example.geeks.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String role;
    private LocalDate dateStarted;
    private LocalDate dateEnded;
    private String description;
    // navigation properties
    @ManyToOne
    @JoinColumn
    private User user;
}
