package waa.miu.AlumniManagementPortal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonBackReference
    @ManyToOne
    private Department department;

    @JsonManagedReference
    @OneToOne(mappedBy = "faculty")
    private Address address;

    @JsonManagedReference
    @OneToMany(mappedBy = "faculty")
    private List<Comment> comments;
}
