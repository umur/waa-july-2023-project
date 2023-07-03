package com.twohundred.alumni.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {
    @Id
    private Long id;

    private String major;

    private Double gpa;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User student;

}
