package com.example.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long experience_id;

    private String company_name;
    private String city;
    private String State;
    private String company_description;
    private String job_title;
    private LocalDate start_date;
    private LocalDate exit_date;

}

