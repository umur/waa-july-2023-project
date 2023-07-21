package com.miu.waa.aluminimanagement.model;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

=======
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
>>>>>>> d04e8fcb214aa5015d586690d5daf5c64c82438d
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String role;
    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;
}
