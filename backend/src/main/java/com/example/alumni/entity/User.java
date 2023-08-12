package com.example.alumni.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Setter
@Getter
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@SQLDelete(sql = "UPDATE User SET deleted = true WHERE id=?")
@FilterDef(name = "deletedUserFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedUserFilter", condition = "deleted = :isDeleted")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String major;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = { "user_id", "roles_id" })
    )
    private List<Role> roles = new ArrayList<Role>();

    private Boolean enabled = Boolean.TRUE;


    @OneToMany(mappedBy = "user")
    private List<JobApplication> jobApplications;
}
