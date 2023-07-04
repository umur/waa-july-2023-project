package waa.miu.AlumniManagementPortal.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CurrentWorkPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName, position;

    @JsonManagedReference
    @OneToOne(mappedBy = "currentWorkPlace")
    private Address address;
}
