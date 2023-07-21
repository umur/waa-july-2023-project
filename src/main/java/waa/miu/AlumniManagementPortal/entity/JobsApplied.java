package waa.miu.AlumniManagementPortal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class JobsApplied {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateApplied;

    @OneToOne
    private JobAdvert jobAdvert;

    @ManyToMany
    private List<Student> students;

}
