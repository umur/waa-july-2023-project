package com.twohundred.alumni.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String companyName;
    private Boolean deleted;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
