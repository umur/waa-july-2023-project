package waa.miu.AlumniManagementPortal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Faculty extends AlumniUser {

    private String title, isAdmin;

    @JsonBackReference(value = "faculty-department")
    @ManyToOne
    private Department department;

//    @JsonManagedReference(value = "faculty-address")
//    @OneToOne(mappedBy = "faculty")
    @OneToOne
    private Address address;

    @JsonManagedReference(value = "faculty-comment")
    @OneToMany(mappedBy = "faculty")
    private List<Comment> comments;
}
