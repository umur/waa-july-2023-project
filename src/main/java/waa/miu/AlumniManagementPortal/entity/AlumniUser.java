package waa.miu.AlumniManagementPortal.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class AlumniUser {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @JsonIgnore
    private String password;
    private String email;
    private String phone;
    private String isDeleted;
    @Enumerated(EnumType.STRING)
    private Role role;

}
