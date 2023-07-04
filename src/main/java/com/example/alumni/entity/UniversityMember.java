package com.example.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "universitymember", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class UniversityMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String role;
}
