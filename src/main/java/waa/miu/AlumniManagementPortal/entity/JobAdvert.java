package waa.miu.AlumniManagementPortal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class JobAdvert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobName, expectedSalary, jobDescription;

    private LocalDateTime dateAdded, dateApplied;

    @JsonBackReference(value = "student-jobAdverts")
    @ManyToOne
    private Student student;
}
