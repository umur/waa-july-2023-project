package com.example.geeks.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appId;


    private boolean isDeleted;

    @ManyToOne
    private User student;
    @ManyToOne
    private Advertisement advertisement;

}