package com.miu.waa.aluminimanagement.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class JobApplicationId implements Serializable {
    private int jobId;
    private int studentId;
}
