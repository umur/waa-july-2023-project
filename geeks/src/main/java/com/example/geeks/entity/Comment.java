package com.example.geeks.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User commenter;

    @ManyToOne
    private User student;

    private LocalDateTime dateAndTime;
    private String comment;
    private boolean isDeleted;

    // Add constructors, getters, and setters
}
