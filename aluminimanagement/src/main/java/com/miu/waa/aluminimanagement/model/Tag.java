package com.miu.waa.aluminimanagement.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String tag;

}
