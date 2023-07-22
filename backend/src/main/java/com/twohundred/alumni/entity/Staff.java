package com.twohundred.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "staffs")
public class Staff extends User{

    private String title;
}
