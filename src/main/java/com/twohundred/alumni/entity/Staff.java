package com.twohundred.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Staff {
    @Id
    private Long id;

    private String title;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;
}
