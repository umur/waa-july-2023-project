package waa.miu.AlumniManagementPortal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName, lastName, password, email, phone, title;

    private boolean isAdmin, isDeleted;

    @OneToOne
    private Department department;

    @OneToOne
    private Address address;

    @OneToMany
    private List<Comment> comments;
}
