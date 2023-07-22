package com.twohundred.alumni.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "faculties")
public class Faculty extends User {

    private String title;

    private Double salary;
}
