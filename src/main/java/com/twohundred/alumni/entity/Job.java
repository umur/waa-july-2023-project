package com.twohundred.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Data
@SQLDelete(sql = "UPDATE job SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String companyName;
    private Boolean deleted = Boolean.FALSE;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;
}
