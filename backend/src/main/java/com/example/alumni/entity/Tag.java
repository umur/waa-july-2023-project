package com.example.alumni.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@Data
@Table(name = "tag", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
@SQLDelete(sql = "UPDATE Tag SET deleted = true WHERE id=?")
@FilterDef(name = "deletedTagFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedTagFilter", condition = "deleted = :isDeleted")
public class Tag extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Resume> resume;

}
