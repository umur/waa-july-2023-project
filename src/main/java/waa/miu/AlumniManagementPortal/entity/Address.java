package waa.miu.AlumniManagementPortal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String city;

    private String state;

    private String zipcode;

    @JsonBackReference
    @OneToOne
    private Faculty faculty;

    @JsonBackReference
    @OneToOne
    private CurrentWorkPlace currentWorkPlace;

    @JsonBackReference
    @OneToOne
    private Student student;


}

