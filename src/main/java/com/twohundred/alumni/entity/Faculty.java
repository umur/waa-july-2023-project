package com.twohundred.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@SQLDelete(sql = "UPDATE faculty SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Faculty {
    @Id
    private Long id;

    private String title;

    private Double salary;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User faculty;
}
