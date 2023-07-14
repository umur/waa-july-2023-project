package com.twohundred.alumni.entity.dto.request;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto address;
}
