package com.twohundred.alumni.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long from;
    private Long to;
    private String company;
    private String title;
    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User student;
}
