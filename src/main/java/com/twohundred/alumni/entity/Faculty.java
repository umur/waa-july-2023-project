package com.twohundred.alumni.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Faculty {
    @Id
    private Long id;

    private String title;

    private Double salary;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User faculty;
}
