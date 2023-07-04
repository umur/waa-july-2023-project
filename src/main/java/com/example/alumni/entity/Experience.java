package com.example.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String companyName;
    private String city;
    private String State;
    private String companyDescription;
    private String jobTitle;
    private LocalDate startDate;
    private LocalDate exitDate;

}

