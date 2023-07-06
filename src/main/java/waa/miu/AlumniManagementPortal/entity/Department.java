package waa.miu.AlumniManagementPortal.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonManagedReference(value = "faculty-department")
    @OneToMany(mappedBy = "department")
    private List<Faculty> faculties;

}
