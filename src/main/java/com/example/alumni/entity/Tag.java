package com.example.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@Data
@SQLDelete(sql = "UPDATE Tag SET deleted = true WHERE id=?")
@FilterDef(name = "deletedTagFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedTagFilter", condition = "deleted = :isDeleted")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Resume> resume;

    private boolean deleted = Boolean.FALSE;

}
