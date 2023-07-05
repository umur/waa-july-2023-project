package waa.miu.AlumniManagementPortal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @JsonBackReference(value = "faculty-department")
    @ManyToOne
    private Department department;

    @JsonManagedReference(value = "faculty-address")
    @OneToOne(mappedBy = "faculty")
    private Address address;

    @JsonManagedReference(value = "faculty-comment")
    @OneToMany(mappedBy = "faculty")
    private List<Comment> comments;
}
