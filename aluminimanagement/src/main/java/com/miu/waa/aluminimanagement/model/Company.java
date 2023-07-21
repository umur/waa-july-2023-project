package com.miu.waa.aluminimanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private boolean isDeleted=false;
}
