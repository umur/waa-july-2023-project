package com.example.alumni.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"role"})})
@SQLDelete(sql = "UPDATE Role SET deleted = true WHERE id=?")
@FilterDef(name = "deletedRoleFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedRoleFilter", condition = "deleted = :isDeleted")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonIgnore
    private boolean deleted = Boolean.FALSE;

    @JsonIgnore
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @Version
    private int version;

    private String role;
}