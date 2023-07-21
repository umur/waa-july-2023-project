package com.miu.waa.aluminimanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Student student;
    private String cvData;
    private boolean isDeleted = false;
}
