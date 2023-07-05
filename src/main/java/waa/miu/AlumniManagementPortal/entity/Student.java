package waa.miu.AlumniManagementPortal.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName, lastName, password, email, phone;

    private boolean isCurrentlyEmployed, isDeleted;

    @JsonManagedReference(value = "student-address")
    @OneToOne(mappedBy = "student")
    private Address address;

    @JsonBackReference(value = "student-major")
    @ManyToOne
    private Major major;

    @JsonManagedReference(value = "student-jobAdverts")
    @OneToMany(mappedBy = "student")
    private List<JobAdvert> jobAdverts;

    @JsonBackReference(value = "student-currentWorkPlace")
    @ManyToOne
    private CurrentWorkPlace currentWorkPlace;

    @JsonManagedReference(value = "student-comment")
    @OneToMany(mappedBy = "student")
    private List<Comment> comments;

}
