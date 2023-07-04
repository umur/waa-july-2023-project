package waa.miu.AlumniManagementPortal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @OneToOne(mappedBy = "student")
    private Address address;

    @JsonBackReference
    @ManyToOne
    private Major major;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<JobAdvert> jobAdverts;

    @JsonBackReference
    @ManyToOne
    private CurrentWorkPlace currentWorkPlace;

    @JsonManagedReference
    @OneToMany(mappedBy = "student")
    private List<Comment> comments;

    private boolean isCurrentlyEmployed, isDeleted;


}
