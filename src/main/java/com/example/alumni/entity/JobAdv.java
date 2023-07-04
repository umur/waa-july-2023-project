package com.example.alumni.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class JobAdv {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String positionTitle;
    private String Description;
    private Double minSalary;
    private Double maxSalary;
    private String requiredSkills;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tag> tags;
}
