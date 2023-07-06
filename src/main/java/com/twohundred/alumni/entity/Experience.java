package com.twohundred.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@SQLDelete(sql = "UPDATE experience SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long from;
    private Long to;
    private String company;
    private String title;
    private Boolean deleted = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User student;
}
