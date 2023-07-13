package com.example.alumni.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

@Entity
@Data
@Table(name = "roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"role"})})
@SQLDelete(sql = "UPDATE Role SET deleted = true WHERE id=?")
@FilterDef(name = "deletedRoleFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedRoleFilter", condition = "deleted = :isDeleted")
public class Role extends BaseEntity {

    private String role;
}