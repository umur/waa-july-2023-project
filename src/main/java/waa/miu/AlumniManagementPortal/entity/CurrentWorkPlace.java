package waa.miu.AlumniManagementPortal.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CurrentWorkPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName, position;

    @JsonManagedReference(value = "student-currentWorkPlace")
    @OneToMany(mappedBy = "currentWorkPlace")
    private List<Student> students;

    @JsonManagedReference(value = "currentWorkPlace-address")
    @OneToOne(mappedBy = "currentWorkPlace")
    private Address address;
}
