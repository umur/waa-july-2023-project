package waa.miu.AlumniManagementPortal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @JsonBackReference(value = "faculty-comment")
    @ManyToOne
    private Faculty faculty;

    @JsonBackReference(value = "student-comment")
    @ManyToOne
    private Student student;
}
