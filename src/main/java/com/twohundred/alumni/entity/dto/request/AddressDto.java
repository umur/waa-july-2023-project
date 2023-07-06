package com.twohundred.alumni.entity.dto.request;

import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private String street;
    private String zip;
    private String city;
    private String state;
}
