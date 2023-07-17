package com.example.geeks.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private LocalDateTime dateAndTime;
    private String comment;
    private boolean isDeleted;

    // navigation properties
    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private User commentGiver;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private User commentReceiver;
}
