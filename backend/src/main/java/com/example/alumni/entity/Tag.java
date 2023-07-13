package com.example.alumni.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "tag", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
@SQLDelete(sql = "UPDATE Tag SET deleted = true WHERE id=?")
@FilterDef(name = "deletedTagFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedTagFilter", condition = "deleted = :isDeleted")
public class Tag implements Serializable {

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

    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Resume> resume;

}
