package com.miu.waa.aluminimanagement.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("student")
public class Student extends  Person{

    private Double gpa;
}
