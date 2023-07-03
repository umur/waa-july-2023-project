package com.example.geeks.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateAndTime;

    @ManyToOne
    private User userId;

    private String description;

    // Add constructors, getters, and setters
}
