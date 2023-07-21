package com.miu.waa.aluminimanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String role;
    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;
}
