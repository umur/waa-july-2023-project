package waa.miu.AlumniManagementPortal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
