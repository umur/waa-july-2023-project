package com.twohundred.alumni.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Staff {
    @Id
    private Long id;

    private String title;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User staff;
}
