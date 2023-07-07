package com.twohundred.alumni.entity;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    private Long id;

    private String major;

    private Double gpa;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;
}
