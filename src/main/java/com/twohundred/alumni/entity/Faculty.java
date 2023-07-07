package com.twohundred.alumni.entity;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
public class Faculty {
    @Id
    private Long id;

    private String title;

    private Double salary;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;
}
