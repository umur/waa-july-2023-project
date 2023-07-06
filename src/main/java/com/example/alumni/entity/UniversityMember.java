package com.example.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "universitymember", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class UniversityMember extends BaseEntity {

    private String email;

    private String role;
}
