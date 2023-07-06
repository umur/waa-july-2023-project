package waa.miu.AlumniManagementPortal.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String majorName;

    @JsonManagedReference(value = "student-major")
    @OneToMany(mappedBy = "major")
    private List<Student> students;
}
