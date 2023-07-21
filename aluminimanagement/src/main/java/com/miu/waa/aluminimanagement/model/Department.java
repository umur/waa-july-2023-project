package com.miu.waa.aluminimanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
}
