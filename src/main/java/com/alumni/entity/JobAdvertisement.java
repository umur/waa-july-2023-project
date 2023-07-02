package com.alumni.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String state;
    private String city;
    private String company;
    private String attachments;
    private String postedBy;

    public JobAdvertisement(String state, String city, String company, String attachments, String postedBy) {
        this.state = state;
        this.city = city;
        this.company = company;
        this.attachments = attachments;
        this.postedBy = postedBy;
    }
}