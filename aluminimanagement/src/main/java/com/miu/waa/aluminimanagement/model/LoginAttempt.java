package com.miu.waa.aluminimanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class LoginAttempt {
    @Id
    private int id;
    private int personId;
    private int count;
    private Date dateTime;

}
