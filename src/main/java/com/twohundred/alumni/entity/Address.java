package com.twohundred.alumni.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Data
@Embeddable
//@SQLDelete(sql = "UPDATE address SET deleted = true WHERE id=?")
//@Where(clause = "deleted = false")
public class Address {
    private String street;
    private String zip;
    private String city;
    private String state;
}
