package com.twohundred.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@SQLDelete(sql = "UPDATE staff SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Staff {
    @Id
    private Long id;

    private String title;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User staff;
}
